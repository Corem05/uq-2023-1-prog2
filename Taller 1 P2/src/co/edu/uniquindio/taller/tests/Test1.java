package co.edu.uniquindio.taller.tests;

import java.util.ArrayList;

import co.edu.uniquindio.taller.ejercicio1.model.*;

public class Test1 {

	public static void main(String[] args) {

		Empresa empresa = new Empresa("Uq empresa");

		Persona persona = new Empleado("Juan", 23, 23445);

		Cliente cliente = new Cliente("Luz", 23, "345678");

		ArrayList<Empleado> listaSubordinados = new ArrayList<Empleado>();

		listaSubordinados.add((Empleado) persona);

		empresa.getListaPersonas().add(persona);
		empresa.getListaPersonas().add(cliente);

		Directivo directivo = new Directivo("Carlos", 19, 5000000, Categoria.GERENTE, listaSubordinados);

		empresa.getListaPersonas().add(directivo);
		System.out.println(empresa.getListaPersonas());
		System.out.println(empresa.getSalarioEmpleados());
		System.out.println(empresa.getSalarioEmpleados2());

		// hacer un metodo que imprima el salriobruot de los empleado debe manipular la
		// lista personas de la empresa

	}

}
