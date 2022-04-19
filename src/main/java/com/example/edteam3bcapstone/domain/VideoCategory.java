package com.example.edteam3bcapstone.domain;

public enum VideoCategory {
    ACTION("Action"), COMEDY("Comedy"), DRAMA("Drama"), FANTASY("Fantasy"), HORROR("Horror"), MYSTERY("Mystery"), ROMANCE("Romance"), THRILLER("Thriller");

    private final String category;

    VideoCategory(String category) {this.category = category; }

    public String getCategory() {return this.category; }
}
