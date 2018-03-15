package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 * @author Jose David Tello Medina - jose.tello@udea.edu.co
 * Clase de conexión y acceso a la BD
 */

public class DataSource {
	//Variables necesarias para la conexiÃ³n a la bd
	private String driverJDBC = "com.mysql.jdbc.Driver";
	private String url= "jdbc:mysql://localhost:3306/dbclase";
	private String username = "root";
	private String password = "root";
	private static Connection connection = null;	
	private static DataSource instance;
	
	//Constructor de la clase
	private DataSource() {}
	
	//Instancia de la clase
	public static DataSource getInstance(){
	    if(connection==null){
	        instance= new DataSource();
	    }
	    return instance;
	    }
	
	//Método para la conexión a la base de datos y retorna la conexión
	public Connection getConnection() throws Exception{
		if (connection==null) {
			try {
				Class.forName(driverJDBC);
				connection = DriverManager.getConnection(url,username,password);
			}catch(ClassNotFoundException e) {
				throw new Exception("No ha encontrado: " +e);	
			}catch( SQLException e) {
				throw new Exception("Ha ocurrido un error al conectar a la bd: " +e);
			}
		}
		return connection;		
	}
	
}
