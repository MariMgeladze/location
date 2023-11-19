package softlab.homework.location.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softlab.homework.location.entities.CurrentCoordinates;
import softlab.homework.location.repositories.CurrentCoordinatesRepository;
import softlab.homework.location.repositories.VehicleLocationHistoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class LocationServiceImpl implements LocationService {

    private final CurrentCoordinatesRepository currentCoordinatesRepository;
    private final VehicleLocationHistoryRepository vehicleLocationHistoryRepository;
    @Override
    public void  gettingCoordinates(double longitude, double latitude, String number) {
        Optional<CurrentCoordinates> currentCoordinates = currentCoordinatesRepository.findByNumber(number);
        if(currentCoordinates.isEmpty()){
            throw new RuntimeException("number not found");
        }

        currentCoordinates.get().setLatitude(latitude);
        currentCoordinates.get().setLongitude(longitude);
        currentCoordinatesRepository.save(currentCoordinates.get());

    }

}
