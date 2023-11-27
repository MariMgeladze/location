package softlab.homework.location.services;

import softlab.homework.location.entities.Vehicles;


import java.util.List;

public interface VehiclesService {

    List<Vehicles> search(Integer vehicleId, String vehicleNumber, Integer vehicleType);


   // List<Vehicles> searchByVehiclesNumber(String vehicleNumber);


  //  List<Vehicles> findAllByVehicleNumber(String vehicleNumber);


    void addNewVehicle(Vehicles data);


    // List<Vehicles> findAllByVehicleNumber(String vehicleNumber);
}
