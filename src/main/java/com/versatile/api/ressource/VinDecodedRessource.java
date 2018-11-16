package com.versatile.api.ressource;

public class VinDecodedRessource {
    private int year;
    private String make;
    private String model;
    private String trim;
    private String shortTrim;
    private String bodyType;
    private String vehicleType;
    private String drivetrain;
    private String fuelType;
    private String engine;
    private double engineSize;
    private int doors;
    private int cylinders;
    private String madeIn;

    public VinDecodedRessource() {
    }

    public VinDecodedRessource(int year, String make, String model, String trim, String shortTrim, String bodyType, String vehicleType, String drivetrain, String fuelType, String engine, double engineSize, int doors, int cylinders, String madeIn) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.shortTrim = shortTrim;
        this.bodyType = bodyType;
        this.vehicleType = vehicleType;
        this.drivetrain = drivetrain;
        this.fuelType = fuelType;
        this.engine = engine;
        this.engineSize = engineSize;
        this.doors = doors;
        this.cylinders = cylinders;
        this.madeIn = madeIn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getShortTrim() {
        return shortTrim;
    }

    public void setShortTrim(String shortTrim) {
        this.shortTrim = shortTrim;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
}
