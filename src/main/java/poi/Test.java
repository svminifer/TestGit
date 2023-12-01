package poi;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	public static final Map<String, String> changeMap = new HashMap<>();

	static {
		changeMap.put("id", "序号");
		changeMap.put("title", "标题");
		changeMap.put("publish_time", "发布时间");
		changeMap.put("publish_type", "发布类型");
		changeMap.put("read_amount", "阅读量");
		changeMap.put("comment_amount", "评论量");
		changeMap.put("like_amount", "点赞量");
		changeMap.put("share_amount", "分享量");
		changeMap.put("collection_amount", "收藏量");
		changeMap.put("quality_audit_type", "审核类型");
		changeMap.put("quality_not_pass_reason", "审核理由");
		changeMap.put("quality_status", "审核状态");
	}


	interface BaiJiaConstant {

		String read = "阅读";

		String comment = "评论";

		String time = "前";

	}

	private static List<String> parseContentData(String text) {
		List<String> data = new ArrayList<>();
		// 4阅读0评论04-26 11:24 4阅读0评论12天前
		String[] split = text.split(BaiJiaConstant.read);
		data.add(split[0]);
		if (split.length <= 1) {
			return data;
		}
		String[] split1 = split[1].split(BaiJiaConstant.comment);
		data.add(split1[0]);
		if (split1.length <= 1) {
			return data;
		}
		if (BaiJiaConstant.time.equalsIgnoreCase(split1[1])) {
			data.add(getNumbers(split1[1]));
		} else {
			data.add(split1[1]);
		}
		return data;
	}

	private static String getNumbers(String input) {
		// 使用正则表达式匹配数字
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(input);

		// 使用StringBuilder来构建结果
		StringBuilder result = new StringBuilder();

		// 遍历匹配结果并追加到StringBuilder
		while(matcher.find()) {
			result.append(matcher.group());
		}
		return result.toString();
	}

	public static void main(String[] args) {
		File folder = new File("D:\\GitHub\\TestGit\\src\\main\\java\\poi\\分析");

		for (int i = 0; i < folder.listFiles().length; i++) {
			String filePath = "D:\\GitHub\\TestGit\\src\\main\\java\\poi\\分析\\1 - 副本 (" + (i + 1) + ").txt";
			analyzeData(filePath);
		}
	}

	private static void analyzeData(String filePath) {
		// 指定要读取的文本文件的路径
		StringBuilder sb = new StringBuilder();

		try {
			// 使用BufferedReader来读取文件内容
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			String line;
			// 逐行读取文件内容并输出到控制台
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}

			// 关闭文件读取流
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String json = sb.toString();
		HashMap map = JsonUtil.toJava(json, HashMap.class);

		String tag = "id、title、publish_time、publish_type、read_amount、comment_amount、like_amount、share_amount、collection_amount、quality_audit_type、quality_not_pass_reason、quality_status";
		String[] sheetHeaders = tag.split("、");
		List<Map<String, String>> dataList = new ArrayList<>();
		for (Object o : ((ArrayList) (((HashMap) map.get("data")).get("list")))) {
			HashMap oMap = (HashMap) o;
			Map<String, String> keyMap = new HashMap<>();
			for (String s : sheetHeaders) {
				Object o1 = oMap.get(s);
				if (o1 != null) {
					keyMap.put(changeMap.getOrDefault(s, s), String.valueOf(o1));
				}
			}
			dataList.add(keyMap);
		}

		updatePoi(sheetHeaders, dataList);
	}

	public static void updatePoi(String[] sheetHeaders, List<Map<String, String>> dataList) {
		// 指定文件路径
		String filePath = "workbook.xlsx";

		try (Workbook workbook = getExistingWorkbook(filePath)) {
			// 判断是否已经存在表头
			if (workbook.getSheet("Sheet1") == null) {
				// 如果不存在表头，创建表头
				createHeader(workbook.createSheet("Sheet1"), sheetHeaders);
			}

			appendData(workbook.getSheet("Sheet1"), sheetHeaders, dataList);

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

	private static void createHeader(Sheet sheet, String[] headers) {
		// 写入表头
		Row headerRow = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(changeMap.getOrDefault(headers[i], headers[i]));
		}
	}

	private static void appendData(Sheet sheet, String[] sheetHeaders, List<Map<String, String>> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			Map<String, String> map = dataList.get(i);
			int lastRowNum = sheet.getLastRowNum() + 1;
			Row row = sheet.createRow(lastRowNum);
			for (int j = 0; j < sheetHeaders.length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(map.getOrDefault(changeMap.getOrDefault(sheetHeaders[j], sheetHeaders[j]), ""));
			}
		}
	}

}
