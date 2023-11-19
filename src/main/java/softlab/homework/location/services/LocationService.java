package softlab.homework.location.services;

import softlab.homework.location.entities.CurrentCoordinates;
import softlab.homework.location.entities.VehicleLocationHistory;

import java.util.List;

public interface LocationService {
   void gettingCoordinates(double longitude, double latitude, String number);
}
