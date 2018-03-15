package co.edu.udea.iw.dto;

/**
 * @author Jose David Tello Medina - Jose.tello@udea.edu.co
 *
 */

/*Esta clase se encarga de DTO o data transfer object*/
public class City {
	private int codigoCiudad;
	private String nombreCiudad;
	private String codigoArea;
	
	public int getCodigoCiudad() {
		return codigoCiudad;
	}
	public void setCodigoCiudad(int codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
}
