package com.winterice.vote.exception;

/**
 * @author 17918
 */
public class UnloginException extends Exception{
    public UnloginException(String message) {
        super(message);
    }

    public UnloginException() {
        super();
    }
}
