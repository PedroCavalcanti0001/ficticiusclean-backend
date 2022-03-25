package me.pedroeugenio.ficticiusclean.infra.repository;

import me.pedroeugenio.ficticiusclean.infra.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepositoryJpa extends JpaRepository<VehicleEntity, Long> {

}
