package controller;

import java.util.Scanner;

import model.data_structures.ListaSencillamenteEncadenada;
import model.data_structures.Nodo;
import model.logic.MVCModelo;
import model.logic.TravelTime;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;


	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				System.out.println("--------- \nSe cargaran los datos: ");
				modelo = new MVCModelo(); 
				modelo.cargarDatos();
				System.out.println("Datos cargados");
				System.out.println("Numero de viajes cargados: " + modelo.darNumViajes() );
				TravelTime primero = modelo.darPrimerViaje(); 
				TravelTime ultimo = modelo.darUltimoViaje();
				System.out.println("Datos primer viaje: " + primero.darIDOrigen() + ", " + primero.darIdDestino() + ", " + primero.darHoraOMesODia() + ", " + primero.darTiempoViaje());
				System.out.println("Datos primer viaje: " + ultimo.darIDOrigen() + ", " + ultimo.darIdDestino() + ", " + ultimo.darHoraOMesODia() + ", " + ultimo.darTiempoViaje());
				break;

			case 2:
				System.out.println("--------- \nSe realizara una prueba con 200000 datos");
				dato = lector.next();
				
				break;

			case 3:
				System.out.println("--------- \nIngrese la cantidad de tiempos que desea consultar");
				dato = lector.next();
				try
				{
					int n = Integer.parseInt(dato);
					ListaSencillamenteEncadenada<TravelTime> muestra = modelo.generarMuestra(n);
					double tiempo = 0;
					long tInicial = System.currentTimeMillis();
					long tFinal = System.currentTimeMillis();
					tiempo = tFinal - tInicial;
				}
				catch(NumberFormatException e)
				{
					System.out.println("Debe ingresar los datos como numeros enteros");
				}
				break;

			case 4: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break; 

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
