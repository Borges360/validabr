package br.com.validabr.financas.usecase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
import java.util.zip.ZipInputStream;

@Service
public class ExtrairEGravarDadosB3 {

    @Value("${app.B3.url.host})")
    private String enderecoDownloadB3;

    @Value("${local.download.b3.serieHistorica.zip}")
    private String enderecoEntradaArquivoB3;

    @Value("${local.download.b3.serieHistorica.descompactado}")
    private String enderecoSaidaArquivoB3;

    @Value("${local.download.b3.serieHistorica.descompactado.csv}")
    private String enderecoSaidaArquivoB3Csv;

    public void convertSerieHistoricaBolsaTxtParaCsv(String dataOntem) throws IOException {

        Scanner scanner = new Scanner(new File(enderecoSaidaArquivoB3 + "\\COTAHIST_D" + dataOntem + ".TXT"));
        File arquivoCsvHoje = new File(enderecoSaidaArquivoB3Csv);
        if (!arquivoCsvHoje.exists()){
            arquivoCsvHoje.mkdirs();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(enderecoSaidaArquivoB3Csv + "\\COTAHIST_D" + dataOntem + ".csv"));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String linhaSeparada = separadorDeDados(line);
            bw.write(linhaSeparada);
            bw.newLine();

        }
        bw.close();

    }

    public void unzipFile(String arquivo) throws IOException {
        try {
            String fileZip = arquivo;
            File destDir = new File(enderecoSaidaArquivoB3);
            if (!destDir.exists()){
                destDir.mkdirs();
            }
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = newFile(destDir, zipEntry);
                if (zipEntry.isDirectory()) {
                    if (!newFile.isDirectory() && !newFile.mkdirs()) {
                        throw new IOException("Failed to create directory " + newFile);
                    }
                } else {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }

                    // write file content
                    FileOutputStream fos = new FileOutputStream(newFile);
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
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
