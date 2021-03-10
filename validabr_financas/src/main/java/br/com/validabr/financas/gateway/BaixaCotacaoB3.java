package br.com.validabr.financas.gateway;

import br.com.validabr.financas.repository.B3AcoesRepository;
import br.com.validabr.financas.usecase.ExtrairEGravarDadosB3;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class BaixaCotacaoB3 {

    @Value("${app.B3.url.host}")
    private String enderecoDownloadB3;

    @Value("${local.download.b3.serieHistorica.zip}")
    private String enderecoEntradaArquivoB3;

    @Autowired
    ExtrairEGravarDadosB3 extrairEGravarDadosB3;

    B3AcoesRepository b3AcoesRepository;

    public void executaBaixaSerieHistoricaB3() throws IOException {

        LocalDate dataHoje = LocalDate.now();
        LocalDate tomorrow = dataHoje.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String hojeFormatado = yesterday.format(formatter);

        String fileName = "COTAHIST_D" + hojeFormatado + ".ZIP";
        String path = enderecoDownloadB3 + fileName;

        URL url = new URL(path);

        File fos = new File(enderecoEntradaArquivoB3 + "\\" + fileName);
        FileUtils.copyURLToFile(url, fos);
        extrairEGravarDadosB3.unzipFile(enderecoEntradaArquivoB3 + "\\" + fileName);

        extrairEGravarDadosB3.convertSerieHistoricaBolsaTxtParaCsv(hojeFormatado);
    }


}
