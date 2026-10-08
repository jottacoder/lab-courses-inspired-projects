package br.joaopedrofreitas.desafioconsumirapi.models;

public record EnderecoDto(String cep, String logradouro, String complemento, String unidade,
                          String bairro, String localidade, String uf, String estado,
                          String regiao) {
}
