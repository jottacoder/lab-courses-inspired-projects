package br.joaopedrofreitas.desafioconsumirapi.app;

import br.joaopedrofreitas.desafioconsumirapi.exceptions.ArgumentoInvalidoException;
import br.joaopedrofreitas.desafioconsumirapi.exceptions.FalhaDeComunicacaoException;
import br.joaopedrofreitas.desafioconsumirapi.exceptions.FalhaDeGeracaoDeArquivoException;
import br.joaopedrofreitas.desafioconsumirapi.models.*;
import br.joaopedrofreitas.desafioconsumirapi.models.EnderecoDto;
import br.joaopedrofreitas.desafioconsumirapi.services.ConsultadorDeCep;
import br.joaopedrofreitas.desafioconsumirapi.services.GeradorDeArquivos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsultadorDeCep consultadorDeCep = new ConsultadorDeCep();
        List<EnderecoDto> enderecos = new ArrayList<>();

        String telaInicial = """
                **********************************

                Programa iniciado.

                Obs: Se desejar encerrar o programa, basta digitar 'sair'.

                """;

        System.out.print(telaInicial);

        try {
            while(true) {

                System.out.print("Insira o cep que deseja buscar: ");
                var cep = scanner.nextLine().trim();

                if (cep.equalsIgnoreCase("sair")) {
                    break;
                }

                EnderecoDto novoEndereco = consultadorDeCep.buscarEndereco(cep);
                System.out.println("Endereço encontrado com sucesso");
                System.out.println();
                enderecos.add(novoEndereco);

        }
            if(!enderecos.isEmpty()){
                GeradorDeArquivos geradorDeArquivos = new GeradorDeArquivos();
                geradorDeArquivos.salvarJsonNoArquivo(enderecos);
            }

        }catch (FalhaDeComunicacaoException e) {
            System.out.println(e.getMessage());
        }catch (ArgumentoInvalidoException e ){
            System.out.println(e.getMessage());
        }catch (FalhaDeGeracaoDeArquivoException e){
            System.out.println(e.getMessage());
        }

        String telaFinal = """

                Programa finalizado.

                **********************************
                """;

        System.out.print(telaFinal);

        scanner.close();
    }
}