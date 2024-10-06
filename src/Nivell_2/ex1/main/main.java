package Nivell_2.ex1.main;

import Nivell_2.ex1.modules.Restaurant;
import java.util.*;

public class main {

    public static ArrayList<Restaurant> restaurantsByOrder =
                                new ArrayList<>();
    public static Set<Restaurant> restaurants = new HashSet<>();
    static Scanner input = new Scanner(System.in);

    public static void main (String[] args) {
        newRestaurant(new Restaurant("Fooco Mataro", 5));
        newRestaurant(new Restaurant("Fooco Mataro", 5));
        newRestaurant(new Restaurant("Fooco Mataro", 5));
        newRestaurant(new Restaurant("Elisabets", 8));
        newRestaurant(new Restaurant("McDonalds", 3));
        newRestaurant(new Restaurant("Alinea Chicago", 10));
        newRestaurant(new Restaurant("Can Gallina", 6));

        restaurantsByOrder.addAll(restaurants);

        restaurantsByOrder.sort(Comparator.comparing(Restaurant::getScore).reversed());

        viewRestaurantsInOrder();

    }

    public static void newRestaurant(Restaurant restaurant) {
        if (restaurants.add(restaurant)) { //Si devuelve true, significa que se agregó
            System.out.println(restaurant.toString() + " (Ingresado Correctamente) ");
        } else{
            System.out.println(restaurant.toString() + " repetido\nNo es posible ingresarlo.");
        }
    }

    public static void viewRestaurantsInOrder() {

        for(Restaurant r : restaurantsByOrder){
            System.out.println(r.toString());
        }

    }
}
