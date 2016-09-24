package com.norg.home12;

import java.util.List;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public abstract class AbstractPipeline<P_IN, E_OUT> {
    private List source;

    protected AbstractPipeline previousStage;

    protected AbstractPipeline(List<E_OUT> source) {
        this.source = source;
        this.previousStage = null;
    }

    protected AbstractPipeline(AbstractPipeline<?, P_IN> previous) {
        this.previousStage = previous;
        this.source = null;
    }

}
