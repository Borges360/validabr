package br.com.validabr.validabr_application.taskManager;

import br.com.validabr.financas.gateway.BaixaCotacaoB3;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@EnableScheduling
public class IniciaTasks {

    BaixaCotacaoB3 baixaCotacaoB3;

    @Scheduled(cron = "0 39 20 ? * MON,TUE,WED,THU,FRI *")
    void executaTaskB3() throws IOException {
        baixaCotacaoB3.executaBaixaSerieHistoricaB3();
    }

}
