package me.pedroeugenio.ficticiusclean.presenter.api;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleDTO;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastDTO;
import me.pedroeugenio.ficticiusclean.infra.VehicleServiceImpl;
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
    public ResponseEntity<List<VehicleExpenseForecastDTO>> getExpenseForecast(
            @RequestParam() BigDecimal price,
            @RequestParam() BigDecimal kmTraveledInTheCity,
            @RequestParam() BigDecimal kmTraveledInTheHighways) {
        return ResponseEntity.ok(vehicleService.getExpenseForecast(price, kmTraveledInTheCity, kmTraveledInTheHighways));
    }

    @PostMapping
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        vehicleService.save(vehicleDTO);
        return ResponseEntity.created(URI.create("previsao-gastos")).build();
    }
}
