package ec.edu.epn.modelo.vo;

public class MateriaVO {
	private int id;
	private String nombre;
	private String profesor;
	private String aula;
	private String usuarioEmail;
	public MateriaVO() {
		this.id=0;
		this.nombre = "";
		this.profesor = "";
		this.aula = "";
		this.usuarioEmail = "";
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
	public String getUsuarioEmail() {
		return usuarioEmail;
	}
	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
