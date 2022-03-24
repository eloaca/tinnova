package com.eloaca.tinnova.exception;

import java.text.MessageFormat;

public class MultiploException extends Exception{

    private static final long serialVersionUID = 5790199641211753806L;

    public MultiploException(String mensagem, Object ... args){
        super(MessageFormat.format(mensagem, args));
    }
}
