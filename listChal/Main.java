package listChal;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhoneObj = new MobilePhone("0719315908");
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printMenu();

        while (!quit){
            System.out.println("Enter your action (6 to print available action)");
            int inputAction = sc.nextInt();
            sc.nextLine();

            switch (inputAction){
                case 0:
                    System.out.println("shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhoneObj.printContact();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printMenu();
                    break;
                default:
                    System.out.println("Please select between 1 and 6");

            }


        }

    }
    private static void startPhone(){
        System.out.println("Starting the phone...");
        System.out.println();
    }
    private static void printMenu(){
        System.out.println("**********   Contacts List   **********");
        System.out.println();
        System.out.println("Press");
        System.out.println();
        System.out.println("\t-0 to shutdown\n"+
                "\t-1 to print the list of contact\n"+
                "\t-2 to add contact\n"+
                "\t-3 to update contact\n"+
                "\t-4 to remove existing contact\n"+
                "\t-5 to query if the contact exist\n"+
                "\t-6 to print available actions\n");
        System.out.println();
    }
    private static void addContact(){
        System.out.println("Please enter the name of the contact");
        String contactName = sc.nextLine();
        System.out.println("Please enter the phone number of the contact");
        String contactPhone = sc.nextLine();
        Contact newContact = Contact.createContacts(contactName,contactPhone);
        if(mobilePhoneObj.addNewContact(newContact)){
            System.out.println();
            System.out.println(contactName+" --> "+contactPhone+" have been successfully added to the contact list...");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println(contactName+" --> "+contactPhone+" already exist int the contact list");
            System.out.println();
        }

    }
    private static void updateContact(){
        System.out.println("Enter the existing contact name: ");
        String oldName = sc.nextLine();
        Contact existingContact = mobilePhoneObj.queryContact(oldName);
        if(existingContact==null){
            System.out.println();
            System.out.println("Contact not found!");
            System.out.println();
            return;
        }
        System.out.println("Enter the new contact name: ");
        String newName = sc.nextLine();
        System.out.println("Enter new contact's phone number: ");
        String newPhoneNo = sc.nextLine();
        Contact newContact = Contact.createContacts(newName,newPhoneNo);
        if(mobilePhoneObj.updateContact(existingContact,newContact)){
            System.out.println("successfully update record...");
            System.out.println();
        }
        else {
            System.out.println("failed to update the record...");
            System.out.println();
        }

    }
    private static void removeContact() {
        System.out.println("Enter the contact name: ");
        String removeName = sc.nextLine();
        Contact removeContact = mobilePhoneObj.queryContact(removeName);
        if (removeContact == null) {
            System.out.println();
            System.out.println("Contact not found! ");
            System.out.println();
            return;
        }
        if(mobilePhoneObj.removeContact(removeContact)){
            System.out.println();
            System.out.println("successfully deleted");
            System.out.println();
        }
        else {
            System.out.println("failed to delete the contact");
            System.out.println();
        }

    }
    private static void queryContact() {
        System.out.println("Enter the contact name: ");
        String queryName = sc.nextLine();
        Contact queryContact = mobilePhoneObj.queryContact(queryName);
        if (queryContact == null) {
            System.out.println();
            System.out.println("Contact not found!  ");
            System.out.println();
            return;
        }
        System.out.println();
        System.out.println("Name: "+queryContact.getName()+" --> Phone Number: "+queryContact.getPhoneNo());
        System.out.println();
    }
}
