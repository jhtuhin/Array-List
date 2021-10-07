package com.JHTuhin;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition=findContact(oldContact);
        if((foundPosition<0)||(findContact(newContact.getName())!=-1)){
            return false;
        }
        this.myContacts.set(foundPosition,newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        int foundPosition=findContact(contact);
        if(foundPosition<0){
            return false;
        }
        this.myContacts.remove(contact);
        return true;
    }

    public Contact queryContact(String name){
        int foundPosition=findContact(name);
        if(foundPosition>=0){
            return this.myContacts.get(foundPosition);
        }
        return null;
    }
    public void printContacts() {
        System.out.println("Contact List");
        for(int i=0; i<this.myContacts.size(); i++){
            System.out.println((i+1)+". "+myContacts.get(i).getName()
                    +" -> "+myContacts.get(i).getPhoneNumber());
        }
        }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName){
        for(int i=0;i<this.myContacts.size();i++){
            Contact contact=this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }

        }
        return -1;
    }

}
