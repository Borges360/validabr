package br.com.validabr.financas.usecase;

import org.springframework.beans.factory.annotation.Value;

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

public class ExtrairEGravarDadosB3 {

    @Value("${app.B3.url.host})")
    private String enderecoDownloadB3;

    @Value("${local.download.b3.serieHistorica.zip})")
    private String enderecoEntradaArquivoB3;

    @Value("${local.download.b3.serieHistorica.descompactado})")
    private String enderecoSaidaArquivoB3;

    @Value("${local.download.b3.serieHistorica.descompactado.csv})")
    private String enderecoSaidaArquivoB3Csv;



    public File baixaSerieHistoricaB3(String dataHoje) throws IOException {

        String fileName = "COTAHIST_D" + dataHoje + ".ZIP";
        String path = enderecoDownloadB3 + fileName;

        try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            unzipFile(enderecoEntradaArquivoB3 + "\\" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convertSerieHistoricaBolsaTxtParaCsv(dataHoje);

    }

    public File convertSerieHistoricaBolsaTxtParaCsv(String dataHoje) throws IOException {

        Scanner scanner = new Scanner(new File(enderecoSaidaArquivoB3 + "\\COTAHIST_D" + dataHoje + ".TXT"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(enderecoSaidaArquivoB3Csv + "\\COTAHIST_D" + dataHoje + ".csv"));
        File arquivoCsvHoje = new File(enderecoSaidaArquivoB3Csv + "\\COTAHIST_D" + dataHoje + ".csv");

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String linhaSeparada = separadorDeDados(line);
            bw.write(linhaSeparada);
            bw.newLine();

        }
        bw.close();
        return arquivoCsvHoje;
    }

    public void unzipFile(String arquivo) throws IOException {

        try(ZipFile file = new ZipFile(arquivo))
        {
            FileSystem fileSystem = FileSystems.getDefault();
            //Get file entries
            Enumeration<? extends ZipEntry> entries = file.entries();

            //We will unzip files in this folder
            Files.createDirectory(fileSystem.getPath(enderecoSaidaArquivoB3));

            //Iterate over entries
            while (entries.hasMoreElements())
            {
                ZipEntry entry = entries.nextElement();
                //If directory then create a new directory in uncompressed folder
                if (entry.isDirectory())
                {
                    System.out.println("Creating Directory:" + enderecoSaidaArquivoB3 + entry.getName());
                    Files.createDirectories(fileSystem.getPath(enderecoSaidaArquivoB3 + entry.getName()));
                }
                //Else create the file
                else
                {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = enderecoSaidaArquivoB3 + entry.getName();
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
