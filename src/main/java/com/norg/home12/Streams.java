package com.norg.home12;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public class Streams<P_IN, E_OUT> extends AbstractPipeline {
    protected Streams(List source) {
        super(source);
    }

    public Streams(Streams<P_IN, E_OUT> streams) {
        super(streams);
    }

    public static Streams of(List list) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Streams filter(Predicate predicate) {
        return new Streams(this);
    }

    public Streams transform() {

        return this;
    }

    public Map toMap() {
        return null;
    }
}
