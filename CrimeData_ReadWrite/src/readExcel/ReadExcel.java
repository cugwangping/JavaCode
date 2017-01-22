package readExcel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		
		//String filename = "D:/Downloads/zip_download/CrimeData/unzip-file/010116_073116_Data/NIJ2016_JAN01_JUL31.xlsx";
		String filename = "test.xlsx";
		
		// Create an ArrayList to store the data read from excel sheet.
		
		List sheetData = new ArrayList();
		FileInputStream file = new FileInputStream(filename);

			// Create an excel workbook from the file system.
			//
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//
			// Get the first sheet on the workbook.
			//
			XSSFSheet sheet = workbook.getSheetAt(0);

			//
			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.
			//过滤标题
			Iterator rows = sheet.rowIterator();
			
			if (rows.hasNext()) {
				XSSFRow row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				if (cells.hasNext()) {
					cells.next();
					//data.add(cell);
				}

				//sheetData.add(data);
			}
			while (rows.hasNext()) {
				XSSFRow row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();
					data.add(cell);
				}

				sheetData.add(data);
			}

		showExcelData(sheetData);
	}

	private static void showExcelData(List sheetData) {
		//
		// Iterates the data and print it out to the console.
		//Write the data to the file
//		PrintWriter writer = null;
//		try {
//			writer = new PrintWriter("crime_data.txt", "UTF-8");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for (int i = 0; i < sheetData.size(); i++)
		{
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) 
			{
				Cell cell = (Cell) list.get(j);
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					if (DateUtil.isCellDateFormatted(cell)) 
					{
						System.out.print(cell.getDateCellValue());
					}else{
						System.out.print(cell.getNumericCellValue());
					}
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getRichStringCellValue());
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) 
				{
					System.out.print(cell.getBooleanCellValue());
				}
				if (j < list.size() - 1) 
				{
					System.out.print(" ");
				}
			}
			System.out.println("\n");
		}
	}
}