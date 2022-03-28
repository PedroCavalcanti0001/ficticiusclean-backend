package me.pedroeugenio.ficticiusclean.data.repository;

import me.pedroeugenio.ficticiusclean.data.entity.VehicleExpenseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleExpenseRepositoryJpa extends JpaRepository<VehicleExpenseDTO, Long> {

    List<VehicleExpenseDTO> findAllSortedVehicle(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways);
}
