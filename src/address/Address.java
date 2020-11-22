package address;


import java.util.Scanner;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;


    public Address(String street, String city, String state, String zip){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isCity(String city)
    {
        if(this.city.equals(city))
        {
            return true;
    }


        return false;
    }

    public boolean isState(String state)
    {
        if(this.state.equals(state))
        {
            return true;
        }


        return false;
    }




    @Override
    public String toString() {
        return street+ " "+ city+" " + state + " " + zip + " ";
    }
}
