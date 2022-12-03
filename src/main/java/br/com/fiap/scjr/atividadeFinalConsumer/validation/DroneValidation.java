package br.com.fiap.scjr.atividadeFinalConsumer.validation;


import br.com.fiap.scjr.atividadeFinalConsumer.model.DroneModel;

public class DroneValidation {

    private static int temperaturaMin = 0;
    private static int temperaturaMax = 35;
    private static int umidadeMin = 15;


    public static boolean validar(DroneModel drone) {
        if ((drone.getTemperatura() >= temperaturaMax || drone.getTemperatura() <= temperaturaMin) ||
                (drone.getUmidade() <= umidadeMin)) {
            return false;
        }
        return true;
    }
}
