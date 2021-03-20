package api.utilTest;

import java.util.*;

/**
 * @Author kaboso
 * @Date 2021/3/19
 */

public class Main {
    public static void main(String[] args) {
        test8();
    }

    public static void test1() {
        System.out.println("请输入两个整数：");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();
            System.out.println(val1 + val2);
        }
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i = 0;
        while (i < num) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            i++;
        }
    }

    public static void test3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int val1 = sc.nextInt();
            int val2 = sc.nextInt();
            if (val1 == 0 && val2 == 0) break;
            System.out.println(val1 + val2);
        }

    }

    public static void test4() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) break;
            int count = 0;
            for (int i = 0; i < num; i++) {
                int add = sc.nextInt();
                count += add;
            }
            System.out.println(count);
        }

    }

    public static void test5() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int val = sc.nextInt();
            int count = 0;
            for (int j = 0; j < val; j++) {
                count += sc.nextInt();
            }
            System.out.println(count);
        }

    }

    public static void test6() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            for (int i = 0; i < num; i++) {
                count += sc.nextInt();
            }
            System.out.println(count);
        }

    }

    public static void test7() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = 0;
            String val = sc.nextLine();
            String[] strings = val.split(" ");
            for (int i = 0; i < strings.length; i++) {
                count += Integer.valueOf(strings[i]);
            }
            System.out.println(count);
        }
    }

    public static void test8() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = sc.next();
        }
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            if (i == (strs.length - 1)) {
                System.out.print(strs[i]);
                break;
            }
            System.out.print(strs[i] + " ");
        }

    }

    public static void test9() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(" ");
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i++) {
                if (i == (strs.length - 1)) {
                    System.out.print(strs[i]);
                    break;
                }
                System.out.print(strs[i] + " ");
            }
            System.out.println();
        }
    }

    public static void test10() {
        Scanner sc = new Scanner(System.in);

    }
}