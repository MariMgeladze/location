package softlab.homework.location.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import softlab.homework.location.entities.ExcelInfo;
import softlab.homework.location.services.CalculateDistanceService;
import softlab.homework.location.services.ExcelInfoService;
import softlab.homework.location.services.ExcelUploadService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping ("vehicle_location")

public class ExcelInfoController {

    private final ExcelInfoService excelInfoService;
    private final ExcelUploadService excelUploadService;

    @PostMapping ("upload vehicle_location")
    public ResponseEntity<?> uploadExcelInfoData(@RequestParam("file")MultipartFile file){
        this.excelInfoService.saveExcelInfoToDatabase(file);
        return ResponseEntity.ok(Map.of("message", "Data uploaded successfully and saved in Database"));

    }

@GetMapping
    public ResponseEntity<List<ExcelInfo>>getExcelInfo(){
        return new ResponseEntity<>(excelInfoService.getExcelInfo(), HttpStatus.FOUND);
    }


    @GetMapping("calcDist")
    public ResponseEntity<List<ExcelInfo>> distanceCalc(@RequestParam("latitude")double latitude,
                                                             @RequestParam("longitude")double longitude){
        List<ExcelInfo>excelInfo = excelInfoService.getExcelInfo();
        for(ExcelInfo info  : excelInfo) {
            double distance = calculateDistance(latitude, longitude, info.getLatitude(), info.getLongitude());
        }
        return new ResponseEntity<>(excelInfo,HttpStatus.OK);
    }

       private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);


        return Math.sqrt(x * x + y * y) * 6371;

    }
}

//the EARTH_RADIUS is a constant equal to 6371



