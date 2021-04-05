import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    //private static List<Restaurant> restaurants1 = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        Restaurant requiredRestaurant = null;
        for(Restaurant r:getRestaurants()){
            if(r.getRestaurantName().equals(restaurantName)){
                requiredRestaurant=r;
            }
        }
        if(requiredRestaurant==null){
            throw new restaurantNotFoundException(restaurantName);
        }
        else{
            return requiredRestaurant;
        }
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
            Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }




    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
