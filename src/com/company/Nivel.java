package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador único de la versión de la clase
    private Personaje personaje;
    private Escenario escenario;
    private int numeroDeNivel;
    private String direccionDeNivel;

    public Nivel(int numeroDeNivel) {
        this.personaje = new Personaje();
        this.numeroDeNivel = numeroDeNivel;
        this.direccionDeNivel = buscarArchivoDeNivel(numeroDeNivel);
        this.escenario = new Escenario(direccionDeNivel);
    }

    private String buscarArchivoDeNivel(int numeroDeNivel) {
        // Implementación para buscar la dirección del archivo de nivel
        // Debes proporcionar la lógica para obtener la dirección según el número de nivel
        // Este método es solo un esquema básico, debes adaptarlo a tu aplicación
        // Por ejemplo:

        return "/Niveles/nivel" + (numeroDeNivel + 1) + ".txt";
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public int getNumeroDeNivel() {
        return numeroDeNivel;
    }

    public void guardarMatrizEnArchivo(String nombreArchivo, Escenario escenario) {
        Bloque[][] matrízDeObjetos = new Bloque[escenario.getMatrizModeloDeEscenario().length][escenario.getMatrizModeloDeEscenario()[0].length];

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));

            // Escribir la longitud de la matriz en la primera línea
            writer.write(Integer.toString(escenario.getMatrizModeloDeEscenario().length));
            writer.newLine();

            // Escribir las filas de la matriz
            for (int i = 0; i < escenario.getMatrizModeloDeEscenario().length; i++) {
                for (int j = 0; j < escenario.getMatrizModeloDeEscenario()[0].length; j++) {
                    writer.write(Integer.toString(escenario.getMatrizModeloDeEscenario()[i][j]));
                    writer.write(" "); // Espacio entre los enteros

                    if (escenario.getMatrizModeloDeEscenario()[i][j] == 1) {
                        matrízDeObjetos[i][j] = new Pared();
                    } else if (escenario.getMatrizModeloDeEscenario()[i][j] == 0) {
                        matrízDeObjetos[i][j] = new Suelo();
                    } else if (escenario.getMatrizModeloDeEscenario()[i][j] == 3) {
                        matrízDeObjetos[i][j] = new PuntoDeLlegada();
                    } else if (escenario.getMatrizModeloDeEscenario()[i][j] == 2) {
                        matrízDeObjetos[i][j] = new Caja();
                    } else if (escenario.getMatrizModeloDeEscenario()[i][j] == 4) {
                        matrízDeObjetos[i][j] = new Arbusto();
                    }
                }
                writer.newLine(); // Nueva línea después de cada fila
                }

            writer.close();
            System.out.println("Matriz guardada en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la matriz en el archivo.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public void setNumeroDeNivel(int numeroDeNivel) {
        this.numeroDeNivel = numeroDeNivel;
        // Después de cambiar el número de nivel, actualizamos la dirección del nivel
        this.direccionDeNivel = buscarArchivoDeNivel(numeroDeNivel);
        // También podrías querer cargar el nuevo escenario basado en la nueva dirección aquí
        // this.escenario = new Escenario(direccionDeNivel);
    }
}