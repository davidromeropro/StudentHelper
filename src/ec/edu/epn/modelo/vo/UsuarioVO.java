package ec.edu.epn.modelo.vo;

public class UsuarioVO {
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private boolean estado;
	public UsuarioVO() {
		this.email="";
		this.password="";
		this.nombre="";
		this.apellido="";
		this.estado=true;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
