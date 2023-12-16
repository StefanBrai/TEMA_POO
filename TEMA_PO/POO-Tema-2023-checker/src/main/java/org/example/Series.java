package main.java.org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Production{

    Integer release_year;
    Integer number_of_seasons;
     private Map<String , List<Episode>> seasons = new HashMap<>();

    public Series(String production_name, List<String> actorList, List<Genre> genreList, List<Rating> ratingList, String description , Integer release_year, Integer number_of_seasons , Map<String , List<Episode>> seasons) {
        super(production_name, actorList, genreList, ratingList, description);
        this.release_year = release_year;
        this.number_of_seasons = number_of_seasons;
        this.seasons = seasons;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name :"+ this.production_name +"\n" +"Release year :"+this.release_year + "\n"+"No. of seasons :"+this.number_of_seasons +"\n");
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Series) {
            Series s = (Series) o;
            return this.production_name.compareTo(s.production_name);
        }
        else {
            throw new ClassCastException("Cannot compare a Series to a non-Series object");
        }
    }
}
