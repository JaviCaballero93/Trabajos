package alumnos;
public abstract class AlumnoPerfeccionamiento extends Alumno {
	//atributos
	protected Ausencias aus[];
	protected int cantidad=0;
	protected int acumuladas=0;
	//constructor
	public AlumnoPerfeccionamiento(String nombre, String apellidos, String curso){
		super(nombre,apellidos);
		aus = new Ausencias[10];
		this.curso=curso;
		//para dar valores a dni y fecha_nacimiento, usar métodos de la clase padre
		this.dni = getDni();
		this.fecha_nacimiento = getFechaNacimiento();
	}
	//get/set necesarios
	public int getCantidad(){
		return cantidad;
	}
	public int getAcumuladas(){
		return acumuladas;
	}
	public void setDomicilio(String home){
		domicilio=home;
	}
	public void anyadir_ausencia(String fecha, int horas){
		//añadir un objeto ausencia al array de ausencias
		//Ausencias a = new Ausencias(fecha,horas)
		//aus[cantidad]=a;
		//usar el atributo cantidad para controlar el máximo de 10 sanciones
		//iremos sumando en acumuladas la cantidad total de horas
		//acumuladas=acumuladas+a.getHoras();
		for(int i=0; i<aus.length; i++) {
			if(i==getCantidad() && getCantidad() < 10) {
				aus[i] = new Ausencias(fecha, horas);
				acumuladas += aus[i].getHoras();	
			}
			
			else if(getCantidad() == 10)
				System.out.println("Ha llegado al límite de 10 ausencias.");
		}
		
		cantidad++;
	}
	public void mostrar_ausencias_alumno(){
		//hay que usar el método mostrar_ausencia en todos
		//los objetos ausencia del array
		int i;
		 try {
			 for(i=0; i<getCantidad(); i++) 
				 System.out.println(aus[i].mostrar_ausencias());
		 }
		 
		 catch(NullPointerException ex) {
			 System.out.println(ex);
			 i=10;
		 }
	}
	public String visualizar_alumno(){
		return "<AlumnoPerfeccionamiento>" + this.toString();
	}
}
