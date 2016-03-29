package alumnos;

public class Asignatura {
	
	private String asignatura;
	private int nota;
	
	public Asignatura (String asignatura, int nota) {
		
		this.asignatura=asignatura;
		this.nota=nota;
	}
	
	public String mostrar_asignatura() {
	
		return asignatura+":" + nota;
	}
}
