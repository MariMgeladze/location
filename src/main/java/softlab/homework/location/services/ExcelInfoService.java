package softlab.homework.location.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import softlab.homework.location.entities.ExcelInfo;
import softlab.homework.location.repositories.ExcelInfoRepository;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelInfoService {

    private final ExcelInfoRepository excelInfoRepository;

    public void saveExcelInfoToDatabase(MultipartFile file) {
        try {
            List<ExcelInfo> excelData = ExcelUploadService.getExcelInfoFromExcel
                    (file.getInputStream());
            this.excelInfoRepository.saveAll(excelData);
        } catch (Exception e) {
            throw new IllegalArgumentException("file not valid");
        }
    }

    public List<ExcelInfo> getExcelInfo() {
        return excelInfoRepository.findAll();
    }
}

