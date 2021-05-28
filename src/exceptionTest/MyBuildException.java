package exceptionTest;

/**
 * 编译期异常
 */
public class MyBuildException extends Exception {

    public MyBuildException() {
    }

    public MyBuildException(String message) {
        super(message);
    }
}
