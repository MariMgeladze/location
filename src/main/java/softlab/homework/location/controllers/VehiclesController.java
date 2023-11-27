package softlab.homework.location.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import softlab.homework.location.entities.Vehicles;
import softlab.homework.location.services.VehiclesService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehiclesController {
   private final VehiclesService vehiclesService;

   @PostMapping("vehicles")
   public void addNewVehicles(@RequestBody Vehicles data){
        vehiclesService.addNewVehicle(data);
   }

    @GetMapping("vehicles")
    public List<Vehicles> search(Integer vehicleId, String vehicleNumber, Integer vehicleType) {
        return vehiclesService.search(vehicleId, vehicleNumber, vehicleType);
    }

    /*@GetMapping("searchByNumber")
    public List<Vehicles>searchByVehicleNumber(String vehicleNumber){
        return vehiclesService.findByVehicleNumber(vehicleNumber);
    }*/

}
