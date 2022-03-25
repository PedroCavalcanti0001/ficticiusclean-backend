package me.pedroeugenio.ficticiusclean.domain.usecase;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleDTO;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastDTO;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleService {

    void save(VehicleDTO vehicleDTO);

    List<VehicleExpenseForecastDTO> getExpenseForecast(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways);
}
