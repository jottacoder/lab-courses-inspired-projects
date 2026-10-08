package br.joaopedrofreitas.desafioconsumirapi.exceptions;

public class FalhaDeComunicacaoException extends RuntimeException {

    public FalhaDeComunicacaoException(String mensagem) {
        super(mensagem);
    }
}
