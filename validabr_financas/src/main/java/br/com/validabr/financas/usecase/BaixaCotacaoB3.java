package br.com.validabr.financas.usecase;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class BaixaCotacaoB3 {

    @Value("${local.download.b3.serieHistorica.zip})")
    private String enderecoEntradaArquivoB3;

    @Value("${local.download.b3.serieHistorica.descompactado})")
    private String enderecoSaidaArquivoB3;

    @Value("${app.B3.url.host})")
    private String enderecoDownloadB3;

    @Scheduled(cron = "0 0 0/22 ? * MON,TUE,WED,THU,FRI *")
    public void baixaSerieHistoricaB3(){

        SimpleDateFormat formatodor = new SimpleDateFormat("ddMMyyyy");
        LocalDate dataAtual = LocalDate.now();
        String nameZip = "COTAHIST_D" + formatodor.format(dataAtual) + ".ZIP";
        String path = enderecoDownloadB3 + nameZip;

        try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(nameZip)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            unzipFile(path, formatodor.format(dataAtual));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void unzipFile(String arquivo, String data) throws IOException {

        String sourceFile = enderecoSaidaArquivoB3 + "COTAHIST_D" + data + ".csv";

        try(ZipFile file = new ZipFile(arquivo))
        {
            FileSystem fileSystem = FileSystems.getDefault();
            Enumeration<? extends ZipEntry> entries = file.entries();

            String uncompressedDirectory = enderecoSaidaArquivoB3;
            Files.createDirectory(fileSystem.getPath(uncompressedDirectory));

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

}
