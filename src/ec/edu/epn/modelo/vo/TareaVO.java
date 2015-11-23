package ec.edu.epn.modelo.vo;

import java.util.Date;

public class TareaVO {
	private int id;
	private String titulo;
	private String descripcion;
	private Date fechaEntrega;
	private int materiaId;
	public TareaVO() {
		super();
		this.id = 0;
		this.titulo = "";
		this.descripcion = "";
		this.fechaEntrega = null;
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
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getMateriaId() {
		return materiaId;
	}
	public void setMateriaId(int materiaId) {
		this.materiaId = materiaId;
	}
}
