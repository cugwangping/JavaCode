package readExcel;

import dbAccessLayer.DBAccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarInputStream;

import javax.swing.JButton;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.jdbc.Util;

/**
 * read xlsl format excel file and write to mysql
 * the struct of the data table is:
 * CATEGORY CALL GROUPS final_case_type CASE DESC occ_date x_coordinate y_coordinate census_tract 
 * @author student
 */
public class ReadExcel {
	private String mfilename;
	private String insertStr;
	private DBAccess dbAccess;
	
	public ReadExcel(String filename){
		this.mfilename = filename;
		this.insertStr = "INSERT INTO `crime_event`.`NIJ2016_JAN01_JUL31` (`CATEGORY`, `CALL GROUPS`,"
				+ " `final_case_type`, `CASE DESC`, `occ_date`, `x_coordinate`, `y_coordinate`,"
				+ " `census_tract`) VALUES ";
		this.dbAccess = new DBAccess();
	}
	
	public boolean xlsxRead(){
		// Create an ArrayList to store the data read from excel sheet.
		List sheetData = new ArrayList();
		FileInputStream file = null;
		try {
			file = new FileInputStream(mfilename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Create an excel workbook from the file system.
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Get the first sheet on the workbook.
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Iterator
		Iterator rows = sheet.rowIterator();
		//过滤标题
		if (rows.hasNext()) {
			XSSFRow row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext()) 
			{
				XSSFCell cell = (XSSFCell) cells.next();
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getRichStringCellValue() + "***");
				}
			}
		}
		System.out.println("\n");
		String insert = "";
		while (rows.hasNext()) 
		{
			XSSFRow row = (XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			insert += "("; 
			while (cells.hasNext()) 
			{
				XSSFCell cell = (XSSFCell) cells.next();
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					if (DateUtil.isCellDateFormatted(cell)) 
					{
						java.util.Date time = cell.getDateCellValue();
						//System.out.println(time);
						Date dt = new Date(time.getTime());
						//System.out.println(dt.toString());
						insert += "'" + dt.toString() + "',";
					}else{
						insert += "'" + cell.getNumericCellValue() + "',";
					}
				}
				else if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					insert += "'" + (cell.getRichStringCellValue()) + "',";
				}
			}
			insert = insert.substring(0, insert.length()-1);
			insertStr += insert + "),";
			insert = "";
		}
		//put the excel data into the database
		insertStr = insertStr.substring(0, insertStr.length()-1);
		insertStr += ";";
		System.out.println(insertStr);
		if(insertStr.length() >= Integer.MAX_VALUE)
		{
			System.out.println("字符串长度超过限制");
			return false;
		}
		System.out.println("数据插入处理中");
		if(dbAccess.insertInfo(insertStr)){
			System.out.println("数据插入成功");
			return true;
		}
		else{
			System.out.println("数据插入失败");
			return false;
		}
	}

	public static void main(String[] args){
		//String filename = "D:/Downloads/zip_download/CrimeData/unzip-file"
				//+ "/010116_073116_Data/NIJ2016_JAN01_JUL31.xlsx";
		String filename = "test.xlsx";
		//String filename = "read.xlsx";
		ReadExcel read_excel =new ReadExcel(filename);
		read_excel.xlsxRead();
	}
}