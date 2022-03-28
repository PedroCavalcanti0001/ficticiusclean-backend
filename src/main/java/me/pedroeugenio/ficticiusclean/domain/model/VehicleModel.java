package me.pedroeugenio.ficticiusclean.domain.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class VehicleModel implements Serializable {

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String brand;
    @NotEmpty
    @NotNull
    private String model;
    @NotNull
    @Min(1950)
    private int manufacturingYear;
    @NotNull
    @DecimalMin("1.0")
    private BigDecimal averageConsumptionInTheCity;
    @NotNull
    @DecimalMin("1.0")
    private BigDecimal averageConsumptionInTheHighways;

    public VehicleModel(String name, String brand, String model, int manufacturingYear, BigDecimal averageConsumptionInTheCity, BigDecimal averageConsumptionInTheHighways) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.averageConsumptionInTheCity = averageConsumptionInTheCity;
        this.averageConsumptionInTheHighways = averageConsumptionInTheHighways;
    }

    public VehicleModel() {

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public BigDecimal getAverageConsumptionInTheCity() {
        return averageConsumptionInTheCity;
    }

    public void setAverageConsumptionInTheCity(BigDecimal averageConsumptionInTheCity) {
        this.averageConsumptionInTheCity = averageConsumptionInTheCity;
    }

    public BigDecimal getAverageConsumptionInTheHighways() {
        return averageConsumptionInTheHighways;
    }

    public void setAverageConsumptionInTheHighways(BigDecimal averageConsumptionInTheHighways) {
        this.averageConsumptionInTheHighways = averageConsumptionInTheHighways;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", averageConsumptionInTheCity=" + averageConsumptionInTheCity +
                ", averageConsumptionInTheHighways=" + averageConsumptionInTheHighways +
                '}';
    }
}
