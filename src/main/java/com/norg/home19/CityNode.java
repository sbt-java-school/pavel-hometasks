package com.norg.home19;

import com.norg.home19.abstractnodes.AbstractNode;

/**
 * Листовая нода, проверяющая город из входных параметров на соответствие заданному в конструкторе
 */
public class CityNode extends AbstractNode {
    public CityNode(String city) {
        super(params -> {
            Object value = params.get("City");
            if (value == null) {
                throw new RuntimeException("No such parameter in map!");
            }

            if(value.equals(city)) {
                return 1;
            }else {
                return 0;
            }
        });
    }
}
