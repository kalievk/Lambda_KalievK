package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Players> pl= new ArrayList<>();
        pl.add(new Players("Bill", Position.PG, 23, 15000));
        pl.add(new Players("Frank", Position.C, 26, 7800));
        pl.add(new Players("Steph", Position.SG, 29, 12100));
        pl.add(new Players("Lebron", Position.SF, 32, 4600));
        pl.add(new Players("Blake", Position.PF, 34, 19000));
        pl.add(new Players("Kobe", Position.SG, 27, 8500));
        pl.add(new Players("James", Position.PG, 29, 13300));

        Suitable position = players -> {
            switch (players.getPosition()){
                case SG:
                case C: return true;
                case PG:
                case SF:
                case PF:return false;
            }
            return false;
        };

        Suitable age = players -> {
            if (players.getAge() > 33) {
                return false;
            } else {
                return true;
            }
        };

        Suitable salary = players -> {
            if (players.getSalary() > 14000) {
                return false;
            } else {
                return true;
            }
        };


    pl.forEach(players -> System.out.println(position.needToBy(players) && age.needToBy(players) && salary.needToBy(players)));

    }
    @FunctionalInterface
    public interface Suitable{
        boolean needToBy(Players players);
    }
}