package br.joaopedrofreitas.desafioconsumirapi.services;

import br.joaopedrofreitas.desafioconsumirapi.models.EnderecoDto;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.List;

public class ConversorDeJson {

    Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

    public EnderecoDto deJson(String json) throws JsonSyntaxException{
        return gson.fromJson(json, EnderecoDto.class);
    }

    public String paraJson(List<EnderecoDto> enderecoDto) {
        return gson.toJson(enderecoDto);
    }
}
