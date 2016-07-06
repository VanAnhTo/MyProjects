
package Common;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class Util {
	public static final String URL ="http://www.demo.guru99.com";
	
	//account for login
	public static final String USENAME ="mngr39278" ;
	public static final String PASSWORD = "bUdEguh";
	
	//expected output
	public static final String EXPECTED_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXPECTED_ERROR = "User or Password is not valid";
	
	//information of excel data
	public static final String FILE_PATH ="F:/Selenium/Datatest/testData.xls";
	public static final String SHEET_NAME="Data";
	public static final String TABLE_NAME="testData";
	
	
	
	//method read data from excel
	public static String[][] getDataFromExcel(String xlFilePath, String sheetName, String tableName) throws Exception
	{
		//khoi tao mang 2 chieu de luu du lieu doc tu file excel 
		String[][] tableArray;
		
		//khoi tao vung doi tuong suu dung file excel
		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		//lay ten cua sheet
		Sheet sheet = workbook.getSheet(sheetName);
		
		int startRow, startCol, endRow, endCol, ci, cj;
		
		//tim o dau tien chua ten bang
		Cell tableStart = sheet.findCell(tableName);
		//Vi tri cua dong dau tien cua bang
		startRow = tableStart.getRow();
		//Vi tri cua dot dau tien cua bang
		startCol = tableStart.getColumn();
		
		//tim vi tri danh dau ket thuc cua bang
		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1,
				100, 64000, false);
		//tim dong cuoi cung trong bang
		endRow = tableEnd.getRow();
		//Tim cot cuoi cung trong bang:
		endCol = tableEnd.getColumn();
		
		tableArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;
		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				//Get content of each cell and store to each array element.
				tableArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tableArray);
	}
	
	
}
