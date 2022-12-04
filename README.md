# FIAP - INTEGRATIONS & DEVELOPMENT TOOLS
## 1SCJR - Drone-Application
Prof: Rafael Thomazeli Mazzucato


Solução para o agronegócio que coleta dados via sensores de temperatura e umidade. Esses sensores ficarão instalados em um drone com uma altíssima autonomia
de energia, pois conta com pequenos, porém muito eficientes painéis fotovoltaicos.


##  Pré-requisitos para execução do projeto

- Tecnologias necessárias.

  1- Para executar o projeto é necessário ter instalado Java SE Development Kit versão 11.

  2- Utilizar uma IDE para execução.

  3- Gradle


## Executando o projeto


### 1 - Download do projeto no github:

```
Producer
gh repo clone murilLost/atividadeFinalProducer
```

```
Consumer
git clone https://github.com/anacola/atividadeFinalConsumer.git
```

```
API
git clone https://github.com/anacola/atividadeFinalConsumer.git
```

### 2 - Subindo o "Producer"

Importar o projeto (EX. IntelliJ)

  1- No intelliJ, selecione **Open**.

  2- Na janela, **Selecione o diretório**, e clicar **Open**.

  3- Entre na pasta do projeto **Main** e **Resources** onde existe o **application.yml** .

  4- Entre no Package **br.com.fiap.scjr.atividadeFinalProducer** e clique na classe Java **AtividadeFinalProducerApplication** e clique em **Run**.

---

### 3 - Subindo o "Consumer"

Importar o projeto (EX. IntelliJ)

1- No intelliJ, selecione **Open**.

2- Na janela, **Selecione o diretório**, e clicar **Open**.

3- Entre na pasta do projeto **Main** e **Resources** onde existe o **application.yml** .

4- Alterar e-mail no campo **username** e senha no campo **password**

5- Alterar o e-mail para quem será enviado no campo **message.setTo** e o remetente no campo **message.setFrom**,no 
package **br.com.fiap.scjr.atividadeFinalConsumer.consumer** classe **QueueConsumer**

6- Entre no Package **br.com.fiap.scjr.atividadeFinalConsumer** e clique na classe Java **AtividadeFinalConsumerApplication** e clique em **Run**.

---

### 4 - Instalação e execução da API







