package ec.edu.epn.modelo.vo;

import java.util.Date;

public class ExamenVO {
	private int id;
	private String tema;
	private Date fecha;
	private int materiaId;
	public ExamenVO() {
		super();
		this.id = 0;
		this.tema = "";
		this.fecha = null;
		this.materiaId = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
}
