package ec.edu.epn.modelo.vo;

import java.util.Date;

public class TareaVO {
	private int id;
	private String titulo;
	private String descripcion;
	private String fechaEntrega;
	private Date fechaE;
	private int materiaId;
	public TareaVO() {
		super();
		this.id = 0;
		this.titulo = "";
		this.descripcion = "";
		this.fechaEntrega="";
		this.fechaE = null;
		this.materiaId = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaE() {
		return fechaE;
	}
	public void setFechaE(Date fechaEntrega) {
		this.fechaE = fechaEntrega;
	}
	public int getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fecha) {
		this.fechaEntrega = fecha;
	}
}
