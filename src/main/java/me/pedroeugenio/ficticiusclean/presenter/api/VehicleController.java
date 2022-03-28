package me.pedroeugenio.ficticiusclean.presenter.api;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleModel;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastModel;
import me.pedroeugenio.ficticiusclean.data.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping("previsao-gastos")
    public ResponseEntity<List<VehicleExpenseForecastModel>> getExpenseForecast(
            @RequestParam() BigDecimal price,
            @RequestParam() BigDecimal kmTraveledInTheCity,
            @RequestParam() BigDecimal kmTraveledInTheHighways) {
        return ResponseEntity.ok(vehicleService.getExpenseForecast(price, kmTraveledInTheCity, kmTraveledInTheHighways));
    }

    @PostMapping
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleModel vehicleModel) {
        vehicleService.save(vehicleModel);
        return ResponseEntity.created(URI.create("previsao-gastos")).build();
    }
}
