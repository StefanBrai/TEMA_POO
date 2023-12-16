package main.java.org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

public abstract class User {
     static class Information {
        private final Credentials credentials;
         private final String name;
        private final String country;
        private final int age;
        private final char gender;
        private final LocalDate localDateTime;
        private Information(InformationBuilder i){
            this.credentials = i.credentials;
            this.name = i.name;
            this.country = i.country;
            this.age = i.age;
            this.gender = i.gender;
            this.localDateTime = i.localDateTime;
        }
         public static class InformationBuilder {
             private final Credentials credentials = new Credentials();
             private String name;
             private String country;
             private int age;
             private char gender;
              private LocalDate localDateTime;
             public InformationBuilder(String email){
                 this.credentials.setEmail(email);
             }
             public  InformationBuilder Password(String pass) {
                 this.credentials.setPassword(pass);
                 return this;
             }
             public InformationBuilder Name(String name){
                 this.name = name;
                 return this;
             }
             public InformationBuilder Country(String country) {
                 this.country = country;
                 return this;
             }
             public InformationBuilder Age(int age) {
                 this.age = age;
                 return this;
             }
             public InformationBuilder Gender(char gender){
                 this.gender = gender;
                 return this;
             }
             public InformationBuilder Date(LocalDate l){
              this.localDateTime = l;
              return this;
             }
             public Information build(){
                 return new Information(this);
             }
         }
         public void printer(){
             System.out.println(this.age);
             System.out.println(this.country);
         }
    }
    Information info;
    AccountType type_of_user;
    String username;
    int experience;
    List<String> notifications ;
    SortedSet<Object> favourites ;
    public void AddToFavourites(Object to_add){

        favourites.add(to_add);
    }
    public void DeleteFromFavourites(Object to_remove){
        favourites.remove(to_remove);
    }
    public void ModifyExp(){
        ;
    }
    public void LogOut(){
        ;
    }
}
