package edu.eci.cvds.tdd.aerodescuentos;


import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    private static final double DELTA = 1e-15;

    @Test
    public void given_daysInAdvance35AndAge6_Then_FareDiscount20Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 35, 6);
        Assert.assertEquals(tarifa, 360000, DELTA);
    }

    @Test
    public void given_daysInAdvance76AndAge19_Then_FareDiscount15Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 76, 19);
        Assert.assertEquals(tarifa, 382500, DELTA);
    }

    @Test
    public void given_daysInAdvance54AndAge68_Then_FareDiscount23Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 54, 68);
        Assert.assertEquals(tarifa, 346500, DELTA);
    }

    @Test
    public void given_daysInAdvance8AndAge75_Then_FareDiscount8Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 8, 75);
        Assert.assertEquals(tarifa, 414000, DELTA);
    }

    @Test
    public void given_daysInAdvance5AndAge34_Then_FareWithNoDiscount(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 5, 34);
        Assert.assertEquals(tarifa, 450000, DELTA);
    }

    @Test
    public void given_daysInAdvance60AndAge24_Then_FareDiscount15Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 60, 24);
        Assert.assertEquals(tarifa, 382500, DELTA);
    }

    @Test
    public void given_daysInAdvance20AndAge18_Then_FareDiscount0Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 20, 18);
        Assert.assertEquals(tarifa, 450000, DELTA);
    }

    @Test
    public void given_daysInAdvance21AndAge18_Then_FareDiscount15Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 21, 18);
        Assert.assertEquals(tarifa, 382500, DELTA);
    }

    @Test
    public void given_daysInAdvance20AndAge65_Then_FareDiscount0Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 20, 65);
        Assert.assertEquals(tarifa, 450000, DELTA);
    }

    @Test
    public void given_daysInAdvance21AndAge65_Then_FareDiscount15Percent(){
        double tarifa = CalculadorDescuentos.calculoTarifa(450000, 21, 65);
        Assert.assertEquals(tarifa, 382500, DELTA);
    }
}
