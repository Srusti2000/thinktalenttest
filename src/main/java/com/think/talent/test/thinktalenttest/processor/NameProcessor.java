package com.think.talent.test.thinktalenttest.processor;
public class NameProcessor {
    public String getNameToDisplay(String firstName, String middleName, String lastName){
        String displayName = "";
        if(firstName != null && !"".equals(firstName)) firstName=firstName.substring(0,1).toUpperCase()+" ";
        if(middleName != null && !"".equals(middleName)) middleName=middleName.substring(0,1).toUpperCase()+" ";
        if(lastName != null && !"".equals(lastName)) lastName=lastName.toUpperCase();
        if(middleName != null || !"".equals(middleName)) {
            displayName= firstName+middleName+lastName;
        }else{
            displayName= firstName+lastName;
        }
        return displayName;
    }
}
