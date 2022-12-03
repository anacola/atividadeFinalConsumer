package br.com.fiap.scjr.atividadeFinalConsumer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneModel {

    private Integer idDrone;
    private Integer latitude;
    private Integer longitude;
    private Integer temperatura;
    private Integer umidade;
    private Boolean rastreamento;
}
