package alumnos;
import java.util.Scanner;
public class Extras {
	
	private static Scanner tc = new Scanner(System.in);
	
	//métodos staticos
	public static String nif(int dni){
		//Tendrá que usar obligatoriamiente la cadena letras en la obtención de la letra del nif
		//usando algún método de manejo de cadenas como toCharArray(), charAt()
		String letras= "TRWAGMYFPDXBNJZSQVHLCKE";
		String nif="";
		//metodo que calcula la letra del dni pasado y devolvemos el nif
		nif += String.valueOf(dni) + letras.charAt(dni % 23);
		
		return nif;
	}
	public static String rellena_cadena(int tamanyo){
		String salida="";
		//um método que cree una cadena de letras aleatorias del tamanyo indicado
		for(int i=0; i<tamanyo; i++) {
			if(i==0) 
				salida += (char)(Math.floor(Math.random() * 26 + 'A'));
			
			else
				salida += (char)(Math.floor(Math.random() * 26 + 'a'));
		}
		
		return salida;
	}
	public static double numero_aleatorio(int inicio,int fin){
		double generado;
		generado=((Math.random()*fin)+inicio);
		return generado;
	}
	
	public static int menu(){
		int opcion=0;
			System.out.println("\n1.- Alta Alumno Formacion");
			System.out.println("2.- Alta Alumno Perfeccionamiento");
			System.out.println("3.- Baja Alumno Formacion");
			System.out.println("4.- Baja Alumno Perfeccionamiento");
			System.out.println("5.- Sanciona Alumno Formacion");
			System.out.println("6.- Ausencia Alumno Perfeccinamiento");
			System.out.println("7.- Consulta Sanciones Alumnos Formacion");
			System.out.println("8.- Consulta Ausencias Alumnos Perfeccionamiento");
			System.out.println("9.- Consulta Calificaciones Finales Alumnos");
			System.out.println("0.- Salir");
			System.out.print(">>> ");
			opcion=tc.nextInt();	
		return opcion;
	}

}
