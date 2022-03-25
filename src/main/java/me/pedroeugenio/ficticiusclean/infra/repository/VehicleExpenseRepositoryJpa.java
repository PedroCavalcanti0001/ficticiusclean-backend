package me.pedroeugenio.ficticiusclean.infra.repository;

import me.pedroeugenio.ficticiusclean.infra.entity.VehicleExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VehicleExpenseRepositoryJpa extends JpaRepository<VehicleExpenseEntity, Long> {

    List<VehicleExpenseEntity> findAllSortedVehicle(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways);
}
