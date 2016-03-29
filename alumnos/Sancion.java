package alumnos;

public class Sancion {
	
	private String tipo_sancion;
	private int dias_sancion;
	
	public Sancion(String tipo, int dias){
		tipo_sancion=tipo;
		dias_sancion=dias;
	}
	
	public String mostrar_sancion(){
		return dias_sancion + "dias de " + tipo_sancion;
		
	}

}
