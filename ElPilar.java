/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos - sección 40
 * Roberto Barreda - 23354
 */

import java.io.File;
import java.io.FileNotFoundException;
//import java.util.PriorityQueue;
import java.util.Scanner;

public class ElPilar {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencia = new ArbolBi<>();

        //Cargar pacientes desde el archivo
        cargarPacientes(colaEmergencia);

        //Uno por uno
        while (!colaEmergencia.isEmpty()) {
            Paciente paciente = colaEmergencia.remove();
            System.out.println("Atendiendo a: " + paciente);
        }
    }

    private static void cargarPacientes(PriorityQueue<Paciente> colaEmergencia) {
        try {
            File archivo = new File("pacientes.txt");
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char codigoEmergencia = partes[2].trim().charAt(0);
                    colaEmergencia.add(new Paciente(nombre, sintoma, codigoEmergencia));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se pudo encontrar el archivo 'pacientes.txt'");
            e.printStackTrace();
        }
    }
}
