package me.pedroeugenio.ficticiusclean.infra.entity;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;

@Entity
@Table(name = "VEHICLE")
public class VehicleEntity {
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

    public static VehicleEntity fromDto(VehicleDTO vehicleDTO, ModelMapper modelMapper) {
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }

    public VehicleDTO toDto(ModelMapper modelMapper) {
        return modelMapper.map(this, VehicleDTO.class);
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
