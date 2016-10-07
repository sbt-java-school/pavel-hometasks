package com.norg.home19;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class NodesTest {

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
    public void homeTaskApproved() {
        //реализовать
    }

    @Test
    public void homeTaskRefused() {
        //реализовать
    }

}
