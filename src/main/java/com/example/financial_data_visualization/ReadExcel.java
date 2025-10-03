package com.example.financial_data_visualization;

import com.example.financial_data_visualization.UserRepository;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ReadExcel {
    private final UserRepository userRepository;
    private final FinancialRecordRepository recordRepository;

    public ReadExcel(UserRepository userRepository, FinancialRecordRepository recordRepository){
        this.userRepository = userRepository;
        this.recordRepository = recordRepository;
    }

    // checks if the file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();

        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
            return  true;
        }else {
            return false;
        }
    }


//    public void saveExcelData(MultipartFile file) throws Exception {
//        InputStream is = file.getInputStream();
//        Workbook workbook = new XSSFWorkbook(is);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (Row row : sheet) {
//            if (row.getRowNum() == 0) continue; // skip header
//
//            String name = row.getCell(0).getStringCellValue();
//            int year = (int) row.getCell(1).getNumericCellValue();
//            String month = row.getCell(2).getStringCellValue();
//            double amount = row.getCell(3).getNumericCellValue();
//
//            // Check if user exists, otherwise create
//            User user = userRepository.findByName(name);
//            if (user == null) {
//                user = new User();
//                user.setName(name);
//                user = userRepository.save(user);
//            }
//
//            FinancialRecord record = new FinancialRecord();
//            record.setUser(user);
//            record.setYear(year);
//            record.setMonth(month);
//            record.setAmount(amount);
//            recordRepository.save(record);
//        }
//
//        workbook.close();

 //   }

    public List<FinancialRecord> convertExcelToListOfProduct(InputStream is){
        List<FinancialRecord> list = new ArrayList<>();

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("sheet 1");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()){
                Row row = iterator.next();

                if(rowNumber == 0){
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;
                Product p = new Product();

                while (cells.hasNext()){
                    Cell cell = cells.next();

                    switch (cid){
                        case 0:
//                            p.setData((Long) cell.getStringCellValue());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
