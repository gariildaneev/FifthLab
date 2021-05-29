package com.company.Models;

import java.util.Objects;

public class House {
    private String name; //Поле не может быть null
    private Long year; //Поле может быть null, Значение поля должно быть больше 0
    private long numberOfFloors; //Значение поля должно быть больше 0

    @Override
    public String toString() {
        return "House{\r\n\t\t" +
                "name='" + name + "'" +
                ",\r\n\t\tyear=" + year +
                ",\r\n\t\tnumberOfFloors=" + numberOfFloors +
                "\r\n\t}";
    }

    public House(String name, long year, long numberOfFloors) {
        setName(name);
        setYear(year);
        setNumberOfFloors(numberOfFloors);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            name = "обьект";
            System.out.println("поле name равно null. Заменено но 'обьект' по уполчанию");
        }
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        if(year <= 0){
            System.out.println("значение year не должно быть ортрицательным. Заменено на 1");
            year = (long) 1;
        }
        this.year = year;
    }

    public long getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(long numberOfFloors) {
        if(numberOfFloors <= 0){
            System.out.println("значение numberOfFloors не должно быть ортрицательным. Заменено на 1");
            numberOfFloors = 1;
        }
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return numberOfFloors == house.numberOfFloors && Objects.equals(name, house.name) && Objects.equals(year, house.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, numberOfFloors);
    }
}