package main.java.org.example;

import java.util.List;

public  class RequestsHolder {
    static List<Request> admin_duty_list;
    public static void Set_List(List<Request> requests) {
        admin_duty_list = requests;
    }
    public static void Add_To_List(Request q) {
        admin_duty_list.add(q);
    }
    public static void Remove_From_list(Request q) {
        admin_duty_list.remove(q);
    }
}
