package br.com.devserocaco.pettech.pettech.controller.exception;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String msg) {
        super(msg);
    }

}