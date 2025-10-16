package com.example.listycity;

/**
 * This is a class that defines a City with variables city and province.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * This is a constructor setting up references for each of the object variables
     * @param city
     *  This is the candidate city
     * @param province
     *  This is the candidate province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This getter returns the name of the city
     * @return
     *  Return the city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * This getter returns the name of the province
     * @return
     *  Return the province name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * This compares two strings to see if they are lexiographically the same
     * @param city
     *  The object to be compared.
     * @return
     *  Return integer representing whether or not the two are the same
     */
    @Override
    public int compareTo(City city){
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * This compares the objects fields to see if two objects are the same
     * @param o
     *  This is the object to compare each item in the list with
     * @return
     *  Return boolean if both city and province of o match an instance in a list
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // comparing objects' fields to see if they objects are the same
        City new_city = (City) o;
        return city.equals(new_city.city) && province.equals(new_city.province);
    }

    /**
     * This produces the hashCode of a city object as a combination of the city and province name
     * @return
     *  Returns the unique hashcode
     */
    @Override
    public int hashCode(){
        return city.hashCode()*31+province.hashCode(); // calculating hashCode https://hostman.com/tutorials/overriding-the-hashcode-method-in-java/
    }
}

