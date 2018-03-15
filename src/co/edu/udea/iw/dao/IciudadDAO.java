package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.City;

/**
 * @author jose.tello
 *
 */

/*Interfaz muy util para el patrón DAO*/
public interface IciudadDAO {
	/*Método para insertar datos*/
	public void insertar(City ciudad) throws Exception;
	/*Método para actualizar datos*/
	public void actualizar(City ciudad)throws Exception;
	/*Método para eliminar datos*/
	public void eliminar(City ciudad)throws Exception;
	/*Método para obtener datos*/
	public List<City> obtener(City ciudad)throws Exception;

}
