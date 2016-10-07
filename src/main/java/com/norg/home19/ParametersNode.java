package com.norg.home19;

/**
 * Листовая нода, возвращающая значение из мапы по заданному ключу
 */
public class ParametersNode extends AbstractNode {
    public ParametersNode(String key) {
        super(params -> (double) params.get(key));
    }
}
