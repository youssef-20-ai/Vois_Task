package DataManipulation;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Excel_Sheet_Manipulation {

    public void readDataFromExcel(String filePath)
    {
        try( FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream))
        {
            Sheet sheet = workbook.getSheetAt(0);

            int rowIndex = 0;

            for (Row row : sheet) {
                if (rowIndex == 0)
                {
                    rowIndex++;
                    continue;
                }

                row.createCell(3).setCellValue(calculateYearsSpentInVois(row.getCell(2)
                        .getStringCellValue()));
            }

            writeDataToExcel(filePath , workbook);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeDataToExcel(String filePath , Workbook workbook) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        workbook.write(fileOutputStream);
    }


    public static long calculateYearsSpentInVois(String joinDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMMdd,yyyy");

        String d = joinDate.split("," , 2)[1].replace(" " , "");

        LocalDate date = LocalDate.parse(d , formatter);

        return  ChronoUnit.YEARS.between(date , LocalDate.now());
    }

}
