package ec.edu.epn.modelo.vo;

public class UsuarioVO {
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String fotoPerfil;
	private boolean estado;
	private boolean administrador;
	public UsuarioVO() {
		super();
		this.email = "";
		this.password = "";
		this.nombre = "";
		this.apellido = "";
		this.fotoPerfil="";
		this.estado = true;
		this.administrador = false;
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
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public String getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
}
