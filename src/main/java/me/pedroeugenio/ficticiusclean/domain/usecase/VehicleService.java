package me.pedroeugenio.ficticiusclean.domain.usecase;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleModel;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastModel;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleService {

    void save(VehicleModel vehicleModel);

    List<VehicleExpenseForecastModel> getExpenseForecast(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways);
}
