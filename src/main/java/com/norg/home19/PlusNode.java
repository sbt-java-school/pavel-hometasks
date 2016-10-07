package com.norg.home19;

import java.util.Map;

/**
 * Узловая нода, складывающая результаты потомков
 */
public class PlusNode extends AbstractNode {
    public PlusNode() {
        super(null);
    }

    @Override
    public double getResultByChildNodes(Map<String, Object> values) {
        double result = 0;
        for (Node node : nodes) {
            result += node.getResult(values);
        }
        return result;
    }
}
