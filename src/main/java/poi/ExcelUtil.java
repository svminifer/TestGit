package poi;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {

	public static void updatePoi(){
		// 指定文件路径
		String filePath = "workbook.xlsx";

		try (Workbook workbook = getExistingWorkbook(filePath)) {
			// 判断是否已经存在表头
			if (workbook.getSheet("Sheet1") == null) {
				// 如果不存在表头，创建表头
				createHeader(workbook.createSheet("Sheet1"));
			}

			// 写入行数据
			Object[][] data = {
					{"Data4-1", "Data4-2", "Data4-3"},
					{"Data5-1", "Data5-2", "Data5-3"},
					{"Data6-1", "Data6-2", "Data6-3"}
			};

			appendData(workbook.getSheet("Sheet1"), data);

			// 保存文件
			try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
				workbook.write(fileOut);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Workbook getExistingWorkbook(String filePath) throws IOException {
		try {
			// 尝试读取现有文件
			return WorkbookFactory.create(new FileInputStream(filePath));
		} catch (IOException e) {
			// 文件不存在，创建一个新的工作簿
			return new XSSFWorkbook();
		}
	}

	private static void createHeader(Sheet sheet) {
		// 写入表头
		Row headerRow = sheet.createRow(0);
		String[] headers = {"Column1", "Column2", "Column3"};
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
		}
	}

	private static void appendData(Sheet sheet, Object[][] data) {
		int lastRowNum = sheet.getLastRowNum() + 1;
		for (Object[] rowData : data) {
			Row row = sheet.createRow(lastRowNum++);
			int colNum = 0;
			for (Object field : rowData) {
				Cell cell = row.createCell(colNum++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Double) {
					cell.setCellValue((Double) field);
				}
				// 添加其他数据类型的处理逻辑，根据需要
			}
		}
	}
}
