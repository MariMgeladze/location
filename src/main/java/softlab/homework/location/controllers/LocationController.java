package softlab.homework.location.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import softlab.homework.location.models.VehicleCoordinates;
import softlab.homework.location.services.LocationService;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;


    @PostMapping("coordinates")
    public void setLocation(@RequestBody VehicleCoordinates data) {
        locationService.gettingCoordinates(data.getLongitude(), data.getLatitude(), data.getNumber());
    }


}









