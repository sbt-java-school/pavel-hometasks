package com.norg.home02.listspeed;

import java.math.BigDecimal;

/**
 * Created by Norg on 12.08.2016.
 */
public class TestObject {
    private BigDecimal[][] veryBigArray = new BigDecimal[1000][1000];
    {
        for (int i = 0; i < veryBigArray.length; i++) {
            for (int j = 0; j < veryBigArray[i].length; j++) {
                veryBigArray[i][j] = new BigDecimal(SpeedTest.COUNT);
            }
        }
    }
}
