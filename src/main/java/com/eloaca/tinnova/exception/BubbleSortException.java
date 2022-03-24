package com.eloaca.tinnova.exception;

import java.text.MessageFormat;

public class BubbleSortException extends Exception {

    private static final long serialVersionUID = 5672274553939475215L;

    public BubbleSortException(final String mensagem, Object ... args){
        super(MessageFormat.format(mensagem, args));
    }
}
