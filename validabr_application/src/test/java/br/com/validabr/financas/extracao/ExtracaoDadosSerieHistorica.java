package br.com.validabr.financas.extracao;


import org.junit.Test;

import java.io.*;
import java.net.URL;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ExtracaoDadosSerieHistorica {

    @Test
    public void extracaoSerieHistoricaBolsa() throws IOException {

        Scanner scanner = new Scanner(new File("C:\\desenvolvimento\\ValidaBr\\DadosB3\\COTAHIST_A2020.TXT"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\desenvolvimento\\ValidaBr\\DadosB3\\COTAHIST_A2020.csv"));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String linhaSeparada = separadorDeDados(line);
            bw.write(linhaSeparada);
            bw.newLine();

        }

        bw.close();

    }

    @Test
    public void baixaSerieHistoricaB3(){

        String path = "http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D29122020.ZIP";

        try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("COTAHIST_D29122020.ZIP")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            unzipFile("C:\\Desenvolvimento\\validabr\\validabr_application\\COTAHIST_D29122020.ZIP");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void unzipFile(String arquivo) throws IOException {

        String sourceFile = "C:\\Desenvolvimento\\validabr\\validabr_application\\COTAHIST_D29122020.csv";

        try(ZipFile file = new ZipFile(arquivo))
        {
            FileSystem fileSystem = FileSystems.getDefault();
            //Get file entries
            Enumeration<? extends ZipEntry> entries = file.entries();

            //We will unzip files in this folder
            String uncompressedDirectory = "descompactados/";
            Files.createDirectory(fileSystem.getPath(uncompressedDirectory));

            //Iterate over entries
            while (entries.hasMoreElements())
            {
                ZipEntry entry = entries.nextElement();
                //If directory then create a new directory in uncompressed folder
                if (entry.isDirectory())
                {
                    System.out.println("Creating Directory:" + uncompressedDirectory + entry.getName());
                    Files.createDirectories(fileSystem.getPath(uncompressedDirectory + entry.getName()));
                }
                //Else create the file
                else
                {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = uncompressedDirectory + entry.getName();
                    Path uncompressedFilePath = fileSystem.getPath(uncompressedFileName);
                    Files.createFile(uncompressedFilePath);
                    FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName);
                    while (bis.available() > 0)
                    {
                        fileOutput.write(bis.read());
                    }
                    fileOutput.close();
                    System.out.println("Written :" + entry.getName());
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private String separadorDeDados(String linha){

        int[] posicoes = { 2, 10, 12, 24, 27, 39, 49, 52, 56, 69, 82, 95, 108, 121, 134, 147, 152, 170, 188, 201, 202, 210, 217, 230, 242, 245 };
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
            }
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
