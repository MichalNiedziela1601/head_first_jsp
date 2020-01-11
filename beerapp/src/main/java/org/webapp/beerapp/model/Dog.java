package org.webapp.beerapp.model;

public class Dog {
    private String name;
    private String race;

    public Dog(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
