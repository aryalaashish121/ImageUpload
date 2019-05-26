package com.example.api.Model;

public class Hero {

    String name;
    String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Hero(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    String description;
}