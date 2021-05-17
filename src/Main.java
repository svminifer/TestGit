import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello github!");

        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (Objects.equals("2", item)) {
                iterator.remove();
            }
        }
//          不能迭代删除
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//
//        }

        System.out.println(list);


        try {
            //建立一个File对象
            File file = new File(".\\test.json");
            //判断该文件的所属文件夹存不存在，不存在则创建文件夹
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //创建字符流（使用字节流比较麻烦）
            FileWriter fw = new FileWriter(file);
            //判断file是否存在
            if (!file.exists()) {
            //如果不存在file文件，则创建
                file.createNewFile();
                fw.write("[{\"name\":\"你好\"}]");
            } else {
            //如果存在该file，可以根据情况来重写该file文件的内容
                fw.write("[{\"name\":\"aa\"}]");
            }
            //这里要说明一下，write方法是写入缓存区，并没有写进file文件里面，要使用flush方法才写进去
            fw.flush();
            //关闭资源
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }





    }
    public static void testCampanyConnect(){
        System.out.println("test connect!");
    }
}
