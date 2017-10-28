package listChal;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContactsList;
    private String myNumber;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContactsList = new ArrayList<Contact>();
    }

    //adding new contact
    public boolean addNewContact(Contact contactObj) {
        if (findContact(contactObj.getName()) >= 0) {
            System.out.println();
            System.out.println("the contact already exist");
            System.out.println();
            return false;
        }
        myContactsList.add(contactObj);
        return true;
    }

    private int findContact(Contact contactObj) {
        return this.myContactsList.indexOf(contactObj);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < this.myContactsList.size(); i++) {
            Contact contact = this.myContactsList.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    //query contact

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0) {
            return this.myContactsList.get(position);
        }
        return null;
    }

    //print the contact
    public void printContact() {
        if(myContactsList.isEmpty()){
            System.out.println();
            System.out.println("Your contact list is empty");
            System.out.println();
            return;
        }
        System.out.println("Contact List");
        System.out.println();
        for (int i = 0; i < myContactsList.size(); i++) {
            System.out.println((i + 1) + "." + " " + this.myContactsList.get(i).getName() + " --> " + this.myContactsList.get(i).getPhoneNo());
        }
        System.out.println();
    }


    //updating a contact
    public boolean updateContact(Contact oldContObj, Contact newContObj) {
        int foundPosition = findContact(oldContObj);
        if (foundPosition < 0) {
            System.out.println();
            System.out.println(oldContObj.getName() + " was not found ");
            System.out.println();
            return false;
        }
        this.myContactsList.set(foundPosition, newContObj);
        System.out.println();
        System.out.println(oldContObj.getName() + " was successfully replace by " + newContObj.getName());
        System.out.println();
        return true;

    }


    //remove contact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println();
            System.out.println(contact.getName() + " was not found");
            System.out.println();
            return false;
        }
        this.myContactsList.remove(position);
        System.out.println();
        System.out.println(contact.getName() + " was successfully deleted");
        System.out.println();
        return true;
    }
}

