package me.pedroeugenio.ficticiusclean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleModel;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastModel;
import me.pedroeugenio.ficticiusclean.data.VehicleServiceImpl;
import me.pedroeugenio.ficticiusclean.presenter.api.VehicleController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class VehicleControllerTest {

    @Autowired
    private VehicleController controller;

    private ObjectMapper objectMapper;

    @MockBean
    private VehicleServiceImpl service;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.standaloneSetup(this.controller);
    }

    @Test
    void shouldReturnSuccessWhenSavingVehicle() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "marca",
                "modelo",
                2015,
                new BigDecimal("100"),
                new BigDecimal("150"));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithEmptyName() {
        VehicleModel vehicleModel = new VehicleModel("",
                "marca",
                "modelo",
                2015,
                new BigDecimal("100"),
                new BigDecimal("150"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithEmptyBrand() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "",
                "modelo",
                2015,
                new BigDecimal("100"),
                new BigDecimal("150"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithEmptyCarModel() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "marca",
                "",
                2015,
                new BigDecimal("100"),
                new BigDecimal("150"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithInvalidDate() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "marca",
                "modelo",
                1900,
                new BigDecimal("100"),
                new BigDecimal("150"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithInvalidAverageConsumptionInTheCity() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "marca",
                "modelo",
                2015,
                null,
                new BigDecimal("150"));
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnBadRequestWhenSavingVehicleWithInvalidAverageConsumptionInTheHighways() {
        VehicleModel vehicleModel = new VehicleModel("Carro",
                "marca",
                "modelo",
                2015,
                new BigDecimal("150"),
                null);
        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(new Gson().toJson(vehicleModel))
                .post("/api/v1/veiculos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void shouldReturnOkWhenSearchingForExpenseCalculation() {
        VehicleExpenseForecastModel vehicleExpenseForecastModel = new VehicleExpenseForecastModel("nome", "marca", 2021, 25.5f, 13.3f);
        Mockito.when(this.service.getExpenseForecast(new BigDecimal("8.3"), new BigDecimal("8.3"), new BigDecimal("8.3")))
                .thenReturn(List.of(vehicleExpenseForecastModel));

        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .params(Map.of(
                        "price", "8.3",
                        "kmTraveledInTheCity", "200",
                        "kmTraveledInTheHighways", "100"
                ))
                .get("/api/v1/veiculos/previsao-gastos")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void shouldReturnBadRequestWhenSearchingForExpenseCalculationWithoutParams() {
        VehicleExpenseForecastModel vehicleExpenseForecastModel = new VehicleExpenseForecastModel("nome", "marca", 2021, 25.5f, 13.3f);
        Mockito.when(this.service.getExpenseForecast(new BigDecimal("8.3"), new BigDecimal("8.3"), new BigDecimal("8.3")))
                .thenReturn(List.of(vehicleExpenseForecastModel));

        RestAssuredMockMvc.given()
                .accept(ContentType.JSON)
                .get("/api/v1/veiculos/previsao-gastos")
                .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }


}
