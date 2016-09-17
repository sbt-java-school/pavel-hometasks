package com.norg.home12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Norg on 14.09.2016.
 */
public class BestStream<T> {

    private List<T> storage = new ArrayList<>();

    private BestStream() {
    }

    private BestStream (List<T> list) {
        storage.addAll(list);
    }

    //принимает	коллекцию	и	создает	новый	объект	Streams
    @SuppressWarnings("unchecked")
    static BestStream of(List list) {
        return new BestStream(list);
    }

    //оставляет	в	коллекции	только	те	элементы,	которые	удовлетворяют	условию	в	лямбде
    BestStream filter(Predicate p) {
        return null;
    }

    //преобразует	элемент	в	другой
    BestStream transform(Predicate condition) {
        return null;
    }

    //принимает	2	лямбды	для	создания	мапы,	в	одной	указывается,	что	использовать	в
    // качестве	ключа,	в	другой,	что	в	качестве	значения
    Map toMap(Predicate key, Predicate value) {
        return null;
    }
}
