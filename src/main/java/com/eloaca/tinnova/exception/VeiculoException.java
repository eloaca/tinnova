package com.eloaca.tinnova.exception;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class VeiculoException extends Exception{

    private static final long serialVersionUID = 6940537377041626731L;

    public VeiculoException(String mensagem, Object ... args) {
        super(MessageFormat.format(mensagem, args));
    }
}
