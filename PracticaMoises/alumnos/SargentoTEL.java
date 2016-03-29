package alumnos;

public class SargentoTEL extends AlumnoPerfeccionamiento {
	
	//atributo
	private String destino;
	
	//Constructor
	public SargentoTEL (String nombre, String apellidos, String domicilio, int orden, String destino) {
		
		super(nombre,apellidos,"2º CURSO CG-EB-MOP/TEL");
		asignaturas = new Asignatura[7];
		rellena_asignaturas();
		setEscalafon(orden);
		this.destino=destino;
	}
	
	//metodos set/get destino
	public void setDestino(String destiny) {
		
		destino = destiny;
	}
	
	public String getDestino() {
		
		return destino;
	}
	
	//método propio
	public double coeficiente() {
		
		double coef = 0;
		//método que va restando 0,3 por cada hora de ausencia
		coef = (0.3) * getAcumuladas();
		
		return coef;
	}
	
	//método sobreescrito
	@Override
	public String visualizar_alumno() {
		
		String padre = super.visualizar_alumno();
		return padre + "|TEL|" + this.toString();
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
	
	public double calificacion_final() {
		
		double nfinal=0.0;
		//A la calificacion_parcial le restamos el coeficiente
		//método que devuelva la suma estos dos porcentajes
		nfinal = calificacion_parcial() - coeficiente();	
		
		return nfinal;
	}
}
