package br.com.validabr.financas.extracao;


import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


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

    @Test
    public static void baixaSerieHistoricaB3(ExtracaoDadosSerieHistorica extracaoDadosSerieHistorica){

        String path = "http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D29122020.ZIP";

        try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("COTAHIST_D29122020.ZIP")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            extracaoDadosSerieHistorica.unzipFile(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private File unzipFile(FileOutputStream arquivo) throws IOException {

        String sourceFile = "COTAHIST_D29122020.csv";

        ZipOutputStream zipOut = new ZipOutputStream(arquivo);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();

        return fileToZip;
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
