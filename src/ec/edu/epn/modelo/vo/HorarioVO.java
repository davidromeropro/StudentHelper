package ec.edu.epn.modelo.vo;


public class HorarioVO {
	private int id;
	private String inicio;
	private String fin;
	private String dia;
	private String materiaNombre;
	public HorarioVO() {
		this.id = 0;
		this.inicio = "";
		this.fin = "";
		this.dia = "";
		this.materiaNombre = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMateriaNombre() {
		return materiaNombre;
	}
	public void setMateriaNombre(String materiaNombre) {
		this.materiaNombre = materiaNombre;
	}
}
