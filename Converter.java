package com.company;

import com.company.Models.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Converter {
    private static Converter converter;

    public synchronized static Converter getInstance(){
        if(converter == null){
            converter = new Converter();
        }
        return converter;
    }

    public void SetTree(String path) {
        try {
            File f = new File(path);
            boolean e = f.createNewFile();
            Printer.getInstance().WriteLine(e ? "файл успешно создан" : "ошибка при создании файла, или файл уже создан");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));

            for (Flat flat : Main.tree.getList()) {
                stream.write((flat.getName() + "," + flat.getCoordinates().getX() + ","
                + flat.getCoordinates().getY() + "," + flat.getCreationDate().toString() + ","+
                        flat.getArea() + "," + flat.getBalcony() + "," + flat.getTimeToMetroByTransport() + ","
                + flat.getView() + "," + flat.getHouse().getName() + "," + flat.getHouse().getYear() + ","
                + flat.getHouse().getNumberOfFloors() + "\r\n").getBytes(StandardCharsets.UTF_8));
            }
            stream.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void GetTree(String path) {
        try {
            Scanner in = new Scanner(new File(path));
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] strs = line.split(",");
                Flat flat = new Flat();
                flat.setName(strs[0]);
                flat.setCoordinates(new Coordinates(Float.parseFloat(strs[1]), Double.parseDouble(strs[2])));
                flat.setCreationDate(LocalDateTime.parse(strs[3]));
                flat.setArea(Integer.parseInt(strs[4]));
                flat.setBalcony(Boolean.parseBoolean(strs[5]));
                flat.setTimeToMetroByTransport(Long.parseLong(strs[6]));
                flat.setView(View.valueOf(strs[7]));
                flat.setHouse(new House(strs[8], Integer.parseInt(strs[9]), Integer.parseInt(strs[10])));

                Main.tree.getList().add(flat);
            }
        }
        catch (Exception e){
            Printer.getInstance().WriteLine(e.getMessage());
            Main.tree = new Tree();
        }
    }

}
