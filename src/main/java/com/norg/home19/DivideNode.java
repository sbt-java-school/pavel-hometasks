package com.norg.home19;

import com.norg.home19.abstractnodes.AbstractNode;

/**
 * Листовая нода. Делит одно значение из входной мапы на другое
 */
public class DivideNode extends AbstractNode {
    public DivideNode(String dividendKey, String dividerKey) {
        super(params -> {
            Object value = params.get(dividendKey);
            double dividend = value instanceof Number ? ((Number) value).doubleValue() : 0;
            value = params.get(dividerKey);
            double divider = value instanceof Number ? ((Number) value).doubleValue() : 0;

            return dividend/divider;
        });
    }
}
