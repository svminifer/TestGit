package exceptionTest;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.Test1();
        //编译期异常，一定要捕获，否则无法通过编译
        try {
            main.Test2();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public  void Test1() throws NullPointerException{
        throw new NullPointerException();
    }
    public  void Test2() throws IOException {
        throw new IOException();
    }
}
