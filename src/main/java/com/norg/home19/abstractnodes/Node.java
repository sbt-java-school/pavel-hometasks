package com.norg.home19.abstractnodes;

import java.util.Map;

/**
 * Общий интерфейс для нод
 */
public interface Node {
    void addNode(Node node);
    void removeNode(Node node);

    //Получить результат от ноды. Универсальный метод, содержащий общую логику.
    double getResult(Map<String, Object> values);
}
