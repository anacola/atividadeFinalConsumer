# FIAP - INTEGRATIONS & DEVELOPMENT TOOLS
## 1SCJR - Drone-Application
Prof: Rafael Thomazeli Mazzucato

-Desenvolvido por:
Murillo Lopes Fernandes
Eduardo Freire Cotrim
Ana Carolina Alves Cola
Marco Antonio da Paz Couzin


Solução para o agronegócio que coleta dados via sensores de temperatura e umidade. Esses sensores ficarão instalados em um drone com uma altíssima autonomia
de energia, pois conta com pequenos, porém muito eficientes painéis fotovoltaicos.


##  Pré-requisitos para execução do projeto

- Tecnologias necessárias.

  1- Para executar o projeto é necessário ter instalado Java SE Development Kit versão 17.

  2- Utilizar uma IDE para execução.

  3- Gradle

  4- Postman


## Executando o projeto


### 1 - Download do projeto no github:

```
Consumer
git clone https://github.com/anacola/atividadeFinalConsumer.git
```


### 2 - Subindo o "Consumer"

Importar o projeto (EX. IntelliJ)

1- No intelliJ, selecione **Open**.

2- Na janela, **Selecione o diretório**, e clicar **Open**.

3- Entre na pasta do projeto **Main** e **Resources** onde existe o **application.yml** .

4- Alterar e-mail no campo **username** e senha no campo **password**.

5- Criar uma instância de RabbitMQ do CloudAMQP, pode ser qualquer nome e em qualquer país, de preferência no Brasil, pela baixa latência.
Acessar as configurações da instância criada, ATENÇÃO, são as configurações da instância, não é o RabbitMQ Manager.

6- Criar fila com o nome **fiap.1scjr.drone**.

7- Copiar a URL configurada na instância, por exemplo: amqps://teste:jdq08u41u89cb@jackal.rmq.cloudamqp.com/teste .

8- Alterar no properties.yml com as informações retiradas do AMQp details o User & Vhost, Password, Ports e repetir a URL.

9- Entre no Package **br.com.fiap.scjr.atividadeFinalConsumer** e clique na classe Java **AtividadeFinalConsumerApplication** e clique em **Run**.

10- Baixar e instalar qualquer programa que faça chamadas Rest, uma opção é o Postman, link: https://www.postman.com/
Fazer uma request do tipo GET para a URI: http://localhost:9080/api/message .

---


### 3 - Prints

![console](https://github.com/anacola/atividadeFinalConsumer/blob/main/console.png)
![email](https://github.com/anacola/atividadeFinalConsumer/blob/main/email.png)

