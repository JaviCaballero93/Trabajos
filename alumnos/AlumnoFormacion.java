package alumnos;
public abstract class AlumnoFormacion extends Alumno implements Ipa {
	//atributos
	protected Sancion san[];
	protected int cantidad=0;
	//constructor
	public AlumnoFormacion(String nombre, String apellidos, String curso){
		super(nombre,apellidos);
		san = new Sancion[10];
		this.curso=curso;
		//para dar valores a dni y fecha_nacimiento, usar métodos de la clase padre
		this.dni = getDni();
		this.fecha_nacimiento = getFechaNacimiento();
		setDomicilio("Emacot");
	}
	//getCantidad necesario para devolver la cantidad de sanciones
	public int getCantidad(){
		return cantidad;
	}
	//resto métodos
	public void setDomicilio(String Domicilio){
		domicilio=Domicilio;
	}
	public void anyadir_sancion(String tipo, int dias){
		//añadir un objeto sancion al array de sanciones
		//usar el atributo cantidad para controlar el máximo de 10 sanciones
		for(int i=0; i<san.length-1; i++) {
			if(i==getCantidad() && getCantidad() < 10) {
				san[i] = new Sancion(tipo, dias);
			}
			else if(getCantidad()== 10)
				System.out.println("Se han incluido el máximo de 10 sanciones.");
		}
		
		cantidad++;
	}
	public void mostrar_sanciones_alumno(){
		//hay que usar el método mostrar_sancion en todos
		//los objetos sancion del array
		int i;
		
		try{
			for (i=0; i<10; i++){
				System.out.println(san[i].mostrar_sancion());
			}	
		}
		catch (NullPointerException ex){
			System.out.println(ex);
			i=10;
		}
	}
	public String visualizar_alumno(){
		return "<AlumnoFormacion>" + this.toString();
	}
}
