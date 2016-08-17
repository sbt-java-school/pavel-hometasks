package com.norg.home04;

import com.norg.home04.multimap.MultiMap;
import com.norg.home04.multimap.MultiMapArrayList;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application {
    private Map<Long, Truck> truckRegistry = new TreeMap<>();
    private MultiMap<String, Truck> multiMap = new MultiMapArrayList<>();

    public Application(TruckDao truckDao) {
        List<Truck> list = truckDao.list();
        for (Truck truck : list) {
            Truck previousValue = truckRegistry.put(truck.getId(), truck);
            if (null != previousValue) {
                throw new IllegalStateException("More than one truck with same id!");
            }
        }

        multiMap.put("MAZ", new MegaTruck(112, 23));
        multiMap.put("MAZ", new MegaTruck(444, 18));

        List<Truck> megaTruck = multiMap.get("MAZ");
    }

    void viewTruckRegistry() {
        for (Map.Entry<Long, Truck> truckEntry : truckRegistry.entrySet()) {
            System.out.println(truckEntry);
        }
    }

    public Truck getTruckById(long truckId) {
        Truck truck = truckRegistry.get(truckId);
        if (truck == null) {
            throw new IllegalArgumentException("Truck with id " + truckId + " not found!");
        }
        return truck;
    }

    public static void main(String[] args) {
        TruckDao truckDao = new TruckDaoMemoryImpl();
        Application application = new Application(truckDao);
        application.viewTruckRegistry();
        truckDao.list().listIterator(5);
    }

    class MegaTruck extends Truck {

        public MegaTruck(long id, int capacity) {
            super(id, capacity);
        }
    }
}
