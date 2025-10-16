package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd(){
        CityList cityList = mockCityList(); // adding first city
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan"); // adding second city
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException(){
        CityList cityList = mockCityList(); // adding a city that already exists
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, ()->{
            cityList.add(city);
        });
    }

    @Test
    void testGetCities(){
        CityList cityList = mockCityList();

        // checking if first city in cityList is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // pushing down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // now original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity(){ // testing to see if method is correct
        CityList cityList = mockCityList(); // adding first city
        assertEquals(1, cityList.getCities().size());

        City city1 = new City("Regina", "Saskatchewan"); // adding second city
        cityList.add(city1);

        City city2 = new City("Vancouver", "British Columbia"); // third city

        assertTrue(cityList.hasCity(city1));
        assertFalse(cityList.hasCity(city2)); // did not add city2 to the list
    }

    @Test
    void testRemove(){
        CityList cityList = mockCityList(); // adding first city
        assertEquals(1, cityList.getCities().size());

        City city1 = new City("Regina", "Saskatchewan"); // adding second city
        cityList.add(city1);

        City city2 = new City("Toronto", "Ontario"); // adding second city
        cityList.add(city2);

        assertEquals(3, cityList.getCities().size());

        cityList.remove(city1);
        assertFalse(cityList.hasCity(city1)); // city should no longer be in the list
    }

    @Test
    void testRemoveException(){
        CityList cityList = mockCityList(); // adding a city that already exists
        City city1 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city1);

        cityList.remove(city1);

        assertThrows(IllegalArgumentException.class, ()->{
            cityList.remove(city1);
        });
    }

    @Test
    void testCount(){
        CityList cityList = mockCityList(); // adding first city
        assertEquals(1, cityList.count());

        City city1 = new City("Regina", "Saskatchewan"); // adding second city
        cityList.add(city1);
        assertEquals(2, cityList.count());


        City city2 = new City("Toronto", "Ontario"); // adding second city
        cityList.add(city2);
        assertEquals(3, cityList.count());

    }

}
