package br.com.fiap.scjr.atividadeFinalConsumer.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfiguration {

    @Value("${queue.fiap.userVhost}")
    private String userVhost;

    @Value("${queue.fiap.password}")
    private String password;

    @Value("${queue.fiap.port}")
    private int port;

    @Value("${queue.fiap.url}")
    private String url;

    @Value("${queue.fiap.nome}")
    private String name;

    @Bean
    public Queue queue(){
        return new Queue(name, true);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory consumerBatchContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory());//Obtem a comfiguracao para se conectar ao RabbitAQMP na cloud, pega as configuracoes setadas no metodo rabbitConnectionFactory abaixo
        factory.setConsumerBatchEnabled(true);////Obrigatorio para ativar o processamento Batch
        factory.setBatchSize(100);//Tamanho maximo de mensagens que serao trazidas por lote
        factory.setBatchListener(true);//Obrigatorio para ativar o processamento Batch no listener
        return factory;
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        //As configuracoes abaixo foram obtidas no CloudAMQP Overview da instancia
        connectionFactory.setUri(url);//URL
        connectionFactory.setUsername(userVhost);//User & Vhost
        connectionFactory.setPassword(password); //Password
        connectionFactory.setVirtualHost(userVhost); //User & Vhost
        connectionFactory.setPort(port);//Ports - for TLS
        return connectionFactory;
    }

}
