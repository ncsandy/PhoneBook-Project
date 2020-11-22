package person;

import address.Address;



public class Person implements Comparable<Person>
{

    private String firstName;
    private String middleName;
    private String lastName;
    private Address address;
    private String phone;



    public Person(String firstName, String middleName,  String lastName,  Address address, String phone){
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;

    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    public String getFullName(){
        return firstName+" "+middleName+""+lastName;
    }


    @Override
    public String toString() {
        String str = phone;
        str = str.replaceAll("\\s", "");
        str = str.replaceAll("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        phone = str;
        return firstName + " " + middleName + "" + lastName + " " +
                address + phone;
    }

    @Override
    public int compareTo(Person o) {
        return getFirstName().compareTo(o.getFirstName());
    }
}