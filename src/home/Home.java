package home;

import java.util.Scanner;
import phonebook.PhoneBook;


public class Home {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);




        while(true){
        System.out.println("Welcome to Nick's Phonebook");
        System.out.println("1. Add entry");
        System.out.println("2. Print phonebook");
        System.out.println("3. Search phonebook");
        System.out.println("4. Update record by phone number");
        System.out.println("5. Delete record");
        System.out.println("6. Quit");
        //creating scanner object so we can get input
            int input = sc.nextInt();
            sc.nextLine();

            if (input == 6) {
                System.exit(0);
            }

        //using this to close the scanner or else this would not work
        //sc.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Please enter information followed by a comma");
                    System.out.println("Example: John J Smith, 123 Smith Drive, Boston, MA, 04215, 123 421 4212");
                    String ainput = sc.nextLine();
                    try {
                        phoneBook.fetcher(ainput);
                    }
                    catch (Exception e){
                        System.out.println("Wrong input format!");
                    }
                    break;
                case 2:
                    System.out.println("Printing phone book");
                    phoneBook.printdirect();
                    break;
                case 3:
                    System.out.println("Search phonebook options");
                    System.out.println("1. Search by Phone number");
                    System.out.println("2. Search by Full name");
                    System.out.println("3. Search by First name");
                    System.out.println("4. Search by Last name");
                    System.out.println("5. Search by City");
                    System.out.println("6. Search by State");
                    int pInput = sc.nextInt();
                    phoneBook.searchOptions(pInput);
                    break;
                case 4:
                    System.out.println("Updating record");
                    String uInput = sc.nextLine();
                    phoneBook.updateRecord(uInput);
                    break;
                case 5:
                    System.out.println("Delete record");
                    String dInput = sc.nextLine();
                    phoneBook.deleteRecord(dInput);
                    break;
                default:
                    System.out.println("Invalid input...");
                    break;
            }
        }

    }

}

