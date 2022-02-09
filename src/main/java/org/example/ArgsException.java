package org.example;

public class ArgsException extends Exception {
    String errorMessage;

    ArgsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
