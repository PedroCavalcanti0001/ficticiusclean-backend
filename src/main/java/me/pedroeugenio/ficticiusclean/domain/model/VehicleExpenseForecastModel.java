package me.pedroeugenio.ficticiusclean.domain.model;

public class VehicleExpenseForecastModel {
    private String name;
    private String brand;
    private int manufacturingYear;
    private Float fuelAmountSpent;
    private Float totalamountSpentOnFuel;


    public VehicleExpenseForecastModel(String name, String brand, int manufacturingYear, Float fuelAmountSpent, Float totalamountSpentOnFuel) {
        this.name = name;
        this.brand = brand;
        this.manufacturingYear = manufacturingYear;
        this.fuelAmountSpent = fuelAmountSpent;
        this.totalamountSpentOnFuel = totalamountSpentOnFuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Float getFuelAmountSpent() {
        return fuelAmountSpent;
    }

    public void setFuelAmountSpent(Float fuelAmountSpent) {
        this.fuelAmountSpent = fuelAmountSpent;
    }

    public Float getTotalamountSpentOnFuel() {
        return totalamountSpentOnFuel;
    }

    public void setTotalamountSpentOnFuel(Float totalamountSpentOnFuel) {
        this.totalamountSpentOnFuel = totalamountSpentOnFuel;
    }
}
