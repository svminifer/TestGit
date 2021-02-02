package Utils;

/**
 * @author kaboso
 * @date 2021/2/2 18:20
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    //匹配文件路径的文件名
    private final static String  fileName="([^/]*)(\\.\\w+)$";

    /**
     * 匹配文件路径的文件名
     *
     * @describe 返回的matcher需要使用find函数进行判断是否有匹配结果，有则group函数的值为文件名和拓展名，无则为null
     * @Examples
     *              String str ="http://www.baidu.com/upload/2021/02/02/file.txt";
     *              String regEx = "([^/]*)(\\.\\w+)$";
     *              Pattern p = Pattern.compile(regEx);
     *              Matcher m = p.matcher(str);
     *              if(m.find()) {
     *                  System.out.println(m.group(1)); // 文件名 输出结果为：file
     *                  System.out.println(m.group(2)); // 文件扩展名 输出结果为：.txt
     *              }
     * @param filePath 文件路径
     * @return 匹配结果
     */
    public static Matcher fileName(String filePath){
        Pattern p = Pattern.compile(fileName);
        return p.matcher(filePath);
    }
}

