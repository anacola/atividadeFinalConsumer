package br.com.fiap.scjr.atividadeFinalConsumer.consumer;

import br.com.fiap.scjr.atividadeFinalConsumer.model.DroneModel;
import br.com.fiap.scjr.atividadeFinalConsumer.validation.DroneValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class QueueConsumer {

    @Autowired
    private JavaMailSender mailSender; //Para pegar as configuracoes no application.yml
    private static final Logger log = LoggerFactory.getLogger(QueueConsumer.class);
    private DroneValidation droneValidator = new DroneValidation();//Cria uma instancia para da classe de validacao
    private Gson gson = new Gson();//Cria uma instancia do GSON para converter as mensagens para objetos java

    @RabbitListener(queues = {"${queue.fiap}"})
    public void receiveMessage(@Payload String fileBody) {
        try {
            DroneModel drone = gson.fromJson(fileBody, DroneModel.class);//Converte a mensagen de Json para objeto java
                if (!droneValidator.validar(drone)) {//Valida se ha alguma temperatura ou umidade inconsistente, se estiver inconsistente, envia email
                    log.info(sendMailDrone(drone));
                }

            Thread.sleep(60000);//Trava a thread por 1min, para depois disso executar ela novamente. Tentei usar o Scheduler do Springboot, mas nao consegui :'(
        } catch (InterruptedException e) {
            log.info("Problemas na thread: " + e.getMessage());
        }
    }

    public String sendMailDrone(DroneModel drone) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Drone " + drone.getIdDrone() + " detectou problemas");
        message.setText("Olá, \n" +
                "Seu drone com o número de identificação: " +drone.getIdDrone() + ", obteve dados anormais:\n" +
                "Temperatura: " + drone.getTemperatura() + ", Umidade: " + drone.getUmidade() + ", Latitude: " + drone.getLatitude()
                + ", Longitude: " + drone.getLongitude());
        message.setTo("inserirseuemail@hotmail.com");
        message.setFrom("Drone Information  <inserirseuemail@hotmail.com>");
        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}

