package br.joaopedrofreitas.desafioconsumirapi.exceptions;

public class ArgumentoInvalidoException extends RuntimeException{

    public ArgumentoInvalidoException(String mensagem){
        super(mensagem);
    }
}
