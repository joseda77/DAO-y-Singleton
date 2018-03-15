package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.City;

/**
 * @author jose.tello
 *
 */

/*Interfaz muy util para el patr�n DAO*/
public interface IciudadDAO {
	/*M�todo para insertar datos*/
	public void insertar(City ciudad) throws Exception;
	/*M�todo para actualizar datos*/
	public void actualizar(City ciudad)throws Exception;
	/*M�todo para eliminar datos*/
	public void eliminar(City ciudad)throws Exception;
	/*M�todo para obtener datos*/
	public List<City> obtener(City ciudad)throws Exception;

}
