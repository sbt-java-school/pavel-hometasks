package com.norg.home12;

/**
 * Created by pavel.krizhanovskiy on 19.09.2016.
 */
public class AbstractPipeline {
    private final AbstractPipeline sourceStage;

    private final AbstractPipeline previousStage;
    private AbstractPipeline nextStage;

    private int depth;
}
