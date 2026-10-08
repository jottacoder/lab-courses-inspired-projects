package br.joaopedrofreitas.desafioconsumirapi.services;

import br.joaopedrofreitas.desafioconsumirapi.exceptions.ArgumentoInvalidoException;
import br.joaopedrofreitas.desafioconsumirapi.exceptions.FalhaDeComunicacaoException;
import br.joaopedrofreitas.desafioconsumirapi.models.EnderecoDto;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultadorDeCep {

    ConversorDeJson conversorDeJson = new ConversorDeJson();

    public EnderecoDto buscarEndereco(String cep) {
        if(cep == null || cep.trim().isBlank()){
            throw new ArgumentoInvalidoException("Alerta: Não pode haver busca com o cep vazio. Por favor insira um cep válido.");
        }
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //if(response.statusCode() != 200){
              //  throw new FalhaDeComunicacaoException("Alerta: Falha de comunicação com servidor. Por favor verifique sua conexão ou tente novamente.");
            //}
            return conversorDeJson.deJson(response.body());

        } catch (IOException | InterruptedException e) {
            throw new FalhaDeComunicacaoException("Alerta: Falha de comunicação com servidor. Por favor verifique sua conexão ou tente novamente.");
        } catch (IllegalArgumentException | JsonSyntaxException e) {
            throw new ArgumentoInvalidoException("Alerta: Não foi possível encontrar um endereço a partir desse cep. Por favor insira um cep válido.");
        }
    }
}
