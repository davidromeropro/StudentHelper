package ec.edu.epn.modelo.servicio;

public class InformacionConexionBDD {
	private String servidor = "localhost:3306";
	private String database = "StudentHelper";
	private String usuarioDB = "root";
	private String passwordDB = "password";
	private String url = "jdbc:mysql://" + servidor + "/" + database;
	
	public String getServidor() {
		return servidor;
	}
	public String getDatabase() {
		return database;
	}
	public String getUsuarioDB() {
		return usuarioDB;
	}
	public String getPasswordDB() {
		return passwordDB;
	}
	public String getUrl() {
		return url;
	}
}
