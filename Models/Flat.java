package com.company.Models;

import com.company.CommandsManager;
import com.company.Main;
import java.time.LocalDateTime;

public class Flat implements Comparable<Flat>{
    /**
     * Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
     */
    private int id;
    /**
     * Поле не может быть null, Строка не может быть пустой
     */
    private String name;
    /**
     * Поле не может быть null
     */
    private Coordinates coordinates;

    /**
     * Поле не может быть null, Значение этого поля должно генерироваться автоматически
     */
    private java.time.LocalDateTime creationDate;
    /**
     * Значение поля должно быть больше 0
     */
    private Integer area;
    /**
     * Значение поля должно быть больше 0
     */
    private Integer numberOfRooms;
    /**
     * Поле может быть null
     */
    private Boolean balcony;
    /**
     * Значение поля должно быть больше 0
     */
    private Long timeToMetroByTransport;
    /**
     * Поле может быть null
     */
    private View view;
    /**
     * Поле не может быть null
     */
    private House house;

    /**
     * To String
     */
    @Override
    public String toString() {
        return "Flat{\r\n\t" +
                "id=" + id +
                ",\r\n\tname='" + name  +"'"+
                ",\r\n\tcoordinates=" + coordinates +
                ",\r\n\tcreationDate=" + creationDate +
                ",\r\n\tarea=" + area +
                ",\r\n\tnumberOfRooms=" + numberOfRooms +
                ",\r\n\tbalcony=" + balcony +
                ",\r\n\ttimeToMetroByTransport=" + timeToMetroByTransport +
                ",\r\n\tview=" + view +
                ",\r\n\thouse=" + house +
                "\r\n}";
    }

    @Override
    public int compareTo(Flat o) {
        return -1;
    }

    public Flat() {
        id = Tree.getId();
        creationDate = LocalDateTime.now();
    }


    /**
     * get Id
     */
    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}


    /**
     * get Name
     */
    public String getName() {
        return name;
    }

    /**
     * set Name
     */
    public void setName(String name) {
        if(name == null) {
                name = "обьект";
                System.out.println("поле name равно null. Заменено но 'обьект' по уполчанию");
        }
        else if(name.equals("")){
            name = "обьект";
            System.out.println("поле name равно ' '. Заменено но 'обьект' по уполчанию");
        }
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * set Coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        if(coordinates == null){
            System.out.println("неверно заданы координты. По умолчанию x,y равны 0");
            coordinates = new Coordinates(0,0);
        }
        this.coordinates = coordinates;
    }

    /**
     * get Creation Date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime localDateTime) {
        this.creationDate = localDateTime;
    }

    /**
     * get Area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * set Area
     */
    public void setArea(Integer area) {
        if(area <= 0){
            System.out.println("area должен быть больше нуля. По умолчанию 0");
            area = 0;
        }
        this.area = area;
    }

    /**
     * get number of rooms
     */
    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    /**
     * set Number of rooms
     */
    public void setNumberOfRooms(Integer numberOfRooms) {
        if(numberOfRooms < 0){
            System.out.println("numberOfRooms должен быть больше нуля. По умолчанию 0");
            numberOfRooms = 0;
        }
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * get Balcony
     */
    public Boolean getBalcony() {
        return balcony;
    }

    /**
     * set Balcony
     */
    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    /**
     * get time to Metro by Transport
     */
    public Long getTimeToMetroByTransport() {
        return timeToMetroByTransport;
    }

    /**
     * set time to Metro by Transport
     */
    public void setTimeToMetroByTransport(Long timeToMetroByTransport) {
        if(timeToMetroByTransport < 0){
            System.out.println("timeToMetroByTransport должен быть больше нуля. По умолчанию 0");
            timeToMetroByTransport = (long)0;
        }
        this.timeToMetroByTransport = timeToMetroByTransport;
    }

    /**
     * get View
     */
    public View getView() {
        return view;
    }

    /**
     * set View
     */
    public void setView(View view) {

        this.view = view;
    }

    /**
     * get House
     */
    public House getHouse() {
        return house;
    }


    /**
     * set House
     */
    public void setHouse(House house) {
        if(house == null){
            house = new House("обьект", 1,1);
            System.out.println("поле house равно null. name, year,numberOfFloors заменено на 'обьект',1,1 по уполчанию");
        }
        this.house = house;
    }


    /**
     * constructor
     */
    public Flat(int id, String name,  Integer area, Integer numberOfRooms, Long timeToMetroByTransport , Boolean balcony,Coordinates coordinates, House house, View view, LocalDateTime creationDate) {
        this.id = id;
        setName(name);
        setCoordinates(coordinates);
        this.creationDate = creationDate;
        setNumberOfRooms(numberOfRooms);
        setArea(area);
        setBalcony(balcony);
        setTimeToMetroByTransport(timeToMetroByTransport);
        setView(view);
        setHouse(house);
    }
    public Flat(String name,  Integer area, Integer numberOfRooms, Long timeToMetroByTransport , Boolean balcony,Coordinates coordinates, House house, View view) {
        setName(name);
        id = Tree.getId();
        setCoordinates(coordinates);
        this.creationDate = LocalDateTime.now();
        setNumberOfRooms(numberOfRooms);
        setArea(area);
        setBalcony(balcony);
        setTimeToMetroByTransport(timeToMetroByTransport);
        setView(view);
        setHouse(house);
    }
    public Flat( String name,  Integer area, Integer numberOfRooms, Long timeToMetroByTransport , Boolean balcony,Coordinates coordinates, House house, View view, LocalDateTime creationDate) {
        id = Tree.getId();
        setName(name);
        setCoordinates(coordinates);
        this.creationDate = creationDate;
        setNumberOfRooms(numberOfRooms);
        setArea(area);
        setBalcony(balcony);
        setTimeToMetroByTransport(timeToMetroByTransport);
        setView(view);
        setHouse(house);
    }

}