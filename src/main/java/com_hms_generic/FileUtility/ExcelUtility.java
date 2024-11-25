   package com_hms_generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
public String getDatafromExcelfile(String sheetname,int row,int cell) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
	wb.close(); 
	return data;
	
}
public int getRowcount(String sheetname) throws  IOException 
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	int rowcount=wb.getSheet(sheetname).getLastRowNum();
	wb.close();
	return rowcount;
}
public void setDataintoExcelfile(String sheetname,int row,int cell,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(row).createCell(cell,CellType.STRING).setCellValue(data);
	FileOutputStream fo=new FileOutputStream("./src/test/resources/Practice.xlsx");
	wb.write(fo);
	wb.close();
	
}
public String[][] getMutipleDatafromExcelfile(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream("./src/test/resources/testData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet(sheetName);
int rowcount=s.getLastRowNum();
int cellCount=s.getRow(0).getLastCellNum();
String [][]r=new String[rowcount][cellCount];
for(int i=0;i<rowcount;i++)
{
	for(int j=0;j<cellCount;j++)
{try 
{
	 
	r[i][j]=s.getRow(i).getCell(j).toString();
}
catch (Exception e) {
	// TODO: handle exception
}
	}
}
	wb.close(); 
	return r;
}


}