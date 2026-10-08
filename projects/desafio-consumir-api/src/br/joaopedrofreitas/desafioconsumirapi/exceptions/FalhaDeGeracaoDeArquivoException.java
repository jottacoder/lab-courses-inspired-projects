package br.joaopedrofreitas.desafioconsumirapi.exceptions;

public class FalhaDeGeracaoDeArquivoException extends RuntimeException {

    public FalhaDeGeracaoDeArquivoException(String mensagem) {
        super(mensagem);
    }
}
