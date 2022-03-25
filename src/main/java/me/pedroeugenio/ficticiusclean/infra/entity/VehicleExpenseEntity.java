package me.pedroeugenio.ficticiusclean.infra.entity;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastDTO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(query = "SELECT new me.pedroeugenio.ficticiusclean.infra.entity.VehicleExpenseEntity(v.name,v.brand,v.manufacturingYear," +
                "ROUND((:kmTraveledInTheCity/v.averageConsumptionInTheCity)+(:kmTraveledInTheHighways / v.averageConsumptionInTheHighways), 2)," +
                "ROUND(((:kmTraveledInTheCity/v.averageConsumptionInTheCity)+(:kmTraveledInTheHighways / v.averageConsumptionInTheHighways)) * :price, 2) as SPENT" +
                ") FROM VehicleEntity v order by SPENT desc", name = "VehicleExpenseEntity.findAllSortedVehicle")
})
public class VehicleExpenseEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String brand;
    private int manufacturingYear;
    private Double fuelAmountSpent;
    private Double totalamountSpentOnFuel;

    public VehicleExpenseEntity(String name, String brand, int manufacturingYear, Double fuelAmountSpent, Double totalamountSpentOnFuel) {
        this.name = name;
        this.brand = brand;
        this.manufacturingYear = manufacturingYear;
        this.fuelAmountSpent = fuelAmountSpent;
        this.totalamountSpentOnFuel = totalamountSpentOnFuel;
    }

    public VehicleExpenseEntity() {

    }

    public static VehicleExpenseEntity fromDto(VehicleExpenseForecastDTO dto, ModelMapper modelMapper) {
        return modelMapper.map(dto, VehicleExpenseEntity.class);
    }

    public VehicleExpenseForecastDTO toDto(ModelMapper modelMapper) {
        return modelMapper.map(this, VehicleExpenseForecastDTO.class);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getFuelAmountSpent() {
        return fuelAmountSpent;
    }

    public void setFuelAmountSpent(Double fuelAmountSpent) {
        this.fuelAmountSpent = fuelAmountSpent;
    }

    public Double getTotalamountSpentOnFuel() {
        return totalamountSpentOnFuel;
    }

    public void setTotalamountSpentOnFuel(Double totalamountSpentOnFuel) {
        this.totalamountSpentOnFuel = totalamountSpentOnFuel;
    }

    @Override
    public String toString() {
        return "VehicleExpenseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", manufacturingYear=" + manufacturingYear +
                ", fuelAmountSpent=" + fuelAmountSpent +
                ", totalamountSpentOnFuel=" + totalamountSpentOnFuel +
                '}';
    }
}
