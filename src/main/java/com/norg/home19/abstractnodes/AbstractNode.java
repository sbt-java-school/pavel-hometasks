package com.norg.home19.abstractnodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Абстрактный класс ноды, на основе которого создаются конкретные ноды с логикой вычислений.
 * Для создания новой узловой ноды надо унаследоваться от этого класса, переопределив метод getResultByChildNodes().
 * Пример узловой ноды см. в классах AverageNode, PlusNode.
 * Для создания листовой ноды, считающей результат на основе входных параметров, нужно в конструктор передать лямбду
 * с логикой вычислений. Примеры листовой ноды см. в классах CityNode, ParametersNode.
 */
public abstract class AbstractNode implements Node {
    protected List<Node> nodes = new ArrayList<>();
    private final NodeOperation operation;

    public void addNode(Node node) {
        if(operation != null) {
            throw new UnsupportedOperationException("Это листовая нода, у нее не может быть потомков!");
        }
        nodes.add(node);
    }

    public void removeNode(Node node) {
        if(operation != null) {
            throw new UnsupportedOperationException("Это листовая нода, у нее не может быть потомков!");
        }
        nodes.remove(node);
    }

    public AbstractNode(NodeOperation operation) {
        this.operation = operation;
    }

    //Метод, реализующий различную логику получения значения для узловых и листовых нод. Не может быть переопределен.
    public final double getResult(Map<String, Object> values) {
        if(nodes.isEmpty()) {
            return operation.process(values);
        }else {
            return getResultByChildNodes(values);
        }
    }

    //Метод, который должен быть переопределен для листовых нод.
    protected double getResultByChildNodes(Map<String, Object> values) {
        throw new UnsupportedOperationException("Это листовая нода, у нее не может быть потомков!");
    }
}
