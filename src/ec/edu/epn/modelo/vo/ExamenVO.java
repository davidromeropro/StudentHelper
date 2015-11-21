package ec.edu.epn.modelo.vo;

import java.util.Date;

public class ExamenVO {
	private int id;
	private String tema;
	private Date fecha;
	private String materiaNombre;
	public ExamenVO() {
		super();
		this.id = 0;
		this.tema = "";
		this.fecha = null;
		this.materiaNombre = "";
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
	public String getMateriaNombre() {
		return materiaNombre;
	}
	public void setMateriaNombre(String materiaNombre) {
		this.materiaNombre = materiaNombre;
	}
}
