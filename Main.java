package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int a;
        System.out.println("Hoşgeldiniz");
        System.out.println("Kaç takım olsun?");
        Scanner inp = new Scanner(System.in);
        a = inp.nextInt();
        List<String> takimlar = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            System.out.println(i + " . takım=> ");
            String takim = inp.next();
            takimlar.add(takim);
            if (i == a) System.out.println("tüm takımlar girildi");
        }
        if (a % 2 != 0) {
            takimlar.add("bay");
            a += 1;
        }
        System.out.println("Takımlar");
        System.out.println("--------");
        for (int i = 0; i < takimlar.size(); i++) {
            System.out.println(" - " + takimlar.get(i));
        }
        List<String> tTakimlar = new ArrayList<>();
        while (0 < takimlar.size()) {
            int b = (int) (Math.random() * takimlar.size());
            tTakimlar.add(takimlar.get(b));
            takimlar.remove(b);
        }
        takimlar = tTakimlar;
        System.out.println();
        System.out.println("Takımlar karıştırılmıştır");
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");
        System.out.println("---------");
        for (int i = 0; i < takimlar.size(); i++) {
            System.out.println(" - " + takimlar.get(i));
        }
        int numHafta = a - 1;
        int macHafta = a / 2;
        LinkedHashMap<String, ArrayList<ArrayList<String>>> haftalar = new LinkedHashMap<>();

        for (int i = 1; i <= numHafta; i++) {
            String hafta = String.valueOf(i);
            haftalar.put(hafta, new ArrayList<ArrayList<String>>());

        }
        for (int i = 0; i < numHafta; i++) {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();
            for (int j = 0; j < macHafta; j++) {
                home.add(takimlar.get(j));
                away.add(takimlar.get((a - j) - 1));
            }
            String week = String.valueOf(i + 1);
            haftalar.get(week).add(home);
            haftalar.get(week).add(away);

            List<String> nTeams = new ArrayList<>();

            nTeams.add(takimlar.get(0));
            nTeams.add(takimlar.get(a - 1));

            for (int k = 1; k < takimlar.size() - 1; k++) {
                nTeams.add(takimlar.get(k));
            }
            takimlar = tTakimlar;
        }
        for (int i = 0; i < numHafta * 2; i++) {
            System.out.println("#########################################################################");
            System.out.println("Hafta #" + (i + 1));

            for (int j = 0; j < macHafta; j++) {
                if (i < numHafta) {
                    System.out.println(haftalar.get(String.valueOf(i + 1)).get(0).get(j) + " vs " + haftalar.get(String.valueOf(i + 1)).get(1).get(j));
                } else {
                    System.out.println(haftalar.get(String.valueOf(i+1-numHafta)).get(1).get(j)+" vs "+haftalar.get(String.valueOf(i+1-numHafta)).get(0).get(j));                    ;
                }
            }
        }
    }
}
