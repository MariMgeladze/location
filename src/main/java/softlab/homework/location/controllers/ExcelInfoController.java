package softlab.homework.location.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import softlab.homework.location.entities.ExcelInfo;
import softlab.homework.location.models.VehiclesDistance;
import softlab.homework.location.services.ExcelInfoService;
import softlab.homework.location.services.ExcelUploadService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("vehicle_location")

public class ExcelInfoController {

    private final ExcelInfoService excelInfoService;
    private final ExcelUploadService excelUploadService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadExcelInfo(@RequestParam("file") MultipartFile file) {
        this.excelInfoService.saveExcelInfoToDatabase(file);
        return ResponseEntity.ok(Map.of("message", "Data uploaded successfully and saved in Database"));

    }

    @GetMapping
    public ResponseEntity<List<ExcelInfo>> getExcelInfo() {
        return new ResponseEntity<>(excelInfoService.getExcelInfo(), HttpStatus.FOUND);
    }


    @GetMapping("/calcDist")
    public ResponseEntity<List<VehiclesDistance>> distanceCalc(@RequestParam("latitude") double latitude,
                                                        @RequestParam("longitude") double longitude) {
        List<ExcelInfo> excelData = excelInfoService.getExcelInfo();
        List<VehiclesDistance> vehiclesDistances = new ArrayList<>();
        for (ExcelInfo info : excelData) {
            double distance = calculateDistance(latitude, longitude, info.getLatitude(), info.getLongitude());
        VehiclesDistance vehiclesDistance = new VehiclesDistance();
        vehiclesDistance.setNumber(info.getNumber());
        vehiclesDistance.setDistance(distance);
        vehiclesDistances.add(vehiclesDistance);

            }
        vehiclesDistances.sort(Comparator.comparingDouble(VehiclesDistance::getDistance));


        return new ResponseEntity<>(vehiclesDistances, HttpStatus.OK);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);
        double distance;

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);

        distance = Math.sqrt(x * x + y * y) * 6371;


        return distance;

    }
}

//the EARTH_RADIUS is a constant equal to 6371



