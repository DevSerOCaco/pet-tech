package br.com.devserocaco.pettech.pettech;

public class ControllerNotFoundException extends RuntimeException{

    public ControllerNotFoundException(String msg) {
        super(msg);
    }

}