package com.norg.home19;

import java.util.Map;

/**
 * Узловая нода, возвращающая среднее значение результатов потомков
 */
public class AverageNode extends AbstractNode {
    public AverageNode() {
        super(null);
    }

    @Override
    public double getResultByChildNodes(Map<String, Object> values) {
        double sum = 0;
        for (Node node :
                nodes) {
            sum += node.getResult(values);
        }
        return sum/nodes.size();
    }
}
