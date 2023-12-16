package main.java.org.example;

public class Credentials {
    private String email;
    private String password;
    void setEmail(String e){
        email = e;
    }
    void setPassword(String p){
        password = p;
    }
    String getEmail(){
        return this.email;
    }
    String getPassword(){
        return this.password;
    }
}
