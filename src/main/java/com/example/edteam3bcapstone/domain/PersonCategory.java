package com.example.edteam3bcapstone.domain;

public enum PersonCategory {
    ACTOR("Actor"), DIRECTOR("Director"), PRODUCER("Producer");

    private final String profession;

    PersonCategory(String profession) {this.profession = profession; }

    public String getProfession() {return this.profession; }
}
