package com.example.financial_data_visualization;

import com.example.financial_data_visualization.ReadExcel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    private final ReadExcel readExcel;

    public ExcelController(ReadExcel readExcel) {
        this.readExcel = readExcel;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        try {
            readExcel.saveExcelData(file);
            return ResponseEntity.ok("File uploaded and data saved!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to process file.");}
    }
}
