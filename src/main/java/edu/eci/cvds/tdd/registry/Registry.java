package edu.eci.cvds.tdd.registry;

public class Registry {
    public RegisterResult registerVoter(Person p) {
        RegisterResult result = null;
        if (p.getAge() <= 0 || p.getAge() > 110){
            result = RegisterResult.INVALID_AGE;
        } else if (p.getAge() < 18 && p.getAge() > 0){
            result =  RegisterResult.UNDERAGE;
        } else if (p.getAge() >= 18 && p.getAge() < 110) {
            result =  RegisterResult.VALID;
        }
        return result;
    }
    public Name registerName(Person p) {
        Name result = null;
        if ((p.getName()).length() <= 0 || (p.getName()).length() > 30){
            result = Name.InValidName;
        } else{
            result =  Name.ValidName;
        }
        return result;
    }
}
