package main.java.org.example;

public class UserFactory {
    public static User factory(AccountType x) {
            switch (x) {
                case REGULAR -> {
                    return new Regular();
                }
                case ADMIN -> {
                    return new Admin();
                }
                case CONTRIBUTOR -> {
                    return new Contributor();
                }
            }
        return null;
    }
}
