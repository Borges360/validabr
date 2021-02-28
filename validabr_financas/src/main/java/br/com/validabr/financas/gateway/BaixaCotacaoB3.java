package br.com.validabr.financas.gateway;

import br.com.validabr.financas.repository.B3AcoesRepository;
import br.com.validabr.financas.usecase.ExtrairEGravarDadosB3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BaixaCotacaoB3 {

    @Value("${app.B3.url.host})")
    private String enderecoDownloadB3;

    @Value("${local.download.b3.serieHistorica.zip})")
    private String enderecoEntradaArquivoB3;

    ExtrairEGravarDadosB3 extrairEGravarDadosB3;

    B3AcoesRepository b3AcoesRepository;

    @Scheduled(cron = "0 0 0/22 ? * MON,TUE,WED,THU,FRI *")
    public File executaBaixaSerieHistoricaB3() throws IOException {

        LocalDate dataHoje = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String hojeFormatado = dataHoje.format(formatter);

        String fileName = "COTAHIST_D" + hojeFormatado + ".ZIP";
        String path = enderecoDownloadB3 + fileName;

        try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            extrairEGravarDadosB3.unzipFile(enderecoEntradaArquivoB3 + "\\" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extrairEGravarDadosB3.convertSerieHistoricaBolsaTxtParaCsv(hojeFormatado);
    }


}
