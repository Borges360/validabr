package br.com.validabr.financas.extracao;

import br.com.validabr.validabr_application.ValidabrApplication;
import com.google.common.base.Splitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ExtracaoDadosSerieHistorica {

    @Test
    public void extracaoSerieHistoricaBolsa() throws IOException {

        Scanner scanner = new Scanner(new File("C:\\desenvolvimento\\ValidaBr\\DadosB3\\COTAHIST_A2020.TXT"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\desenvolvimento\\ValidaBr\\DadosB3\\COTAHIST_A2020.csv")));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String linhaSeparada = separadorDeDados(line);
            bw.write(linhaSeparada);
            bw.newLine();

        }

        bw.close();

    }

    private String separadorDeDados(String linha){

        int posicoes[] = { 2, 10, 12, 24, 27, 39, 49, 52, 56, 69, 82, 95, 108, 121, 134, 147, 152, 170, 188, 201, 202, 210, 217, 230, 242, 245 };
        int inicio = 0;

        List<String> linhaArrayNovo = new ArrayList<>();

        for (int pos : posicoes) {
            if (linha != null) {
                try {
                    linhaArrayNovo.add(linha.substring(inicio, pos));
                    inicio = pos;
                } catch (Exception e) {
                    System.out.println(linha);
                }
            } continue;
        }

        String joinedString = String.join(";", linhaArrayNovo);

        joinedString = limpaDados(joinedString);

        return joinedString;

    }

    public String limpaDados(String linhaTrada){

        for (int i = 0; i<=5; i++) {
            linhaTrada = linhaTrada.replaceAll("\\s+"," ");
            linhaTrada = linhaTrada.replaceAll("; ;", ";;");
        }

        linhaTrada = linhaTrada.replaceAll(" ;", ";");

        return linhaTrada;
    }
}
