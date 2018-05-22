package es.ux.mogndodb.ws.model;

/**
 * The Class Actividad	.
 */
public class Actividad {

	
	private String aplicacion;


	private String tiempo;

	
	private String fecha;

	
	private String error;
	
	
	private String camino;
	
	private String nombreActividad;


	
	public Actividad(String aplicacion, String tiempo, String fecha, String error ,String camino, String nombreActividad ) {
		super();
		this.aplicacion = aplicacion;
		this.tiempo = tiempo;
		this.fecha = fecha;
		this.error = error;
		this.camino = camino;
		this.nombreActividad = nombreActividad;
	}



	/**
	 * @return the aplicacion
	 */
	public String getAplicacion() {
		return aplicacion;
	}



	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}



	/**
	 * @return the tiempo
	 */
	public String getTiempo() {
		return tiempo;
	}



	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}



	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}



	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}



	/**
	 * @return the camino
	 */
	public String getCamino() {
		return camino;
	}



	/**
	 * @param camino the camino to set
	 */
	public void setCamino(String camino) {
		this.camino = camino;
	}



	/**
	 * @return the nombreActividad
	 */
	public String getNombreActividad() {
		return nombreActividad;
	}



	/**
	 * @param nombreActividad the nombreActividad to set
	 */
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actividad [aplicacion=" + aplicacion + ", tiempo=" + tiempo + ", fecha=" + fecha + ", error=" + error
				+ ", camino=" + camino + ", nombreActividad=" + nombreActividad + "]";
	}

	
	
	
}
