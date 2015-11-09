package ec.edu.epn.modelo.vo;

public class MateriaVO {
	private String nombre;
	private String profesor;
	private String aula;
	private String usuario;
	public MateriaVO() {
		super();
		this.nombre = "";
		this.profesor = "";
		this.aula = "";
		this.usuario = "";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
