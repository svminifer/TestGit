package exceptionTest;

/**
 * 运行期异常
 */
public class MyRunningException extends RuntimeException {
    public MyRunningException() {
    }

    public MyRunningException(String message) {
        super(message);
    }
}
