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
}
