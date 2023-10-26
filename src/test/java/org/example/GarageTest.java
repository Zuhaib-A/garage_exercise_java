package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GarageTest {

    //@Mock
    private Car mockedCar;
    private Motorbike mockedBike;
    private Garage mockedGarage;

    @BeforeEach
    public void setUp(){
        mockedCar = new Car("test_bmw", "petrol", "blue", 1000, 100, 200,4, "sports");
        mockedBike = new Motorbike("test_bike", "petrol", "blue", 500, 100, 100,"dirt_bike");
        mockedGarage = new Garage(5);
        mockedGarage.addToGarage(mockedCar);
        mockedGarage.addToGarage(mockedBike);
    }

    @Test
    public void testNumVehiclesInGarage(){
        assertEquals(2, mockedGarage.getNumOfVehicles());
    }

    @Test
    public void testAddCar(){
        mockedGarage.addToGarage(mockedBike);
        mockedGarage.addToGarage(mockedCar);
        assertEquals(2, mockedGarage.getNumberOfCars());
    }

    @Test
    public void testAddMotorBike(){
        mockedGarage.addToGarage(mockedBike);
        mockedGarage.addToGarage(mockedCar);
        assertEquals(2, mockedGarage.getNumberOfBikes());
    }

    @Test
    public void testTotalNumberAfterAdding(){
        mockedGarage.addToGarage(mockedBike);
        mockedGarage.addToGarage(mockedCar);
        assertEquals(4, mockedGarage.getNumOfVehicles());
    }

    @Test
    public void testTotalNumberAfterRemoving(){
        mockedGarage.removeFromGarage(0);
        assertEquals(1, mockedGarage.getNumOfVehicles());
    }

    @Test
    public void testRemovingAllCars(){
        mockedGarage.removeAllCars();
        assertEquals(0, mockedGarage.getNumberOfCars());
    }

    @Test
    public void testRemovingAllBikes(){
        mockedGarage.removeAllBikes();
        assertEquals(0, mockedGarage.getNumberOfBikes());
    }

    @Test
    public void testMakingGarageEmpty(){
        mockedGarage.emptyGarage();
        assertEquals(0, mockedGarage.getNumOfVehicles());
    }

    @Test
    public void testCheckTotalCost(){
        assertEquals(2000, mockedGarage.getTotalCostGarage());
    }

}
