package softlab.homework.location.services;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import softlab.homework.location.entities.ExcelInfo;
import softlab.homework.location.repositories.ExcelInfoRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelUploadService {
    private final ExcelInfoRepository excelInfoRepository;

    public static List<ExcelInfo> getExcelInfoFromExcel(InputStream inputStream) {
        List<ExcelInfo> excelData = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("vehicle_location");
            Iterator<Row> rows = sheet.iterator();

            int rowIndex = 0;

            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();

                int cellIndex = 0;
                ExcelInfo excelInfo = new ExcelInfo();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0 -> excelInfo.setLatitude(cell.getNumericCellValue());
                        case 1 -> excelInfo.setLongitude(cell.getNumericCellValue());
                        case 2 -> excelInfo.setNumber(cell.getStringCellValue());
                    }
                    cellIndex++;
                }
                excelData.add(excelInfo);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return excelData;
    }


}


