package com.norg.home19;

import com.norg.home19.abstractnodes.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class NodesTest {
    private Node compareNode;

    @Test
    public void nodesDemo() {
        Map<String, Object> params = new HashMap<>();
        params.put("Value1", 0.6);
        params.put("Value2", 1d);
        params.put("City", "Novosibirsk");

        Node rootNode = new PlusNode();
        rootNode.addNode(new CityNode("Novosibirsk"));

        Node averageNode = new AverageNode();
        averageNode.addNode(new ParametersNode("Value1"));
        averageNode.addNode(new ParametersNode("Value2"));

        rootNode.addNode(averageNode);

        Assert.assertEquals("Результат отличается от ожидаемого!", 1.8, rootNode.getResult(params), 0);
    }

    @Test
    //Проверяет, что при выполнении условия amountOfCredit/periodOfMonths < salary/2 кредит одобряется
    public void homeTaskApproved() {
        Map<String, Object> params = new HashMap<>();
        params.put("Salary", 60_000);
        params.put("SalaryDivider", 2);
        params.put("AmountOfCredit", 200_000);
        params.put("Months", 24);

        Assert.assertTrue("Credit must be approved!", compareNode.getResult(params) < 0f);
    }

    @Test
    //Проверяет, что при невыполнении условия amountOfCredit/periodOfMonths < salary/2 кредит не одобряется
    public void homeTaskRefused() {
        Map<String, Object> params = new HashMap<>();
        params.put("Salary", 50_000);
        params.put("SalaryDivider", 2);
        params.put("AmountOfCredit", 2_000_000);
        params.put("Months", 12);

        Assert.assertTrue("Credit must be refused!", compareNode.getResult(params) >= 0f);
    }

    @Before
    public void setNode() {
        //создаем ноды снизу вверх (мне так удобнее)
        Node salaryNode = new DivideNode("Salary", "SalaryDivider");
        Node monthlyPayNode = new DivideNode("AmountOfCredit", "Months");

        compareNode = new CompareNode();
        compareNode.addNode(monthlyPayNode);
        compareNode.addNode(salaryNode);
    }
}
