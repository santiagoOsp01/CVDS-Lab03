package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void given_Age_When_IsZero_Then_InvalidAge(){
        Person person = new Person("Juan", 79843793, 0, Gender.MALE, true);
        RegisterResult register = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, register);
    }

    @Test
    public void given_Age_When_IsLessThanZero_Then_InvalidAge(){
        Person person = new Person("Juan", 79843793, -9, Gender.MALE, true);
        RegisterResult register = registry.registerVoter(person);
        Assert.assertEquals(register, RegisterResult.INVALID_AGE);
    }

    @Test
    public void given_Age_When_IsGreaterThan110_Then_InvalidAge(){
        Person person = new Person("Juan", 79843793, -9, Gender.MALE, true);
        RegisterResult register = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, register);
    }

    @Test
    public void given_Age_When_IsLessThan18_Then_Underage(){
        Person person = new Person("Juan", 79843793, 9, Gender.MALE, true);
        RegisterResult register = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, register);
    }

    @Test
    public void given_Age_When_IsGreaterThan18_Then_Valid(){
        Person person = new Person("Juan", 79843793, 58, Gender.MALE, true);
        RegisterResult register = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, register);
    }

    @Test
    public void given_name_when_longitud_IsGreaterThan30_then_inValid(){
        Person person = new Person("Juanjsjcsbcjsbcjsbcjscbsjcbsjcbsjcbscbcjbcjbcjscbscbajsbcjhsacjhsacvhscvsahcvjhcvjcvsacjsavcjhsavchcvjhcvsjhcvsjhcvsacjhvschsavcjhsacvc", 79843793, 58, Gender.MALE, true);
        Name register = registry.registerName(person);
        Assert.assertEquals(Name.InValidName, register);
    }

    @Test
    public void given_name_when_longitud_IsLessThan1_then_inValid(){
        Person person = new Person("", 79843793, 58, Gender.MALE, true);
        Name register = registry.registerName(person);
        Assert.assertEquals(Name.InValidName, register);
    }

    @Test
    public void given_name_when_isValid(){
        Person person = new Person("Santiago", 79843793, 58, Gender.MALE, true);
        Name register = registry.registerName(person);
        Assert.assertEquals(Name.ValidName, register);
    }

    @Test
    public void given_Gender_UNIDENTIFIED(){
        Person person = new Person("Santiago", 79843793, 58, Gender.UNIDENTIFIED, true);
        Gender register = registry.registerGender(person);
        Assert.assertEquals(Gender.UNIDENTIFIED, register);
    }

    @Test
    public void given_Gender_MALE(){
        Person person = new Person("Santiago", 79843793, 58, Gender.MALE, true);
        Gender register = registry.registerGender(person);
        Assert.assertEquals(Gender.MALE, register);
    }

    @Test
    public void given_Gender_FEMALE(){
        Person person = new Person("Santiago", 79843793, 58, Gender.FEMALE, true);
        Gender register = registry.registerGender(person);
        Assert.assertEquals(Gender.FEMALE, register);
    }

    @Test
    public void given_Id_When_IsLargerThan10_Then_Invalid(){
        Person person = new Person("Juan", 1798437939, 58, Gender.MALE, true);
        Ids register = registry.registerVoterId(person);
        Assert.assertEquals(Ids.INVALID_ID, register);
    }

    @Test
    public void given_Id_When_IsSmallerThan6_Then_Invalid(){
        Person person = new Person("Juan", 7984, 58, Gender.MALE, true);
        Ids register = registry.registerVoterId(person);
        Assert.assertEquals(Ids.INVALID_ID, register);
    }

    @Test
    public void given_Id_When_IsInBetween6And10_Then_Valid(){
        Person person = new Person("Juan", 7984576, 58, Gender.MALE, true);
        Ids register = registry.registerVoterId(person);
        Assert.assertEquals(Ids.VALID_ID, register);
    }

    @Test
    public void given_Alive_When_PersonIsNull_Then_Invalid(){
        Person person = null;
        RegisterResult register = registry.registerAlive(person);
        Assert.assertEquals(RegisterResult.INVALID, register);
    }

    @Test
    public void given_Alive_When_IsFalse_Then_Dead(){
        Person person = new Person();
        person.setAlive(false);
        RegisterResult register = registry.registerAlive(person);
        Assert.assertEquals(RegisterResult.DEAD, register);
    }

    @Test
    public void given_Alive_When_IsTrue_Then_Valid(){
        Person person = new Person();
        person.setAlive(true);
        RegisterResult register = registry.registerAlive(person);
        Assert.assertEquals(RegisterResult.VALID, register);
    }
}
