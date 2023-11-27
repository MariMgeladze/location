package softlab.homework.location.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softlab.homework.location.entities.Vehicles;

import java.util.List;
import java.util.Optional;

public interface VehiclesRepository extends JpaRepository<Vehicles,Integer> {
    Optional<Vehicles> findAllByVehicleNumber(String vehicleNumber);






}
