package alumnos;

public class Ausencias {
	
	private String fecha;
	private int horas;
	
	public Ausencias(String fecha, int horas){
		this.fecha=fecha;
		this.horas=horas;
	}
	//get necesario
	public int getHoras(){
		return horas;
	}
	public String mostrar_ausencias(){
		return "Día " + fecha + ", " + horas + " horas";
	}

}
