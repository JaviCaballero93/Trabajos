package alumnos;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Alumno implements Calificacion {
	
	//atributos
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String fecha_nacimiento;
	protected String domicilio;
	protected String curso;
	protected int escalafon;
	protected Asignatura asignaturas[];
	
	//constructores
	public Alumno(String nombre, String apellidos) {
		
		this.nombre=nombre;
		this.apellidos=apellidos;
		dni=domicilio=fecha_nacimiento="";
	}
	
	//métodos set/get
	protected void setNombre(String nombre) {
		
		this.nombre=nombre;
	}
	
	protected String getNombre() {
		
		return nombre;
	}
	
	protected void setApellidos(String apellidos) {
		
		this.apellidos=apellidos;
	}
	
	protected String getApellidos() {
		
		return apellidos;
	}
	
	protected String getDni(){
		
		return dni;
	}
	
	//Debe ser void para poderle añadir el valor de nif en la variable dni
	protected void setDni(int numero) {
	
		String nif;
		nif=Extras.nif(numero);
		this.dni =nif;
	}
	
	protected String getDomicilio() {
		
		return domicilio;
	}
	
	protected char setFechaNacimiento(String fecha) {
		//llama al método que comprueba si es correcta la fecha
		//si es correcta, la guarda en el atributo fecha_nacimiento y devuelve la letra t
		//si no es correcta devuelve 'f' y que vuelva a pedir la fecha
		boolean correcta=false;
		
		correcta = comprueba_fecha(fecha); 
		
		if (correcta){
			
			fecha_nacimiento=fecha;
			return 't';
		}
		
		else 
			return 'f';
	}
	
	protected String getFechaNacimiento() {
		
		return fecha_nacimiento;
	}
	
	protected void setEscalafon(int orden) {
		
		escalafon=orden;
	}
	
	protected int getEscalafon() {
		
		return escalafon;
	}
	
	public void setCurso(String curse) {
		
		curso=curse;
	}
	
	public String getCurso() {
		
		return curso;
	}

	//resto de métodos
	protected int edad() {
		
		int edad=0;
		//Calcular la edad por la fecha de nacimiento
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		String hoy = formato.format(fechaActual);
	    	String[] dat1 = getFechaNacimiento().split("/");
	    	String[] dat2 = hoy.split("/");
	    	
		int anios = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
	    	int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
	    
	    	if (mes < 0) 
	      		anios -= 1;
	     
	    	else if (mes == 0) {
	      		int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
	      
	      		if (dia < 0) 
	      			anios -= 1;
	    	}
		
	    	edad = anios;
	    
		return edad;
	}
	protected boolean comprueba_fecha(String fecha) {
		
		boolean fecha_correcta=false;
		//método que compruebe si fecha tiene el formato "dd/mm/aaaa"
		String[]dato;
	
		try {
			dato = fecha.split("/");
			
			int dia = Integer.parseInt(dato[0]);
			int mes = Integer.parseInt(dato[1]);
			int anio = Integer.parseInt(dato[2]);
			
			if(dia>=1 && dia<=31)
				if(mes>=1 && mes<=12)
					if(anio>1000)
						fecha_correcta = true;
		}
		
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		
		if (fecha_correcta)
			return true;
		else 
			return false;
	}
	protected void rellena_asignaturas() {
		
		//método que rellene automáticamente el array de asignaturas
		//para no tener que ir rellenandolas a mano
		Asignatura a1 = new Asignatura("Java",8);
		asignaturas[0]=a1;
		//el nombre de las asignaturas con el método estatico Extras.rellena_cadena
		//la nota de la asignatura con el método estatico Extras.genera_numero
		for(int i=1; i<asignaturas.length-1; i++) {
		
			asignaturas[i] = new Asignatura(Extras.rellena_cadena((int)Extras.numero_aleatorio(2, 10)),(int) Extras.numero_aleatorio(0, 10));
		}
	}
	
	//métodos abstractos
	protected abstract void setDomicilio(String domicilio);
	//método abstracto para guardar el domicilio según el alumno derivado
	protected abstract String visualizar_alumno();
}
