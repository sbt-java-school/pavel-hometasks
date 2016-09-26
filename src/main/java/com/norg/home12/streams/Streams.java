package com.norg.home12.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public class Streams extends AbstractPipeline {
    protected Streams(List source) {
        super(source);
    }

    public Streams(Streams streams) {
        super(streams);
    }

    public static Streams of(List list) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Streams filter(Predicate predicate) {
        return new Streams(this) {
            @Override
            Consumer unwrap(Consumer wrap) {
                return (o) -> {
                    if(predicate.test(o)) {
                        wrap.accept(o);
                    }
                };
            }
        };
    }

    public Streams transform() {

        return this;
    }

    public <K, V> Map<K, V> toMap(Function<Object, ? extends K> keyMapper, Function<Object, ? extends V> valueMapper) {
        HashMap<K, V> result = new HashMap<K, V>();
        acceptAll(processWrap(
                (item) -> result.put(keyMapper.apply(item), valueMapper.apply(item))
        ));

        return result;

    }

    @Override
    Consumer unwrap(Consumer wrap) {
        throw new IllegalStateException();
    }
}
