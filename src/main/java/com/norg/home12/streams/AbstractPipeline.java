package com.norg.home12.streams;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public abstract class AbstractPipeline {
    private List<? extends Consumer> source;

    protected AbstractPipeline previousStage;
    protected AbstractPipeline firstStage;

    protected AbstractPipeline(List<? extends Consumer> source) {
        this.source = source;
        previousStage = null;
        firstStage = this;
    }

    protected AbstractPipeline(AbstractPipeline previous) {
        this.previousStage = previous;
        this.source = null;
    }

    final Consumer processWrap(Consumer wrap) {
        AbstractPipeline p = this;
        while (p.previousStage != null) {
            wrap = p.unwrap(wrap);
            p = p.previousStage;
        }
        return wrap;
    }

    final void acceptAll(Consumer wrap) {
        List<? extends Consumer> list = firstStage.source;
        for (Consumer consumer:
             list) {
            wrap.accept(consumer);
        }
    }

    abstract Consumer unwrap(Consumer wrap);
}
