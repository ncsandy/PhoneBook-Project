package phonebook;

import java.util.*;
import java.lang.Comparable;
import address.Address;
import person.Person;

public class PhoneBook {

    // static int size = 0;
    Person[] directory = new Person[0];

    Scanner sc = new Scanner(System.in);

    public void fetcher(String input) {
        //separating all the information from user string and putting it into a string array
        String[] splitPerson = input.split(", ");
        //finding the first index which is our "name"
        String myName = splitPerson[0];
        //now we are going to split the name up
        String[] splitName = myName.split(" ");
        //finding the individual names by splitting....
        String firstName = splitName[0];
        String middleName = "";

        //For loop for multiple middle names Thanks Alex
        for (int i = 1; i < splitName.length - 1; i++) {
            middleName += splitName[i] +" ";


        }

        String lastName = splitName[splitName.length-1];

        //Getting individual person entries..

        String street = splitPerson[1];
        String city = splitPerson[2];
        String state = splitPerson[3];
        String zip = splitPerson[4];
        String phone = splitPerson[5];
        //creating a new object with all the information
        Person newEntry = new Person(firstName, middleName, lastName, new Address(street, city, state, zip), phone);

        Person[] temp = new Person[directory.length + 1];

        for (int i = 0; i < directory.length; i++) {
            temp[i] = directory[i];
        }

        temp[temp.length - 1] = newEntry;

        directory = temp;

        System.out.println("Entry was sucessful");
        Arrays.sort(directory);
    }

    public void printdirect() {
        Arrays.sort(directory);
        for (int i = 0; i < directory.length; i++) {

            System.out.println(directory[i]);
        }


    }

    public void searchOptions(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Enter phone number");
                String aInput = sc.nextLine();
                searchByPhone(aInput);
                break;
            case 2:
                System.out.println("Enter full name");
                String bInput = sc.nextLine();
                searchByFullName(bInput);
                break;
            case 3:
                System.out.println("Enter first name");
                String cInput = sc.nextLine();
                searchbyFirst(cInput);
                break;
            case 4:
                System.out.println("Enter last name");
                String dInput = sc.nextLine();
                searchbyLast(dInput);
                break;
            case 5:
                System.out.println("Enter city");
                String eInput = sc.nextLine();
                searchbyCity(eInput);
                break;
            case 6:
                System.out.println("Enter state");
                String fInput = sc.nextLine();
                searchbyState(fInput);
                break;
        }
    }

    public void searchByPhone(String phone) {
        Person[] samePhone = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (phone.equals(directory[i].getPhone())) {
                samePhone[count] = directory[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < samePhone.length; i++) {
            if(samePhone[i] != null) {
                System.out.println(samePhone[i]);
            }
        }
    }

    public void searchByFullName(String fullname) {
        Person[] sameFullName = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (fullname.equals(directory[i].getFullName()))
            {
                sameFullName[count] = directory[i];
            }

            count++;

        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < sameFullName.length; i++) {
            if(sameFullName[i] != null) {
                System.out.println(sameFullName[i]);
            }
            }
    }

    public void searchbyFirst(String first) {
        Person[] sameFirst = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (first.equals(directory[i].getFirstName())) {
                sameFirst[count] = directory[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameFirst.length; i++) {
            if(sameFirst[i] != null) {
                System.out.println(sameFirst[i]);
            }
        }
    }

    public void searchbyLast(String last) {
        Person[] sameLast = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (last.equals(directory[i].getLastName())) {
                sameLast[count] = directory[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameLast.length; i++) {
            if(sameLast[i] != null) {
                System.out.println(sameLast[i]);
            }
        }
    }

    public void searchbyCity(String city) {
        Person[] sameCity = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (directory[i].getAddress().isCity(city)) {
                sameCity[count] = directory[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found");
        for (int i = 0; i < sameCity.length; i++) {
            if(sameCity[i] != null) {
                System.out.println(sameCity[i]);
            }
        }
    }

    public void searchbyState(String state) {
        Person[] sameState = new Person[10];
        int count = 0;

        for (int i = 0; i < directory.length; i++) {
            if (directory[i].getAddress().isState(state)) {
                sameState[count] = directory[i];
            }
            count++;
        }

        System.out.println("Here are the matches we found`");
        for (int i = 0; i < sameState.length; i++) {
            if(sameState[i] != null) {
                System.out.println(sameState[i]);
            }
        }
    }

    //I could either do each individual one...or update the whole object...
    public void updateRecord(String phone) {

        for (int i = 0; i < directory.length; i++) {
            if (phone.equals(directory[i].getPhone())) {
                System.out.println("We found: ");
                System.out.println(directory[i]);
                System.out.println("What would you like to change? ");
                System.out.println("1. First Name");
                System.out.println("2. Middle Name");
                System.out.println("3. Last name");
                System.out.println("4. Address");
                System.out.println("5. Phone number");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new First Name");
                        String firstName = sc.nextLine();
                        directory[i].setFirstName(firstName);
                        System.out.println("Updated");
                        break;
                    case 2:
                        System.out.println("Enter new Middle Name");
                        String middleName = sc.nextLine();
                        directory[i].setMiddleName(middleName);
                        System.out.println("Updated");
                        break;
                    case 3:
                        System.out.println("Enter new Last Name");
                        String lastName = sc.nextLine();
                        directory[i].setLastName(lastName);
                        System.out.println("Updated");
                        break;
                    case 4:
                        System.out.println("Please seperate by commas. ie: 123 Smith Road, Boston, MA, 02709 ");
                        String address = sc.nextLine();
                        String[] splitAddress = address.split(",");
                        String street = splitAddress[0];
                        String city = splitAddress[1];
                        String state = splitAddress[2];
                        String zip = splitAddress[3];
                        directory[i].getAddress().setStreet(street);
                        directory[i].getAddress().setCity(city);
                        directory[i].getAddress().setState(state);
                        directory[i].getAddress().setZip(zip);
                        System.out.println("Updated!");
                        break;
                    case 5:
                        System.out.println("Enter new phone number");
                        String phoneNumber = sc.nextLine();
                        directory[i].setPhone(phoneNumber);
                        System.out.println("Updated");
                        break;
                }


            }


        }

    }

    public void deleteRecord(String phone) {
        boolean delete;
        for (int i = 0; i < directory.length; i++) {
            if (phone.equals(directory[i].getPhone())) {
                System.out.println("We found: ");
                System.out.println(directory[i]);
                System.out.println("Would you like to delete this record? (Yes/No) ");
                String input = sc.nextLine();
                input.toLowerCase();
                if(input.equals("yes"))
                {
                    directory[i] = null;
                }
            }

        }
        resizeArray();
    }

    public void resizeArray(){
        int size = 0;
        for(int i = 0; i<directory.length; i++)
        {
            if(directory[i] != null)
            {
                size++;
            }

        }
        Person [] tempA = new Person [size];

        for(int i = 0; i<directory.length; i++){
            if(directory[i] != null){
                tempA[i] = directory[i];
            }
        }
        directory = tempA;
    }
}