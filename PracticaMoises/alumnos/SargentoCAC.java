package alumnos;

public class SargentoCAC extends AlumnoFormacion {
	
	//atributo
	private String provincia;
	
	//Constructor
	public SargentoCAC (String nombre, String apellidos, int orden, String Provincia) {
		
		super(nombre,apellidos,"24ª PROMOCION CG-EB-CAC/CIS");
		asignaturas = new Asignatura[9];
		rellena_asignaturas();
		setEscalafon(orden);
		provincia = Provincia;
	}
	
	//metodos set/get provincia
	public void setProvincia(String provincia) {
		
		this.provincia = provincia;
	}
	
	public String getProvincia() {
		
		return provincia;
	}
	
	@Override
	//método sobreescrito
	public String visualizar_alumno() {
		
		String padre = super.visualizar_alumno();
		
		return padre + "|CAC|" + this.toString();
	}
	
	//implementacion métodos abstractos interfaces
	public double calificacion_parcial() {
		
		double cp = 0.0;
		//método que hace la media de las notas de todas las asignaturas
		for(int i=0; i<asignaturas.length-1; i++) {
			
			String[] nota = asignaturas[i].mostrar_asignatura().split(":");
			
			cp += Double.parseDouble(nota[1]);
		}
		
		cp /= asignaturas.length;
		
		return cp;
	}
	
	public double ipa() {
		
		double informe_alumno = 10;
		//metodo que vaya restando 1 por cada sancion del alumno; 
		//usando el método getCantidad de cada alumno
		informe_alumno -= this.getCantidad();
		
		return informe_alumno;
	}
	
	public double calificacion_final() {
		
		double nfinal = 0.0;
		//Calcular el 70% de la calificacion_parcial
		//Calcular el 30% del ipa
		//método que devuelva la suma estos dos porcentajes
		nfinal = 0.7 * calificacion_parcial() + 0.3 * ipa();
		
		return nfinal;
	}
}
