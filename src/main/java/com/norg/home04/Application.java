package com.norg.home04;

import com.norg.home04.multimap.MultiMap;
import com.norg.home04.multimap.MultiMapArrayList;
import com.norg.representer.Representable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Application implements Representable {
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

    }

    public Application() {

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
//        TruckDao truckDao = new TruckDaoMemoryImpl();
        Application application = new Application();

        application.multiMap.put("MAZ", new Truck(123, 20));
        application.multiMap.put("MAZ", new MegaTruck(112, 23));
        application.multiMap.put("MAZ", new MegaTruck(444, 18));
        application.multiMap.put("MAZ", new Truck(567, 21));

        application.multiMap.put("KAMAZ", new Truck(432, 15));
        application.multiMap.put("KAMAZ", new MegaTruck(432, 15));

        Collection<Truck> trucks = application.multiMap.get("MAZ");
        System.out.println(trucks);
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 04\n");
        writer.write("### Реализована Multimap\n");
        writer.flush();
    }
}
