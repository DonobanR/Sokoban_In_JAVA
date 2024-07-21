package com.company;

import java.io.*;

public class Escenario {
    private int[][] matrizModeloDeEscenario;
    private final Bloque[][] matrízDeObjetos;
    private final String archivoDeNivel;


    public Escenario(String archivoDeNivel) {
        this.archivoDeNivel = archivoDeNivel;
        transformarArchivoMapaAMatriz();
        this.matrízDeObjetos = new Bloque[matrizModeloDeEscenario.length][matrizModeloDeEscenario[0].length];
        crearMatrizDeBloques();
    }


    public void transformarArchivoMapaAMatriz(){

        try {

            InputStream entrada = Escenario.class.getResourceAsStream(archivoDeNivel);
            assert entrada != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
            //Primera linea nos dice longitud de la matrizModeloDeEscenario
            String linea = br.readLine();
            int longitud = Integer.parseInt(linea);
            matrizModeloDeEscenario = new int[longitud][longitud];
            //Las siguientes lineas son filas de la matrizModeloDeEscenario
            linea = br.readLine();
            int fila = 0; //Para recorrer las filas de la matrizModeloDeEscenario
            while(linea != null) {
                String[] enteros = linea.split(" ");
                for (int i = 0; i < enteros.length; i++)
                    matrizModeloDeEscenario[fila][i] = Integer.parseInt(enteros[i]);
                fila++; //Incrementamos fila para la próxima línea de enteros
                linea = br.readLine(); //Leemos siguiente línea
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error accediendo al direccionDeEscenario.");
        }

    }

    public void crearMatrizDeBloques(){
        for(int i = 0; i < matrizModeloDeEscenario.length; i++){
            for(int j = 0; j < matrizModeloDeEscenario[0].length; j++){
                if(matrizModeloDeEscenario[i][j] == 1){
                    matrízDeObjetos[i][j] = new Pared();
                }
                if(matrizModeloDeEscenario[i][j] == 0){
                    matrízDeObjetos[i][j] = new Suelo();
                }
                if(matrizModeloDeEscenario[i][j] == 3){
                    matrízDeObjetos[i][j] = new PuntoDeLlegada();
                }
                if(matrizModeloDeEscenario[i][j] == 2){
                    matrízDeObjetos[i][j] = new Caja();
                }
                if(matrizModeloDeEscenario[i][j] == 4){
                    matrízDeObjetos[i][j] = new Arbusto();
                }
            }
        }
    }
    public int totalPuntoDeLlegada(){
        int contador = 0;
        for (int i = 0; i < matrizModeloDeEscenario.length; i++){
            for(int j = 0; j < matrizModeloDeEscenario[i].length; j++){
                if(matrizModeloDeEscenario[i][j] == 3)
                    contador++;
            }
        }
        return contador;
    }

    public int puntosDeLlegadaFinalizados(){
        int contador = 0;
        for (Bloque[] fila : matrízDeObjetos) {
            for (Bloque bloque : fila) {
                if (bloque instanceof Caja) {
                    if (((Caja) bloque).getLlegoAlPuntoDeLlegada()) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }


    public boolean acabarJuego(){
        int totalPuntosLlegada = totalPuntoDeLlegada();
        int cajasEnPuntosLlegada = 0;

        for (Bloque[] fila : matrízDeObjetos) {
            for (Bloque bloque : fila) {
                if (bloque instanceof Caja && ((Caja) bloque).getLlegoAlPuntoDeLlegada()) {
                    cajasEnPuntosLlegada++;
                }
            }
        }
        System.out.println("Total puntos de llegada: " + totalPuntosLlegada);
        System.out.println("Cajas en puntos de llegada: " + cajasEnPuntosLlegada);
        return cajasEnPuntosLlegada == totalPuntosLlegada;
    }



    public Bloque[][] getMatrízDeObjetos() {
        return matrízDeObjetos;
    }

    public int[][] getMatrizModeloDeEscenario() {
        return matrizModeloDeEscenario;
    }
}
