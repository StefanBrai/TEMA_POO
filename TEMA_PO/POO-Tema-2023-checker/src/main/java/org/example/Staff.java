package main.java.org.example;

import java.util.List;
import java.util.SortedSet;

public abstract class Staff extends User  implements StaffInterface {
    List<Request> current_person_requests;
    SortedSet<Object> current_person_contribution;
    public void ResolveRequests(){
        ;
    }
    public void addProductionSystem(Production p) {
        List<Production> check_the_list = IMDB.getInstance().getProductions();
        for(Production x : check_the_list) {
            if (x.production_name.equals(p.production_name)) {
                System.out.println("This Prod. already in the system");
                return ;
            }
        }
        IMDB.getInstance().addProd(p);
    }

    @Override
    public void addActorSystem(Actor a) {
        List<Actor> check_the_list = IMDB.getInstance().getActors();
        for(Actor x : check_the_list) {
            if (x.Name.equals(a.Name)) {
                System.out.println("This Actor already in the system");
                return ;
            }
        }
        IMDB.getInstance().addAct(a);
    }

    @Override
    public void removeProductionSystem(String name) {
        List<Production> check_the_list = IMDB.getInstance().getProductions();
        for(Production x : check_the_list) {
            if (x.production_name.equals(name)) {
                IMDB.getInstance().rmvProd(x);
                return;
            }
        }
        System.out.println("This prod. doesn t exist in the system");
        return;
    }

    @Override
    public void removeActorSystem(String name) {
        List<Actor> check_the_list = IMDB.getInstance().getActors();
        for(Actor x : check_the_list) {
            if (x.Name.equals(name)) {
                IMDB.getInstance().rmvAct(x);
                return;
            }
        }
        System.out.println("This act. doesn t exist in the system");
        return;
    }

    @Override
    public void updateProduction(Production p) {
        List<Production> check_the_list = IMDB.getInstance().getProductions();
        for (Production x : check_the_list) {
            if (x.production_name.equals(p.production_name)) {
                IMDB.getInstance().rmvProd(p);
                return;
            }
        }
        IMDB.getInstance().addProd(p);
    }

    @Override
    public void updateActor(Actor a) {
        List<Actor> check_the_list = IMDB.getInstance().getActors();
        for (Actor x : check_the_list) {
            if (x.Name.equals(a.Name)) {
                IMDB.getInstance().rmvAct(a);
                return;
            }
        }
        IMDB.getInstance().addAct(a);
    }
}

