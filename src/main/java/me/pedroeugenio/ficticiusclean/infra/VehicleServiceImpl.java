package me.pedroeugenio.ficticiusclean.infra;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleDTO;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastDTO;
import me.pedroeugenio.ficticiusclean.domain.usecase.VehicleService;
import me.pedroeugenio.ficticiusclean.infra.entity.VehicleEntity;
import me.pedroeugenio.ficticiusclean.infra.entity.VehicleExpenseEntity;
import me.pedroeugenio.ficticiusclean.infra.repository.VehicleExpenseRepositoryJpa;
import me.pedroeugenio.ficticiusclean.infra.repository.VehicleRepositoryJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleRepositoryJpa vehicleRepository;

    @Autowired
    private VehicleExpenseRepositoryJpa vehicleExpenseRepositoryJpa;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        final VehicleEntity entity = VehicleEntity.fromDto(vehicleDTO, modelMapper);
        vehicleRepository.save(entity);
    }

    @Override
    public List<VehicleExpenseForecastDTO> getExpenseForecast(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways) {
        final List<VehicleExpenseEntity> entities = vehicleExpenseRepositoryJpa.findAllSortedVehicle(price, kmTraveledInTheCity, kmTraveledInTheHighways);
        return entities.stream().map(e -> e.toDto(modelMapper)).collect(Collectors.toList());
    }
}
