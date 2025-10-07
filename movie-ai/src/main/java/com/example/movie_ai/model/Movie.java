package com.example.movie_ai.model;

import jakarta.persistence.*;

@Entity
public class Movie {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;
    private int rating;

    @Column(length = 1000)
    private String description;

    public Movie(String title, int rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }
    public Movie(){}

    public int getId() {
        return Id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(){
        this.rating = rating;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }


}
