package me.pedroeugenio.ficticiusclean.data;

import me.pedroeugenio.ficticiusclean.domain.model.VehicleModel;
import me.pedroeugenio.ficticiusclean.domain.model.VehicleExpenseForecastModel;
import me.pedroeugenio.ficticiusclean.domain.usecase.VehicleService;
import me.pedroeugenio.ficticiusclean.data.entity.VehicleDTO;
import me.pedroeugenio.ficticiusclean.data.entity.VehicleExpenseDTO;
import me.pedroeugenio.ficticiusclean.data.repository.VehicleExpenseRepositoryJpa;
import me.pedroeugenio.ficticiusclean.data.repository.VehicleRepositoryJpa;
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
    public void save(VehicleModel vehicleModel) {
        final VehicleDTO entity = VehicleDTO.fromDto(vehicleModel, modelMapper);
        vehicleRepository.save(entity);
    }

    @Override
    public List<VehicleExpenseForecastModel> getExpenseForecast(BigDecimal price, BigDecimal kmTraveledInTheCity, BigDecimal kmTraveledInTheHighways) {
        final List<VehicleExpenseDTO> entities = vehicleExpenseRepositoryJpa.findAllSortedVehicle(price, kmTraveledInTheCity, kmTraveledInTheHighways);
        return entities.stream().map(e -> e.toDto(modelMapper)).collect(Collectors.toList());
    }
}
