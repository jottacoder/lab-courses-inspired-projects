package br.joaopedrofreitas.desafioconsumirapi.services;

import br.joaopedrofreitas.desafioconsumirapi.exceptions.FalhaDeGeracaoDeArquivoException;
import br.joaopedrofreitas.desafioconsumirapi.models.EnderecoDto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorDeArquivos {

    ConversorDeJson conversorDeJson = new ConversorDeJson();

    public void salvarJsonNoArquivo(List<EnderecoDto> enderecos) {
        try {
            FileWriter writer = new FileWriter("enderecos.json");
            writer.write(conversorDeJson.paraJson(enderecos));
            System.out.println("Arquivo gerado com sucesso!");
            writer.close();
        } catch (IOException e) {
            throw new FalhaDeGeracaoDeArquivoException("Alerta: Não foi possível salvar o arquivo. Por favor tente novamente.");
        }
    }
}
