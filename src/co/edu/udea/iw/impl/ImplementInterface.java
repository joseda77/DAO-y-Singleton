/**
 * Clase que contiene toda la logica del negocio 
 */
package co.edu.udea.iw.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dao.IciudadDAO;
import co.edu.udea.iw.dto.City;

/**
 * @author Jose David Tello Medina - Jose.tello@udea.edu.co
 * Clase que contiene toda la logica del CRUD de la BD
 */
public class ImplementInterface implements IciudadDAO {
	private DataSource connection = DataSource.getInstance();
	private PreparedStatement prepareStat= null;
	private ResultSet resultS = null;
	private Connection containConnection = null;
	private int codigoCiudad = 0;
	private String ciudadName = null;
	private String codigoArea = null;
	public String comandoSQL = null;  
	

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.IciudadDAO#insertar(co.edu.udea.iw.dto.City)
	 * Inserta una nueva ciudad con los parametros que se establecieron en la interfaz
	 */
	@Override
	public void insertar(City ciudad) throws Exception {		
		codigoCiudad = ciudad.getCodigoCiudad();
		ciudadName = ciudad.getNombreCiudad();
		codigoArea = ciudad.getCodigoArea();
		comandoSQL = "insert into ciudades values('"+codigoCiudad+"','"+ciudadName+"','"+codigoArea+"');";
		try {
			containConnection = connection.getConnection();
			prepareStat = (PreparedStatement) containConnection.prepareStatement(comandoSQL);
			prepareStat.execute();			
		}catch(SQLException e) {
			throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
		}finally {
			this.closeConnection();
		}	
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.IciudadDAO#actualizar(co.edu.udea.iw.dto.City)
	 * Actualiza los datos de la ciudad solo con el ingreso de nuevo de cada uno de los datos e ingresando el nombre 
	 * de la ciudad a actualizar
	 */
	@Override
	public void actualizar(City ciudad) throws Exception {
		codigoCiudad = ciudad.getCodigoCiudad();
		ciudadName = ciudad.getNombreCiudad();
		codigoArea = ciudad.getCodigoArea();
		comandoSQL = "update ciudades set codigo="+codigoCiudad+" nombre="+	ciudadName+", CodigoArea="+codigoArea+" where codigo ="+codigoCiudad+";";
		try {
			containConnection = connection.getConnection();
			prepareStat = (PreparedStatement) containConnection.prepareStatement(comandoSQL);//revisar linea
			prepareStat.execute();			
		}catch(SQLException e) {
			throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
		}finally {
			this.closeConnection();
		}	

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.IciudadDAO#eliminar(co.edu.udea.iw.dto.City)
	 * Elimina una ciudad dependiendo el codigo de la ciudad seleccionada
	 */
	@Override
	public void eliminar(City ciudad) throws Exception {
		codigoCiudad = ciudad.getCodigoCiudad();
		comandoSQL = "Delete from ciudades where codigo="+codigoCiudad+";";
		try {
			containConnection = connection.getConnection();
			prepareStat = (PreparedStatement) containConnection.prepareStatement(comandoSQL);
			prepareStat.execute();	
		}catch(SQLException e) {
			throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
		}finally {
			this.closeConnection();
		}

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.dao.IciudadDAO#obtener(co.edu.udea.iw.dto.City)
	 * Obtiene los datos de una ciudad cualquiera
	 */
	@Override
	public List<City> obtener(City ciudad) throws Exception {
		prepareStat = null;
		resultS = null;
		containConnection =null;
		comandoSQL = "select * from ciudades;";
		List<City> ciudades = new ArrayList<City>();
		try {
			containConnection = connection.getConnection();
			prepareStat= (PreparedStatement) containConnection.prepareStatement(comandoSQL);//mirar este cast
			resultS = prepareStat.executeQuery();
			while(resultS.next()) {
				City varCiudad = new City();
				varCiudad.setCodigoCiudad(resultS.getInt("codigo"));
				varCiudad.setNombreCiudad(resultS.getString("Nombre"));
				varCiudad.setCodigoArea("CodigoArea");
				ciudades.add(varCiudad);
			}
		}catch(SQLException e) {
			throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
		}finally {
			this.closeConnection();
		}
		return ciudades;
	}
	
	
	/*Método para cerrar todas las conexiones a SQL*/
	public void closeConnection() throws Exception {
		try {
		resultS.close();
		prepareStat.close();
		containConnection.close();
		}catch(SQLException e){
			throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
		}
		
	}

}
