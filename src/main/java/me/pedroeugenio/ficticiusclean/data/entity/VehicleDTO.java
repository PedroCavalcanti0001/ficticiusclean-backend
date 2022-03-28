package me.pedroeugenio.ficticiusclean.data.entity;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleModel;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "VEHICLE")
public class VehicleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int manufacturingYear;
    @Column(nullable = false)
    private BigDecimal averageConsumptionInTheCity;
    @Column(nullable = false)
    private BigDecimal averageConsumptionInTheHighways;

    public static VehicleDTO fromDto(VehicleModel vehicleModel, ModelMapper modelMapper) {
        return modelMapper.map(vehicleModel, VehicleDTO.class);
    }

    public VehicleModel toDto(ModelMapper modelMapper) {
        return modelMapper.map(this, VehicleModel.class);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public BigDecimal getAverageConsumptionInTheCity() {
        return averageConsumptionInTheCity;
    }

    public BigDecimal getAverageConsumptionInTheHighways() {
        return averageConsumptionInTheHighways;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public void setAverageConsumptionInTheCity(BigDecimal averageConsumptionInTheCity) {
        this.averageConsumptionInTheCity = averageConsumptionInTheCity;
    }

    public void setAverageConsumptionInTheHighways(BigDecimal averageConsumptionInTheHighways) {
        this.averageConsumptionInTheHighways = averageConsumptionInTheHighways;
    }
}
