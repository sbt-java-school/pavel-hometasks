package com.norg.home01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {
            String[] line = console.readLine().split(" ");
            //int n = Integer.parseInt(line[0]); //нам не обязательно наперед знать количество, если все грузы будут
            // указаны в следующей строке
            int w = Integer.parseInt(line[1]);
            Truck truck = new Truck(w);

            String[] weights = console.readLine().split(" ");
            for(String weight:weights) {
                int a = Integer.parseInt(weight);
                truck.put(a);
            }

            System.out.println(truck);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
