package main.java.org.example;

import java.util.List;

public class Admin extends Staff{
    public void UpdateUsers(User somebody) {
        if ( this.IsInUserList(somebody)) {
            DeleteFromSystem(somebody);
        }
        else {
            AddToSystem(somebody);
        }
    }
    public boolean IsInUserList(User somebody) {
        List<User> x = IMDB.getInstance().getUsers();
        for ( User y : x) {
            if (y.username.equals(somebody.username)) return true;
        }
        return false;
    }
}
