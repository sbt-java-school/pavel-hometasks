package com.norg.home12.streams;

import java.util.function.Supplier;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public class AbstractPipeline {
    private final AbstractPipeline sourceStage;
    private Supplier<?> sourceSupplier;
    private boolean closed;

    private final AbstractPipeline previousStage;
    private AbstractPipeline nextStage;

    private int depth;

    AbstractPipeline(Supplier<?> source,
                     int sourceFlags, boolean parallel) {
        this.previousStage = null;
        this.sourceSupplier = source;
        this.sourceStage = this;
        this.depth = 0;
        closed = false;
    }
}
