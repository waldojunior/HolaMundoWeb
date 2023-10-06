/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejercicio13_5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author wadit
 */
public class Ejercicio13_5 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        // Crear un objeto serializable
        Persona persona = new Persona("Juan", 30);

        // Serializar el objeto y guardarlo en un archivo
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("persona.ser"))) {
            salida.writeObject(persona);
            System.out.println("Objeto serializado y guardado.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el objeto desde el archivo
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("persona.ser"))) {
            Persona personaDeserializada = (Persona) entrada.readObject();
            System.out.println("Objeto deserializado: " + personaDeserializada.getNombre() + ", " + personaDeserializada.getEdad());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
