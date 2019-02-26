package org.iesalandalus.programacion.ficheros.secuencial.bytes.objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribeObjetosProblema1 {
	public static void main(String[] args) {
		Persona persona = new Persona("lo que sea", 1);
		File fichero = new File("ficheros/personas.dat");
		String[] nombres = { "Juan", "Alfonso", "Araceli", "Manolo", "Rubén", "Elvira", "Inés", "José Ramón" };
		int[] edades = { 31, 35, 25, 40, 37, 18, 20, 22 };
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
			for (int i = 0; i < edades.length; i++) {
				persona.setNombre(nombres[i]);
				persona.setEdad(edades[i]);
				//Como hemos modificado los atributos y no creado una nueva instancia, debemos hacer reset
				//para que se entere de los cambios. Por tanto, siempre es mejor hacer el new y olvidarnos del reset.
				salida.reset();
				salida.writeObject(persona);
			}
			salida.close();
			System.out.println("Fichero escrito satisfactoriamente");
		} catch (FileNotFoundException e) {
			System.out.println("No puedo crear el fichero de salida");
		} catch (IOException e) {
			System.out.println("Error inesperado de Entrada/Salida");
		}
	}
}
