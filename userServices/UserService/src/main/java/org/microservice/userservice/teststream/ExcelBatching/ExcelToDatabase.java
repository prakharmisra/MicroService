package org.microservice.userservice.teststream.ExcelBatching;

//import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcelToDatabase {
    public static void main(String[] args) {
  /*
        String excelFilePath = "path/to/your/excel/file.xlsx";
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (FileInputStream inputStream = new FileInputStream(excelFilePath);
             Connection connection = DriverManager.getConnection(dbUrl, username, password)) {

            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);


            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO your_table (column1, column2) VALUES (?, ?)");

            connection.setAutoCommit(false);

            for (Row row : sheet) {
                // Assuming first two columns of the Excel file correspond to column1 and column2 in the database
                String value1 = row.getCell(0).getStringCellValue();
                String value2 = row.getCell(1).getStringCellValue();

                preparedStatement.setString(1, value1);
                preparedStatement.setString(2, value2);

                preparedStatement.addBatch();
            }

            int[] result = preparedStatement.executeBatch();

            for (int i : result) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    connection.rollback();
                    throw new SQLException("Failed to insert data into the database.");
                }
            }

            connection.commit();

            System.out.println("Data successfully inserted into the database.");

        } catch (IOException | SQLException | InvalidFormatException e) {
            e.printStackTrace();
        }

       */
    }
}

/*

import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ExcelToDatabaseService {

    private final YourEntityRepository repository;

    @Autowired
    public ExcelToDatabaseService(YourEntityRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void processExcelFile(String excelFilePath) {
        try (FileInputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Assuming first two columns of the Excel file correspond to column1 and column2 in the database
                String value1 = row.getCell(0).getStringCellValue();
                String value2 = row.getCell(1).getStringCellValue();

                YourEntity entity = new YourEntity();
                entity.setColumn1(value1);
                entity.setColumn2(value2);

                repository.save(entity);
            }

            System.out.println("Data successfully inserted into the database.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



 */
