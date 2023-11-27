package softlab.homework.location.services;

import softlab.homework.location.entities.Vehicles;


import java.util.List;

public interface VehiclesService {

    List<Vehicles> search(Integer vehicleId, String vehicleNumber, Integer vehicleType);

    void addNewVehicle(Vehicles data);

}
