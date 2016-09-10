package com.norg.home04;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Norg on 13.08.2016.
 */
public class TruckDaoMemoryImpl implements TruckDao {

    @Override
    public List<Truck> list() {
        return Arrays.asList(
                new Truck(14, 10),
                new Truck(21, 20),
                new Truck(13, 35),
                new Truck(4, 50)
        );
    }
}
