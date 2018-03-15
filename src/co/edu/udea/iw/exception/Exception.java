/**
 * 
 */
package co.edu.udea.iw.exception;

/**
 * @author Jose David Tello Medina - Jose.tello@udea.edu.co
 *
 */

/*Esta clase se encarga del manejo de las excepciones*/
public class Exception extends java.lang.Exception {

	/**
	 * 
	 */
	public Exception() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public Exception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public Exception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public Exception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
