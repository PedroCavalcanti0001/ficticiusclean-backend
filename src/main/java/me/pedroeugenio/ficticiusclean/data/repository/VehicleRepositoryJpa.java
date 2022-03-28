package me.pedroeugenio.ficticiusclean.data.repository;

import me.pedroeugenio.ficticiusclean.data.entity.VehicleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepositoryJpa extends JpaRepository<VehicleDTO, Long> {

}
