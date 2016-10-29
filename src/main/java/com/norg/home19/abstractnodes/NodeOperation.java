package com.norg.home19.abstractnodes;

import java.util.Map;

/**
 * Функциональный интерфейс для передачи в ноду произвольной операции с входящими параметрами
 */
public interface NodeOperation {
    double process(Map<String, Object> params);
}
