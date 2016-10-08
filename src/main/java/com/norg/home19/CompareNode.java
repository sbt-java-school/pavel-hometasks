package com.norg.home19;

import com.norg.home19.abstractnodes.AbstractNode;
import com.norg.home19.abstractnodes.Node;

import java.util.Map;

/**
 * Узловая нода сравнения. Работает только с двумя потомками.
 */
public class CompareNode extends AbstractNode {
    public CompareNode() {
        super(null);
    }

    @Override
    protected double getResultByChildNodes(Map<String, Object> values) {
        return nodes.get(0).getResult(values) - nodes.get(1).getResult(values);
    }

    @Override
    public void addNode(Node node) {
        if(nodes.size() == 2) {
            throw new RuntimeException("Эта узловая нода работает только с двумя потомками!");
        }
        super.addNode(node);
    }
}
