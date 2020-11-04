import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LagsTest {
    @Test
    public void should_create_flight_object(){
        Flight flight = new Flight("AF514", 0, 5, 10);
        assertThat(flight.getName(),is("AF514"));
        assertThat(flight.getStart(),is(0));
        assertThat(flight.getEnd(),is(5));
        assertThat(flight.getCost(),is(10));
    }

    @Test
    public void should_copy_fights() {
        Flight flight1 = new Flight("x",0,5,10);
        Flight flight2 = new Flight("y",0,6,10);
        Flight flight3 = new Flight("z",0,7,10);

        AbeasCrop abeasCrop = new AbeasCrop(flight1, flight2, flight3);
        List<Flight> flights =  abeasCrop.getFlights();
        assertThat(flights.get(0).getName(),is("x"));
        assertThat(flights.get(1).getName(),is("y"));
        assertThat(flights.get(2).getName(),is("z"));

    }

    @Test
    public void should_return_one_cost_when_there_is_only_one_flight(){
        assertThat(new AbeasCrop(new Flight("x",0,5,10)).maxGain(),is(10));
    }

    @Test
    public void should_return_higher_cost_when_there_are_two_flights_which_are_crossed(){
        Flight flight1 = new Flight("x", 0, 5, 11);
        Flight flight2 = new Flight("x", 0, 4, 12);
        assertThat(new AbeasCrop(flight1,flight2).maxGain(),is(12));
    }

    @Test
    public void should_return_sum_of_two_cost_when_there_are_two_flights_which_are_not_crossed(){
        Flight flight1 = new Flight("x", 0, 5, 11);
        Flight flight2 = new Flight("x", 6, 10, 12);
        assertThat(new AbeasCrop(flight1,flight2).maxGain(),is(23));
    }

    @Test
    public void should_return_sum_of_three_cost_when_there_are_three_flights_which_are_all_not_crossed(){
        Flight flight1 = new Flight("x", 0, 5, 10);
        Flight flight2 = new Flight("x", 6, 10, 10);
        Flight flight3 = new Flight("x", 11, 15, 20);
        assertThat(new AbeasCrop(flight1,flight2,flight3).maxGain(),is(40));
    }

    @Test
    public void should_return_first_cost_plus_another_flight_when_second_flight_join_with_third_flight(){
        Flight flight1 = new Flight("x", 0, 5, 10);
        Flight flight2 = new Flight("x", 6, 10, 10);
        Flight flight3 = new Flight("x", 8, 15, 20);
        assertThat(new AbeasCrop(flight1,flight2,flight3).maxGain(),is(30));
    }

    @Test
    public void should_return_cost_when_first_flight_cross_with_second_flight(){
        Flight flight1 = new Flight("x", 0, 5, 10);
        Flight flight2 = new Flight("x", 2, 4, 8);
        Flight flight3 = new Flight("x", 6, 10, 20);
        assertThat(new AbeasCrop(flight1,flight2,flight3).maxGain(),is(30));
    }

    @Test
    public void should_return_max_cost_of_three_flight_when_flights_are_all_crossed(){
        Flight flight1 = new Flight("x", 0, 5, 10);
        Flight flight2 = new Flight("x", 2, 4, 8);
        Flight flight3 = new Flight("x", 3, 5, 20);
        assertThat(new AbeasCrop(flight1,flight2,flight3).maxGain(),is(20));
    }

    @Test
    public void complicated_test(){
        Flight flight1 = new Flight("x", 0, 5, 10);
        Flight flight2 = new Flight("x", 2, 4, 8);
        Flight flight3 = new Flight("x", 3, 5, 20);
        Flight flight4 = new Flight("x", 7, 9, 10);
        Flight flight5 = new Flight("x", 8, 10, 20);
        Flight flight6 = new Flight("x", 10, 11, 20);
        assertThat(new AbeasCrop(flight1,flight2,flight3,flight4,flight5,flight6).maxGain(),is(60));
    }

}
