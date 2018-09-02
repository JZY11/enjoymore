package com.ipubu.boot.skills.base.exception;

/**
 * @ClassName SmartHomeException
 * @Description
 * @Author jzy
 */
public class SmartHomeException extends Exception {

    private static final long serialVersionUID = -7075485169693311393L;

    // 无参构造方法
    public SmartHomeException() {
        super();
    }

    // 有参的构造方法
    public SmartHomeException(String message) {
        super(message);
    }

    // 用指定的详细信息和原因构造一个新的异常
    public SmartHomeException(String message, Throwable cause) {
        super(message, cause);
    }

    // 用指定原因构造一个新的异常
    public SmartHomeException(Throwable cause) {
        super(cause);
    }

}
