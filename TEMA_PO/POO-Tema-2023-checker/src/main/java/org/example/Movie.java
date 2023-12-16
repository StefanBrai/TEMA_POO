package main.java.org.example;

import java.util.List;

public class Movie extends Production {

    Double duration;
    Integer release_year;

    public Movie(String production_name , List<String> actorList , List<Genre> genreList , List<Rating> ratingList , String description, Double duration , Integer release_year){
        super(production_name , actorList ,  genreList ,  ratingList , description);
        this.duration = duration;
        this.release_year = release_year;

    }
    @Override
    public void displayInfo() {
        System.out.println("Name :"+ this.production_name +"\n" +"Release year :"+this.release_year + "\n"+"Duration :"+this.duration +" minutes\n");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Movie) {
            Movie m = (Movie) o;
            return this.production_name.compareTo(m.production_name);
        }
        else {
            throw new ClassCastException("Cannot compare a Movie to a non-Movie object");
        }
    }
}
