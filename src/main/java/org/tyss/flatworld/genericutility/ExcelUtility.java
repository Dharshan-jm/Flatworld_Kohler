package org.tyss.flatworld.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method retrieves a cell value based on a unique test case ID and a header value.
	 * 
	 * @param excelPath   - Path to the Excel file
	 * @param sheetName   - Name of the sheet
	 * @param uniqueData  - Unique identifier for the row (test case ID)
	 * @param header      - Header name to identify the column
	 * @return Value from the specified cell
	 * @throws EncryptedDocumentException, IOException
	 */
	public String getCellDataBasedOnTcIdAndHeader(String excelPath, String sheetName,
			String uniqueData, String header) throws EncryptedDocumentException, IOException {
		String value = "";
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();

		for (int i = 1; i < rowCount; i++) {
			String actualUniqueData = sheet.getRow(i).getCell(0).getStringCellValue();
			if (actualUniqueData.equalsIgnoreCase(uniqueData)) {
				int columnCount = sheet.getRow(i).getPhysicalNumberOfCells();
				for (int j = 1; j < columnCount; j++) {
					String actualHeader = sheet.getRow(0).getCell(j).getStringCellValue();
					if (actualHeader.equalsIgnoreCase(header)) {
						value = sheet.getRow(i).getCell(j).getStringCellValue();
						UtilityObjectClass.getExtentTest().info("Data retrieved from Excel: " + value); // Logging to Extent Report
						break;
					}
				}
				if (!value.isEmpty()) {
					break;
				}
			}
		}
		workbook.close();
		fis.close();

		if (value.isEmpty()) {
			UtilityObjectClass.getExtentTest().warning("No matching data found for Test Case ID: " + uniqueData + " and Header: " + header);
		}

		return value;
	}

	/**
	 * This method retrieves the entire row of data based on a unique test case ID.
	 * 
	 * @param excelPath     - Path to the Excel file
	 * @param sheetName     - Name of the sheet
	 * @param testCaseName  - Unique identifier for the row (test case ID)
	 * @return A Map containing header-value pairs for the entire row
	 * @throws EncryptedDocumentException, IOException
	 */
	public Map<String, String> getEntireTcDataBasedOnTcId(String excelPath, String sheetName,
			String testCaseName){
		Map<String, String> map = new LinkedHashMap<String, String>();
		try(FileInputStream fis = new FileInputStream(excelPath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			String value = "";
			String actualTestCaseName = "";
			String actualKey = "";

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				try {
					actualTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
				} catch (Exception e) {
					UtilityObjectClass.getExtentTest().warning("Error reading test case name at row: " + i);
				}

				if (actualTestCaseName.equalsIgnoreCase(testCaseName)) {
					for (int j = 0; j <= sheet.getRow(0).getLastCellNum(); j++) {
						try {
							actualKey = sheet.getRow(0).getCell(j).toString();
							try {
								value = sheet.getRow(i).getCell(j).toString();
							} catch (Exception e) {
								//							UtilityObjectClass.getExtentTest().warning("No data found in cell (" + i + ", " + j + ")");
							}
							map.put(actualKey.trim(), value.trim());
						} catch (Exception e) {
							//						UtilityObjectClass.getExtentTest().warning("Error reading data for key: " + actualKey + " at column: " + j);
						}
					}
					break;
				}
			}
			workbook.close();
		}catch (Exception e) {
			// TODO: handle exception
		}

		if (map.isEmpty()) {
			UtilityObjectClass.getExtentTest().warning("No data found for Test Case ID: " + testCaseName);
		} else {
			UtilityObjectClass.getExtentTest().info("Data retrieved for Test Case ID: " + testCaseName + " - " + map.toString());
		}
		return map;
	}

	/**
	 * This method writes data to a specific cell based on a test case ID and a header.
	 * 
	 * @param excelPath     - Path to the Excel file
	 * @param sheetName     - Name of the sheet
	 * @param testCaseName  - Unique identifier for the row (test case ID)
	 * @param requiredKey   - Header name to identify the column
	 * @param data          - Data to be written
	 * @return The previous value in the cell before updating
	 * @throws EncryptedDocumentException, IOException
	 */
	public String writeDataToCellBasedOnTcIdAndHeader(String excelPath, String sheetName, String testCaseName,
			String requiredKey, String data){
		String value = "";
		String actualTestCaseName = "";
		String actualKey = "";
		boolean flag = false;

		try (FileInputStream fis = new FileInputStream(excelPath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				try {
					actualTestCaseName = sheet.getRow(i).getCell(0).getStringCellValue();
				} catch (Exception e) {
					UtilityObjectClass.getExtentTest().warning("Error reading test case name at row: " + i);
				}

				if (actualTestCaseName.equalsIgnoreCase(testCaseName)) {
					for (int j = 1; j <= sheet.getRow(0).getLastCellNum(); j++) {
						try {
							actualKey = sheet.getRow(0).getCell(j).getStringCellValue();
						} catch (Exception e) {
							//						UtilityObjectClass.getExtentTest().warning("Error reading header at column: " + j);
						}

						if (actualKey.equalsIgnoreCase(requiredKey)) {
							try {
								value = sheet.getRow(i).getCell(j).toString();
								sheet.getRow(i).createCell(j).setCellValue(data);
								UtilityObjectClass.getExtentTest().info("Data written to cell (" + i + ", " + j + "): " + data);
							} catch (Exception e) {
								//							UtilityObjectClass.getExtentTest().fail("Failed to write data to cell (" + i + ", " + j + ")");
							}
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					break;
				}
			}

			FileOutputStream fos = new FileOutputStream(excelPath);
			workbook.write(fos);
			fos.close();
			workbook.close();
		} catch (Exception e) {
			// TODO: handle exception
		}


		if (flag) {
			UtilityObjectClass.getExtentTest().info("Data successfully updated for Test Case ID: " + testCaseName + " and Header: " + requiredKey);
		} else {
			UtilityObjectClass.getExtentTest().fail("Failed to find matching Test Case ID: " + testCaseName + " or Header: " + requiredKey);
		}
		return value;
	}

	/**
	 * This method is used to Get Page verification data.
	 * @param excelPath
	 * @param sheetName
	 * @return
	 */
	public Map<String, String> getPageVerificationData(String excelPath, String sheetName) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		try(FileInputStream fis = new FileInputStream(excelPath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				map.put(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString());
			}
			workbook.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		if (map.isEmpty()) {
			UtilityObjectClass.getExtentTest().info("No data found.");
		} else {
			UtilityObjectClass.getExtentTest().info("Page verification Data retrieved: - " + map.toString());
		}
		return map;
	}
}
