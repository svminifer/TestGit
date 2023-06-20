package io.stream.file;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


/**
 * 文件输入输出字符/字节流
 * <pre>
 *     示例一：读取一个文件(使用字符缓存流)
 *          1.增：追加内容[字节/字符]
 *          2.删：删除内容[字节/字符]
 *          3.改：获取x字符并替换成y字符[字节/字符]
 *          4.查: 输出内容到控制台/其他文件/(b/c服务器)[字节/字符]
 * </pre>
 */
public class FileTest {

	@Test
	public void fileRead1() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (FileInputStream fileInputStream = new FileInputStream(url.getPath() + "test.txt");) {
			byte[] buff = new byte[1024];
			int len;
			while ((len = fileInputStream.read(buff)) != -1) {
				System.out.println(new String(buff, 0, len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileWrite1() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		// idea下记得rebuild一下，不然target包没有文件
		try (FileInputStream fileInputStream = new FileInputStream(url.getPath() + "test.txt"); FileOutputStream fileOutputStream = new FileOutputStream(url.getPath() + "test1.txt");) {
			byte[] buff = new byte[1024];
			int len;
			while ((len = fileInputStream.read(buff)) != -1) {
				fileOutputStream.write(buff, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileRead2() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (FileInputStream fileInputStream = new FileInputStream(url.getPath() + "test.txt"); InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
				// 为了高效率，包装InputStreamReader
				BufferedReader reader = new BufferedReader(inputStreamReader)) {
			String s = reader.readLine();
			System.out.print(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileWrite2() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (FileInputStream fileInputStream = new FileInputStream(url.getPath() + "test.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
				// 为了高效率，包装InputStreamReader
				BufferedReader reader = new BufferedReader(inputStreamReader);

				FileOutputStream fileOutputStream = new FileOutputStream(url.getPath() + "test1.txt");
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
				BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);) {
			bufferedWriter.write(reader.readLine());
			// 网络传输记得flush，否则停留在缓存中
			//bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileRead3() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (
				FileReader fileReader = new FileReader(url.getPath() + "test.txt");
		) {
			char[] buff = new char[1024];
			int len;
			while ((len = fileReader.read(buff)) != -1) {
				System.out.println(new String(buff));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileWrite3() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (
				FileReader fileReader = new FileReader(url.getPath() + "test.txt");
				FileWriter fileWriter = new FileWriter(url.getPath() + "test1.txt");
		) {
			char[] buff = new char[1024];
			int len;
			// 字符流一个个读取字符会存在问题
			while ((len = fileReader.read(buff)) != -1) {
				fileWriter.write(buff);
				fileWriter.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fileRead4() {
		FileTest fileTest = new FileTest();
		URL url = fileTest.getClass().getResource("/");
		try (
				FileReader fileReader = new FileReader(url.getPath() + "test.txt");
				FileWriter fileWriter = new FileWriter(url.getPath() + "test1.txt");
		) {
			BufferedReader reader = new BufferedReader(fileReader);
			String s = reader.readLine();
			fileWriter.write(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
