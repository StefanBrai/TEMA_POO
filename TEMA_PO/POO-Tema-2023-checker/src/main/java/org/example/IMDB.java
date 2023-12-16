package main.java.org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMDB {
    private List<User> userList = new ArrayList<User>();
    private List<Actor> actors = new ArrayList<Actor>();
    private List<Request> requests = new ArrayList<Request>();
    private List<Production> productions = new ArrayList<Production>();
    private final static IMDB obj = new IMDB();
    private IMDB(){}
    public static  IMDB getInstance(){
        return obj;
    }
    public  List<Request> getRequests() {
        return IMDB.getInstance().requests;
    }
    public  List<User> getUsers() {
        return IMDB.getInstance().userList;
    }
    public  List<Actor> getActors(){
        return IMDB.getInstance().actors;
    }
    public  List<Production> getProductions(){
        return IMDB.getInstance().productions;
    }
    public  void addProd(Production p) {
        IMDB.getInstance().productions.add(p);
    }
    public void addAct(Actor a) {
        IMDB.getInstance().actors.add(a);
    }
    public void rmvAct(Actor a) {
        IMDB.getInstance().actors.remove(a);
    }
    public void rmvProd(Production p) {
        IMDB.getInstance().productions.remove(p);
    }
    private void readUsersFromJson() throws IOException, ParseException {
        String filePath = "C:\\Users\\Stefan\\Desktop\\TEMA_PO\\POO-TEMA-2023-input\\accounts.json";

        // Read JSON file
        try (FileReader reader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            // Convert JSONArray to a list of maps
            List<Map<String, Object>> mapList = convertJsonArrayToMapList(jsonArray);

            // Print the converted data
            for (Map<String, Object> entry : mapList) {
                User x = UserFactory.factory(AccountType.valueOf(entry.get("userType").toString().toUpperCase()));
                assert x != null;
                x.type_of_user = (AccountType.valueOf(entry.get("userType").toString().toUpperCase()));
                x.username = (String) entry.get("username");
                Number xp = entry.get("experience") != null ? (Number) Integer.parseInt((String)entry.get("experience")) : 0;
                x.experience = xp.intValue();
                Map<String, Object> information = (Map<String, Object>) entry.get("information");
                Map<String, Object> credentials = (Map<String, Object>) information.get("credentials");

                x.info = new User.Information.InformationBuilder((String) credentials.get("email"))
                        .Password((String) credentials.get("password"))
                        .Age(( (Long)information.get("age")).intValue())  // Use Long for parsing age
                        .Country((String) information.get("country"))
                        .Gender(((String) information.get("gender")).charAt(0))  // Use String for parsing gender
                        .Date(LocalDate.parse((String) information.get("birthDate"), DateTimeFormatter.ISO_DATE))

                        .Name((String) information.get("name"))
                        .build();
//                if(entry.containsKey("favoriteProductions")){
//                    for (String iter : (String[])entry.get("favoriteProductions")) {
//                        Production to_add = new () {
//
//                        }
//                        x.AddToFavourites((to_add));
//                    }
//                }
                userList.add(x);
            }

        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
    private void readActorsFromJson() throws IOException , ParseException{
        String filePath = "C:\\Users\\Stefan\\Desktop\\TEMA_PO\\POO-TEMA-2023-input\\actors.json";
        try (FileReader reader = new FileReader(filePath)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            // Convert JSONArray to a list of maps
            List<Map<String, Object>> mapList = convertJsonArrayToMapList(jsonArray);

            // Print the converted data
            for (Map<String, Object> entry : mapList) {
                Actor x = new Actor();
                x.Name = (String) entry.get("name");
                x.Biography= (String) entry.get("biography");
                Map<String , String> Apparitions = (Map<String,String>)entry.get("performances");
                for (Map.Entry<String , String> iter : Apparitions.entrySet()){
                     x.Where_He_Starred.put(iter.getKey(), iter.getValue());
                }
                actors.add(x);
            }

        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
    private static List<Map<String, Object>> convertJsonArrayToMapList(JSONArray jsonArray) {
        List<Map<String, Object>> mapList = new ArrayList<>();

        for (Object obj : jsonArray) {
            if (obj instanceof JSONObject) {
                Map<String, Object> elementMap = convertJsonToMap((JSONObject) obj);
                mapList.add(elementMap);
            }
        }

        return mapList;
    }

    private static Map<String, Object> convertJsonToMap(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();

        for (Object key : jsonObject.keySet()) {
            String keyStr = (String) key;
            Object value = jsonObject.get(keyStr);

            if (value instanceof JSONObject) {
                Map<String, Object> nestedMap = convertJsonToMap((JSONObject) value);
                map.put(keyStr, nestedMap);
            } else if (value instanceof JSONArray) {
                List<Map<String, Object>> nestedList = convertJsonArrayToMapList((JSONArray) value);
                map.put(keyStr, nestedList);
            } else {
                map.put(keyStr, value);
            }
        }

        return map;
    }
    public void run() throws IOException, ParseException {

        readUsersFromJson();
        readActorsFromJson();
        for (User iteratorUser : userList) {
            iteratorUser.info.printer();
            System.out.println(iteratorUser.experience);
        }
        System.out.println(userList.get(1).type_of_user);

    }
}
