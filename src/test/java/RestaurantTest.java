import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        initialize();


        Restaurant spiedRestaurant = Mockito.spy(restaurant);
        Mockito.when(spiedRestaurant.getCurrentTime()).thenReturn(LocalTime.parse("11:30:25"));
        System.out.println(spiedRestaurant.getName());
        assertEquals(true,spiedRestaurant.isRestaurantOpen());

    }


    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE
        initialize();
        Restaurant spiedRestaurant = Mockito.spy(restaurant);
        Mockito.when(spiedRestaurant.getCurrentTime()).thenReturn(LocalTime.parse("23:30:25"));
        System.out.println(spiedRestaurant.getName());
        assertEquals(false,spiedRestaurant.isRestaurantOpen());

    }

    @Test
    public void getting_the_not_equal_order_value_after_selecting_items(){
        initialize();
        restaurant.addToMenu("Vegetable lasagne1",200);
        restaurant.addToMenu("Vegetable lasagne2",300);

        List<String> list= new ArrayList<>();
        list.add("simple");
        list.add("simple1");
        list.add("simple2");

        assertEquals(500,restaurant.getOrderValue(list));

    }



    @Test
    public void getting_the_equal_order_value_after_selecting_items(){
        initialize();
        restaurant.addToMenu("Vegetable lasagne1",300);
        restaurant.addToMenu("Vegetable lasagne2",400);

        List<String> list= new ArrayList<>();
        list.add("Vegetable lasagne");
        list.add("Vegetable lasagne1");
        list.add("Sweet corn soup");
        list.add("Vegetable lasagne2");

        assertEquals(1000,restaurant.getOrderValue(list));

    }

    @Test
    public void is_local_time(){
        System.out.println(LocalTime.now());
    }


    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){
        initialize();
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);
        assertEquals(initialMenuSize+1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {
        initialize();
        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {
        initialize();

        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }

    private void initialize() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 100);
        restaurant.addToMenu("Vegetable lasagne", 200);
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}