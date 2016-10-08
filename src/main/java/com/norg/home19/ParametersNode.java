package com.norg.home19;

import com.norg.home19.abstractnodes.AbstractNode;

/**
 * Листовая нода, возвращающая значение из мапы по заданному ключу
 */
public class ParametersNode extends AbstractNode {
    public ParametersNode(String key) {
        super(params -> {
            Object value = params.get(key);
            if(value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return 0;
        });
    }
}
