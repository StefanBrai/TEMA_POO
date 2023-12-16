package main.java.org.example;

import java.util.List;

public  abstract class Production implements Comparable {

    String production_name;
    List<String> actorList ;
    List<Genre> genreList;
    List<Rating> ratingList;
    String description;
    Double rating;
    public Production(String production_name , List<String> actorList , List<Genre> genreList , List<Rating> ratingList , String description){
        this.production_name = production_name;
        this.actorList = actorList;
        this.genreList = genreList;
        this.ratingList = ratingList;
        this.description = description;

    }

    public Double RatingCalculator() {
        Double s = 0.0;
        for ( Rating rate_iterator : ratingList) {
            s+= rate_iterator.rating;
        }
        this.rating = s;
        return s;

    }

    public int CompareTo(Object o) {
        if (o instanceof Production) {
            Production p = (Production) o;
            return this.production_name.compareTo(p.production_name);
        }
        else {
            throw new ClassCastException("Cannot compare a Production to a non-Production object");
        }
    }
    public abstract void displayInfo();
}