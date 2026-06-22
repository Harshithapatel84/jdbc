package runner;

import dao.PrgLangDetailDAO;
import dao.impl.PrgLangDetailDaoImpl;
import dto.PrgLangDetailDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class Runner {

    public static void main(String[] args) {

        PrgLangDetailDAO dao = new PrgLangDetailDaoImpl();

        try {
            FileInputStream file = new FileInputStream("C:\\Users\\WIN\\Documents\\PrLang Data.xlsx");

            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue; // Skip header row
                }

                PrgLangDetailDTO dto = new PrgLangDetailDTO();

                dto.setLangName(row.getCell(0).getStringCellValue());
                dto.setCurtVersion(row.getCell(1).getStringCellValue());
                dto.setDevelopedYear((int) row.getCell(2).getNumericCellValue());
                dto.setDevelopedBy(row.getCell(3).getStringCellValue());
                String value = row.getCell(4).getStringCellValue();
                dto.setOpenSource(value.equalsIgnoreCase("Yes"));

                dao.save(dto);
            }

            workbook.close();
            file.close();

            System.out.println("Excel data inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}