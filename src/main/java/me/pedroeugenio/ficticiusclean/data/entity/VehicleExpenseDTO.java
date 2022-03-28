package me.pedroeugenio.ficticiusclean.data.entity;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastModel;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(query = "SELECT new me.pedroeugenio.ficticiusclean.data.entity.VehicleExpenseDTO(v.name,v.brand,v.manufacturingYear," +
                "ROUND((:kmTraveledInTheCity/v.averageConsumptionInTheCity)+(:kmTraveledInTheHighways / v.averageConsumptionInTheHighways), 2)," +
                "ROUND(((:kmTraveledInTheCity/v.averageConsumptionInTheCity)+(:kmTraveledInTheHighways / v.averageConsumptionInTheHighways)) * :price, 2) as SPENT" +
                ") FROM VehicleDTO v order by SPENT desc", name = "VehicleExpenseEntity.findAllSortedVehicle")
})
public class VehicleExpenseDTO {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String brand;
    private int manufacturingYear;
    private Double fuelAmountSpent;
    private Double totalamountSpentOnFuel;

    public VehicleExpenseDTO(String name, String brand, int manufacturingYear, Double fuelAmountSpent, Double totalamountSpentOnFuel) {
        this.name = name;
        this.brand = brand;
        this.manufacturingYear = manufacturingYear;
        this.fuelAmountSpent = fuelAmountSpent;
        this.totalamountSpentOnFuel = totalamountSpentOnFuel;
    }

    public VehicleExpenseDTO() {

    }

    public static VehicleExpenseDTO fromDto(VehicleExpenseForecastModel dto, ModelMapper modelMapper) {
        return modelMapper.map(dto, VehicleExpenseDTO.class);
    }

    public VehicleExpenseForecastModel toDto(ModelMapper modelMapper) {
        return modelMapper.map(this, VehicleExpenseForecastModel.class);
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
