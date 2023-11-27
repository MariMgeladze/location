package softlab.homework.location.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import softlab.homework.location.entities.Vehicles;
import softlab.homework.location.repositories.VehiclesRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiclesServiceImpl implements VehiclesService {
    private final VehiclesRepository vehiclesRepository;


    @Override
    public List<Vehicles> search(Integer vehicleId, String vehicleNumber, Integer vehicleType) {
        return vehiclesRepository.findAll();
    }


    /*@Override
    public List<Vehicles> findByVehicleNumber(String vehicleNumber) {
        return vehiclesRepository.findByVehicleNumber();
            }*/

    @Override
    public void addNewVehicle(Vehicles data){
        Vehicles vehicles = new Vehicles();
        vehicles.setVehicleNumber(data.getVehicleNumber());
        vehicles.setDriverId(data.getDriverId());
        vehicles.setVehicleType(data.getVehicleType());
        vehicles.setPayload(data.getPayload());
        vehicles.setStatus(true);
        vehicles.setLength(data.getLength());
        vehicles.setHeight(data.getHeight());
        vehicles.setWidth(data.getWidth());
        vehiclesRepository.save(vehicles);

    }
}
