package org.example;

import java.util.ArrayList;
import java.util.Iterator;

abstract class Vehicle
{
    protected String model;
    protected String fuelType;
    protected String colour;
    protected double cost;
    protected double insurance;
    protected double repairCost;

    public Vehicle(String model, String fuelType, String colour, double cost, double insurance, double repairCost) {
        this.model = model;
        this.fuelType = fuelType;
        this.colour = colour;
        this.cost = cost;
        this.insurance = insurance;
        this.repairCost = repairCost;
    }

    public String getInfo() {
        return "model='" + model + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", colour='" + colour + '\'' +
                ", cost=" + cost +
                ", insurance=" + insurance +
                ", repair cost=" + repairCost;
    }

    public double totalCost() {
        return cost + insurance + repairCost;
    }

    public void changeRepairCost(double newCost){
        this.repairCost = newCost;
    }
}

class Car extends Vehicle {

    private int numOfDoors;
    private String typeOfCar;

    public Car(String model, String fuelType, String colour, double cost, double insurance, double repairCost, int numOfDoors, String typeOfCar) {
        super(model, fuelType, colour, cost, insurance, repairCost);
        this.numOfDoors = numOfDoors;
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                ", number of doors: " + numOfDoors + '\'' +
                ", type of car: " + typeOfCar + "\n";
    }
}

class Motorbike extends Vehicle {

    private String typeOfBike;

    public Motorbike(String model, String fuelType, String colour, double cost, double insurance, double repairCost, String typeOfBike) {
        super(model, fuelType, colour, cost, insurance, repairCost);
        this.typeOfBike = typeOfBike;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + '\'' +
                ", type of bike: " + typeOfBike + "\n";

    }
}

class Garage {
    private ArrayList<Vehicle> vehiclesInGarage;
    private int garageCapacity;
    private int numOfVehicles;

    public Garage(int garageCapacity) {
        this.vehiclesInGarage = new ArrayList<>();
        this.garageCapacity = garageCapacity;
        this.numOfVehicles = 0;
    }

    public void addToGarage(Vehicle vehicle){
        if (numOfVehicles < garageCapacity){
            vehiclesInGarage.add(vehicle);
            numOfVehicles++;
            System.out.println("The following vehicle was added to the garage:");
            System.out.println(vehicle.getInfo());
        } else {
            System.out.println("The garage is at max capacity.");
        }
    }

    public int getGarageCapacity(){
        return garageCapacity;
    }

    public int getNumOfVehicles(){
        return numOfVehicles;
    }

    public void getGarageVehiclesInfo(){
        if (numOfVehicles != 0) {
            System.out.println("\nThe garage contains the following vehicle/s:\n");
            //for (int i = 0; i < vehiclesInGarage.size(); i++){
            for (Vehicle currentVehicle : vehiclesInGarage) {
            System.out.println(currentVehicle.getInfo());
            }
        } else {
            System.out.println("\nThe garage is currently empty.\n");
        }
    }

    public double getTotalCostGarage(){
        double sumCost = 0;
        for (Vehicle currentVehicle : vehiclesInGarage) {
            sumCost+=currentVehicle.totalCost();
        }
        return sumCost;
    }

    public void removeFromGarage(int vehiclePosition){
        if (garageCapacity == 0 ){
            System.out.println("There are no vehicles in your garage to be removed.");
        } else {
            if (vehiclePosition > numOfVehicles || vehiclePosition < 0){
                System.out.println("A car in that position of the garage does not exist.");
            }
            else {
                System.out.println("The following vehicle was removed from the garage:");
                System.out.println(vehiclesInGarage.get(vehiclePosition).getInfo());
                vehiclesInGarage.remove(vehiclePosition);
                numOfVehicles--;
            }
        }
    }

    public void emptyGarage(){
        if (numOfVehicles == 0) {
            System.out.println("The garage is already empty.");
        } else {
            vehiclesInGarage.clear();
            numOfVehicles = 0;
            System.out.println("The garage has been emptied.");
        }
    }

    public void removeAllBikes() {
        Iterator<Vehicle> iterator = vehiclesInGarage.iterator();
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle instanceof Motorbike) {
                iterator.remove();
                numOfVehicles--;
            }
        }
    }

    public void removeAllCars() {
        Iterator<Vehicle> iterator = vehiclesInGarage.iterator();
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle instanceof Car) {
                iterator.remove();
                numOfVehicles--;
            }
        }
    }

    public int getNumberOfCars() {
        Iterator<Vehicle> iterator = vehiclesInGarage.iterator();
        int tempCount = 0;
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle instanceof Car) {
                tempCount++;
            }
        }
        return tempCount;
    }

    public int getNumberOfBikes() {
        Iterator<Vehicle> iterator = vehiclesInGarage.iterator();
        int tempCount = 0;
        while (iterator.hasNext()) {
            Vehicle currentVehicle = iterator.next();
            if (currentVehicle instanceof Motorbike) {
                tempCount++;
            }
        }
        return tempCount;
    }

    public static void main(String[] args) {
        Garage garage1 = new Garage(6);
        garage1.addToGarage(new Motorbike("suzuki","petrol", "blue", 600,150, 100,"dirt-bike"));
        garage1.addToGarage(new Car("Kia", "petrol", "silver", 800, 200, 100,4, "coupe"));
        garage1.addToGarage(new Car("honda", "petrol", "silver", 800, 200, 150,4, "coupe"));
        garage1.addToGarage(new Motorbike("harley davidson","petrol", "blue", 600,150,100, "dirt-bike"));
        garage1.addToGarage(new Motorbike("test  bike","petrol", "blue", 600,150, 100,"dirt-bike"));
        Car testCar = new Car("bmw", "diesel", "green", 10000, 500, 200, 4, "sports");
        garage1.addToGarage(testCar);
    }
}