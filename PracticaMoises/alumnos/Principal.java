package alumnos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Principal {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		ArrayList<AlumnoFormacion> af = new ArrayList<AlumnoFormacion>();
		ArrayList<AlumnoPerfeccionamiento> ap = new ArrayList<AlumnoPerfeccionamiento>();
		
		int opcion=0;
		
		do {
			opcion = Extras.menu();
			
			switch(opcion) {
				
				case 1: {
					//Añadir un objeto SargentoCAC al ArrayList af
					/* para construir el objeto SargentoCAC hay que pedir por teclado
					 * nombre, apellidos, escalafón y provincia para el constructor
					 * pediremos el numero de dni con una variable int y 
					 * usaremos el metodo setDni(int) heredado.
					 * Pediremos la fecha de nacimiento con un string, comprobaremos
					 * que es correcta con el método setFechaNacimiento(String)
					 * Una vez que la fecha sea correcta, ejecutamos el método edad()
					 */					
					// independientemente de como fueron ingresados, el nombre se guardará
					// en minusculas, y los apellidos en mayúsculas
					System.out.println("Nombre: ");
					String nombre = entrada.nextLine().toLowerCase();
					
					System.out.println("Apellidos: ");
					String apellidos = entrada.nextLine().toUpperCase();
					
					System.out.println("Provincia: ");
					String provincia = entrada.nextLine();
					
					System.out.println("Escalafón: ");
					int escalafon = Integer.parseInt(entrada.nextLine());
					
					SargentoCAC sc1 = new SargentoCAC(nombre,apellidos,escalafon,provincia);
					
					System.out.println("DNI: ");
					int dni = Integer.parseInt(entrada.nextLine());
					sc1.setDni(dni);
					
					String fecha;
					do {
						System.out.println("Fecha de Nacimiento(dd/mm/yyyy): ");
						fecha = entrada.nextLine();
					}
					while(sc1.setFechaNacimiento(fecha) == 'f');
					sc1.setFechaNacimiento(fecha);
					
					sc1.edad();
					
					af.add(sc1);
					
					break;
				}
				
				case 2: {
					//Añadir un objeto SargentoTEC al ArrayList ap
					/*para construir el objeto SargentoCAC hay que pedir por teclado
					 * nombre, apellidos, escalafón y destino para el constructor
					 * pediremos el numero de dni con una variable int y 
					 * usaremos el metodo setDni(int) heredado.
					 * Pediremos la fecha de nacimiento con un string, comprobaremos
					 * que es correcta con el método setFechaNacimiento(String)
					 * Añadiremos un domicilio con el método setDomicilio(String)
					 * Una vez que la fecha sea correcta, ejecutamos el método edad()
					 */
					// independientemente de como fueron ingresados, el nombre se guardará
					// en minusculas, y los apellidos en mayúsculas
					System.out.println("Nombre: ");
					String nombre = entrada.nextLine().toLowerCase();
					
					System.out.println("Apellidos: ");
					String apellidos = entrada.nextLine().toUpperCase();
					
					System.out.println("Escalafón: ");
					int escalafon = Integer.parseInt(entrada.nextLine());
					
					System.out.println("Domicilio: ");
					String domicilio = entrada.nextLine();
					
					System.out.println("Destino: ");
					String destino = entrada.nextLine();
					
					SargentoTEL st1 = new SargentoTEL(nombre,apellidos,domicilio,escalafon,destino);
					
					st1.setDomicilio(domicilio);
					
					System.out.println("DNI: ");
					int dni = Integer.parseInt(entrada.nextLine());
					st1.setDni(dni);
					
					String fecha;
					do {
						System.out.println("Fecha de Nacimiento(dd/mm/yyyy): ");
						fecha = entrada.nextLine();
					}
					while(st1.setFechaNacimiento(fecha) == 'f');
					st1.setFechaNacimiento(fecha);
					
					st1.edad();
					
					ap.add(st1);
					
					break;
				}
				
				case 3: {
					//Borrar objeto SargentoCAC del ArrayList af
					/* para borrar el objeto, preguntaremos por un patron de texto
					 * que será de tamaño máximo el que tenga los apellidos
					 * Recorreremos el ArrayList af, extrayendo el objeto con el método get(int index),
					 * y buscando este patrón en los apellidos. Cuando lo encontremos, pediremos
					 * confirmación antes de eleminarlo mostrando sus datos personales. 
					 * Usaremos el método  remove(int index)
					 */
					System.out.println("Patron de Apellidos: ");
					String patron = entrada.nextLine().toUpperCase();
					
					for(int i=0; i<af.size(); i++) {
						
						if(af.get(i).getApellidos().indexOf(patron) != -1) {
							System.out.println("Nombre: " + af.get(i).getNombre());
							System.out.println("Apellidos: " + af.get(i).getApellidos());
							System.out.println("Fecha de Nacimiento: " + af.get(i).getFechaNacimiento());
							System.out.println("DNI: " + af.get(i).getDni());
							System.out.println("Escalafon: " + af.get(i).getEscalafon());
							//System.out.println("Provincia: " + af.get(i));
							
							int op;
							do {
								System.out.println("¿Desea borrarlo?(1-Si.2-No.)");
								op = Integer.parseInt(entrada.nextLine());
							}
							while(op != 1 && op != 2);
							
							if(op == 1)
								af.remove(i);
							
							else
								System.out.println("Borrado cancelado.");
						}	
						
						else
							System.out.println("No se encuentra el patron de busqueda.");
					}
					
					break;
				}
				
				case 4: {
					//Borrar objeto SargentoTEL del ArrayList ap
					/* para borrar el objeto, preguntaremos por un patron de texto
					 * que será de tamaño máximo el que tenga los apellidos
					 * Recorreremos el ArrayList ap, extrayendo el objeto con el método get(int index),
					 * y buscando este patrón en los apellidos. Cuando lo encontremos, pediremos
					 * confirmación antes de eleminarlo mostrando sus datos personales. 
					 * Usaremos el método  remove(int index)
					 */
					System.out.println("Patron de Apellidos: ");
					String patron = entrada.nextLine().toUpperCase();
					
					for(int i=0; i<ap.size(); i++) {
						
						if(ap.get(i).getApellidos().indexOf(patron) != -1) {
							System.out.println("Nombre: " + ap.get(i).getNombre());
							System.out.println("Apellidos: " + ap.get(i).getApellidos());
							System.out.println("Fecha de Nacimiento: " + ap.get(i).getFechaNacimiento());
							System.out.println("DNI: " + ap.get(i).getDni());
							System.out.println("Escalafon: " + ap.get(i).getEscalafon());
							System.out.println("Domicilio: " + ap.get(i).getDomicilio());
							
							int op;
							do {
								System.out.println("¿Desea borrarlo?(1-Si.2-No.)");
								op = Integer.parseInt(entrada.nextLine());
							}
							while(op != 1 && op != 2);
							
							if(op == 1)
								ap.remove(i);
							
							else
								System.out.println("Borrado cancelado.");
						}	
						
						else
							System.out.println("No se encuentra el patron de busqueda.");
					}
					
					break;
				}
				
				case 5: {
					//Sancionar alumno
					/* Para sancionar un alumnos, primero preguntaremos por un número de escalafón
					 * Recorreremos el ArrayList af, extrayendo, con el método get(int index)
					 * el objeto y buscando este número de escalafón. Cuando lo encontremos
					 * pediremos confirmacion y usaremos el método anyadiar_sancion(String,int)
					 */
					int ranking;
					
					System.out.println("Introduce un número de escalafon: ");
					
					try {
						ranking = entrada.nextInt();
						entrada.nextLine();
						
						for(int i=0; i<af.size(); i++) {
							
							if(af.get(i).getEscalafon() == ranking) {
								System.out.println("Escalafon: " + af.get(i).getEscalafon());
								System.out.println("Nombre: " + af.get(i).getNombre());
								System.out.println("Apellidos: " + af.get(i).getApellidos());
								System.out.println("Fecha de Nacimiento: " + af.get(i).getFechaNacimiento());
								System.out.println("DNI: " + af.get(i).getDni());
								
								int op;
								do {
									System.out.println("¿Desea añadir sanción?(1-Si.2-No.)");
									op = entrada.nextInt();
									entrada.nextLine();
								}
								while(op != 1 && op != 2);
								
								if(op == 1) {
									System.out.println("Tipo de sancion: ");
									String tipo = entrada.nextLine();
									
									System.out.println("Dias de Sancion: ");
									int dias = entrada.nextInt();
									entrada.nextLine();
									
									af.get(i).anyadir_sancion(tipo, dias);
								}
								
								else
									System.out.println("Cancelado Añadir Sanción.");
							}
							
							else
								System.out.println("No hay ningun alumno con ese escalafon.");
						}
					}
					
					catch(InputMismatchException ex) {
						
						System.out.println(ex);
					}
					
					break;
				}
				
				case 6: {
					//Anotar ausencia
					/* Para anotar una ausencia, primero preguntaremos por un número de escalafon
					 * Recorreremos el ArrayList af, extrayendo, con el método get(int index)
					 * el objeto y buscando este número de escalafón. Cuando lo encontremos
					 * pediremos confirmacion y usaremos el método anyadiar_ausencia(String,int)
					 */
					int ranking;
					System.out.println("Introduce un número de escalafon: ");
					
					try {
						ranking = entrada.nextInt();
						entrada.nextLine();
							
						for(int i=0; i<ap.size(); i++) {
								
							if(ap.get(i).getEscalafon() == ranking) {
								System.out.println("Escalafon: " + ap.get(i).getEscalafon());
								System.out.println("Nombre: " + ap.get(i).getNombre());
								System.out.println("Apellidos: " + ap.get(i).getApellidos());
								System.out.println("Fecha de Nacimiento: " + ap.get(i).getFechaNacimiento());
								System.out.println("DNI: " + ap.get(i).getDni());
								
								int op;
								do {
									System.out.println("¿Desea añadir ausencia?(1-Si.2-No.)");
									op = entrada.nextInt();
									entrada.nextLine();
								}
								while(op != 1 && op != 2);
									
								if(op == 1) {
									System.out.println("Fecha de la ausencia: ");
									String fecha = entrada.nextLine();
										
									System.out.println("Horas de Ausencia: ");
									int horas = entrada.nextInt();
									entrada.nextLine();
										
									ap.get(i).anyadir_ausencia(fecha, horas);
								}
								
								else
									System.out.println("Cancelado añadir Ausencia.");
							}
								
							else
								System.out.println("No hay ningun alumno con ese escalafón.");
						}
					}
						
					catch(InputMismatchException ex) {
						System.out.println(ex);
					}
					
					break;
				}
				
				case 7: {
					//Consulta sanciones alumnos
					/* Con un foreach recorreremos todo el arraylist af comprobando si los alumnos
					 * tienen sanciones anotadas (método getCantidad). Si tiene sanciones
					 * ejecutaremos el método mostrar_sanciones_alumno(),
					 */
					for(AlumnoFormacion alform : af) {

						if(alform.getCantidad()>0) 
							alform.mostrar_sanciones_alumno();
					}
					
					break;
				}
				
				case 8: {
					//Consulta ausencias alumnos
					/* Con un foreach recorreremos todo el arraylist ap comprobando si los alumnos
					 * tienen ausencias anotadas (método getCantidad). Si tiene ausencias
					 * ejecutaremos el método mostrar_ausencias_alumno(),
					 */
					for(AlumnoPerfeccionamiento alperf : ap) {
						
						if(alperf.getCantidad()>0)
							alperf.mostrar_ausencias_alumno();
					}
					
					break;
				}
				
				case 9:	{
					//Listado calificaciones finales todos los alumnos
					ArrayList<Alumno> a = new ArrayList<Alumno>();
					
					/* Copiaremos los dos arraylist af y ap en el arraylist<Alumno> con sendos bucles for normales.
					 * primero los alumnos de formación y seguido los de perfeccionamiento
					 * Una vez copiados, recorreremos al ArrayList<Alumno> con un foreach para listarlos
					 * En el listado usaremos el método calificacion_final, mostrando antes de
					 * esta calificacion_final los siguiente datos personales: apellidos, nombre, dni, 
					 * edad, curso, escalafón
					 * Como extra, mostrará tambien el destino o provincia según corresponda 
					 * [OPERADOR INSTANCEOF] + conversión explícita (hija)padre
					 * despues de visualizar estos datos personales y la calificación final de cada
					 * alumno, ejecutará tambien el método visualizar_alumnos que se ha ido sobreescribiendo
					 * añadiendole (anteponiendo) sus iniciales a la cadena que devuelve
					 */
					for(int i=0; i<af.size(); i++) {
						
						a.add(af.get(i));
					}
					
					for(int i=0; i<ap.size(); i++) {
						
						a.add(ap.get(i));
					}
					
					for(Alumno lista : a) {
						
						System.out.println("Apellidos: " + lista.getApellidos());
						System.out.println("Nombre: " + lista.getNombre());
						System.out.println("DNI: " + lista.getDni());
						System.out.println("Edad: " + lista.edad());
						System.out.println("Curso: " + lista.getCurso());
						System.out.println("Escalafon: " + lista.getEscalafon());
						
						if(lista instanceof SargentoCAC)
							System.out.println("Provincia: " + ((SargentoCAC) lista).getProvincia());
						
						if(lista instanceof SargentoTEL)
							System.out.println("Destino: " + ((SargentoTEL) lista).getDestino());
							
						System.out.println("Calificacion Final: " + lista.calificacion_final());
						System.out.println("MNB : "+lista.visualizar_alumno());
						System.out.println("------------------------------------------------");
					}
					
					break;
				}
				
				default: {
					
					if(opcion != 0)
						System.out.println("\nXXX OPCION INCORRECTA XXX");
					
					break;
				}
			}
		}
		
		while (opcion!=0);
	}
}
