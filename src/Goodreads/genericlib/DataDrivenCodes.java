package Goodreads.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenCodes {
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\arup7\\OneDrive\\Desktop\\Goodreads.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

	public String getDataFromExcel(String sheetname, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\arup7\\OneDrive\\Desktop\\Goodreads.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return value;

	}

}
