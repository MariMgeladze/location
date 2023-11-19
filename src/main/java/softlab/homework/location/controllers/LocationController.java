package softlab.homework.location.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softlab.homework.location.entities.CurrentCoordinates;
import softlab.homework.location.models.VehicleCoordinates;
import softlab.homework.location.services.LocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;


    @PostMapping("coordinates")
    public void setLocation(@RequestBody VehicleCoordinates data){
        locationService.gettingCoordinates(data.getLongitude(), data.getLatitude(), data.getNumber());
    }


}









