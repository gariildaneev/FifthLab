package com.company.Models;

import com.company.Printer;
import java.util.TreeSet;

public class Tree {
    private TreeSet<Flat> list = new TreeSet<>(Flat::compareTo);
    private static int id = -1;

    public TreeSet<Flat> getList() {
        return list;
    }

    public void setList(TreeSet<Flat> list) {
        this.list = list;
    }

    public static Flat get_Flat(){
        String name = null;
        while (name == null || name.equals("")) {
            System.out.println("введите name");
            name = Printer.getInstance().ReadLine();
        }
        int area = -1;
        while (area < 0) {
            try {
                System.out.println("введите area");
                area = Integer.parseInt(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }
        int number = -1;
        while (number < 0) {
            try{
                System.out.println("введите numberOfRooms");
                number = Integer.parseInt(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }
        int timeToMetroByTransport = -1;
        while (timeToMetroByTransport < 0) {
            try {
                System.out.println("введите timeToMetroByTransport");
                timeToMetroByTransport = Integer.parseInt(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }
        boolean balcony = false;
        System.out.println("введите balcony");
        try {
            String f = Printer.getInstance().ReadLine();
            balcony = Boolean.parseBoolean(f);
        } catch (Exception e) {
            System.out.println("значение по умолчанию false");
        }

        System.out.println("ввод кооординат");
        long x = -1;
        while (x < 0) {
            try{
                System.out.println("введите x");
                x = Long.parseLong(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }

        long y = -1;
        while (y < 0) {
            try{
                System.out.println("введите y");
                y = Long.parseLong(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }

        String name1 = null;
        while (name1 == null || name1.equals("")) {
            System.out.println("введите имя дома");
            name1 = Printer.getInstance().ReadLine();
        }

        long age = -1;
        while (age < 0) {
            try{
                System.out.println("введите age");
                age = Long.parseLong(Printer.getInstance().ReadLine());
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }
        long number1 = -1;
        while (number1 < 0) {
            try{
                System.out.println("введите numberOfFloors");
                String i = Printer.getInstance().ReadLine();
                number1 = Long.parseLong(i);
            }
            catch (Exception e){
                System.out.println("введите верное значение");
            }
        }
        View w;

        while (true){
            System.out.println("введите view");
            for (View w1 : View.values()) {
                System.out.print("\t\t\t" + w1);
            }
            System.out.println();
            String s = Printer.getInstance().ReadLine();
            if(s.equals("null")){
                w = null;
                break;
            }
            else{
                try {
                    w = View.valueOf(s);
                    break;
                }
                catch (Exception e){
                    System.out.println("введите верное значение");
                }
            }
        }
        return new Flat(name, area, number, (long)timeToMetroByTransport, balcony, new Coordinates(x,y), new House(name1, age, number1), w);
    }

    public static int getId() {
        id++;
        return id;
    }
}
