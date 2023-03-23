package com.think.talent.test.thinktalenttest.domain;

public class Name {

        private int id;
        private String firstName;
        private String lastName;
        private String fullName;
        public Name(){
            //Default Constructor
        }
    public Name(int id, String firstName,String lastName,String fullName){
        //Parameterized Constructor
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
