package exceptionTest;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

        String[] str = {"张三", "王五", "李四"};
        find_Exception(str);
    }

    private static void find_Exception(String[] str) {
        Scanner sc = new Scanner(System.in);
        for (String s : str) {
            try {
                checkUsername(s, str);
                //没有异常，注册成功
                System.out.println("注册成功");
            } catch (MyBuildException e) {
                //处理异常
                e.printStackTrace();
            }
        }
    }

    //判断当前账户是否被注册
    //编译器异常，声明后抛出
    private static boolean checkUsername(String s, String[] str) throws MyBuildException {
        for (String s1 : str) {
            if (s1.equals(s)) {
                throw new MyBuildException("对不起，亲，这个号已经被注册了");
            }
        }
        return true;
    }

}

