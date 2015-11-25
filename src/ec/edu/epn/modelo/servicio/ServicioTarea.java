package ec.edu.epn.modelo.servicio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.edu.epn.modelo.vo.TareaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

public class ServicioTarea {

	InformacionConexionBDD ic = new InformacionConexionBDD();

	public TareaVO buscarTarea(int idTarea) {
		TareaVO tar = new TareaVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());

			PreparedStatement st = con.prepareStatement("Select * from TAREA where IDTAREA=?");
			st.setInt(1, idTarea);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tar;
	}

	public void registrarTarea(TareaVO tar) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"Insert into TAREA (TITULOTAREA, DESCRIPCIONTAREA, FECHAENTREGATAREA, MATERIA_IDMATERIA) values (?,?,?,?)");
			st.setString(1, tar.getTitulo());
			st.setString(2, tar.getDescripcion());
			st.setString(3, tar.getFechaEntrega());
			st.setInt(4, tar.getMateriaId());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarTarea(TareaVO tarInicio, TareaVO tarFin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"UPDATE TAREA SET TITULOTAREA=?, DESCRIPCIONTAREA=?, FECHAENTREGATAREA=? WHERE IDTAREA=?");
			st.setString(1, tarFin.getTitulo());
			st.setString(2, tarFin.getDescripcion());
			st.setString(3, tarFin.getFechaEntrega());
			st.setInt(4, tarInicio.getId());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eliminarTarea(TareaVO tar) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("delete from Tarea where IDTAREA=?");
			st.setInt(1, tar.getId());
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<TareaVO> listarTareasAll() {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT * FROM TAREA");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeTarMat(String nombreMateria, String tituloTarea) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.NOMBREMATERIA LIKE ? AND t.TITULOTAREA LIKE ?");
			st.setString(1, "%" + nombreMateria + "%");
			st.setString(2, "%" + tituloTarea + "%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeTar(String tituloTarea) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT IDTAREA, MATERIA_IDMATERIA, TITULOTAREA, DESCRIPCIONTAREA, FECHAENTREGATAREA FROM TAREA WHERE TITULOTAREA LIKE ?");
			st.setString(1, "%" + tituloTarea + "%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeMat(String nombreMateria) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.NOMBREMATERIA LIKE ?");
			st.setString(1, "%" + nombreMateria + "%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasAllByUsr(UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeTarMatByUsr(String nombreMateria, String tituloTarea, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND m.NOMBREMATERIA LIKE ? AND t.TITULOTAREA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%" + nombreMateria + "%");
			st.setString(3, "%" + tituloTarea + "%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeTarByUsr(String tituloTarea, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND t.TITULOTAREA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%" + tituloTarea + "%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasLikeMatByUsr(String nombreMateria, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND m.NOMBREMATERIA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%" + nombreMateria + "%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getString("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByMonthYearUsr(int month, int year, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int mes = cal.get(Calendar.MONTH) + 1;
				int anio = cal.get(Calendar.YEAR);
				if (mes == month && anio == year) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByYearUsr(int year, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int anio = cal.get(Calendar.YEAR);
				if (anio == year) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByMonthUsr(int month, UsuarioVO usr) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"SELECT t.IDTAREA, t.MATERIA_IDMATERIA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int mes = cal.get(Calendar.MONTH) + 1;
				if (mes == month) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByMonthYear(int month, int year) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT * FROM TAREA");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int mes = cal.get(Calendar.MONTH) + 1;
				int anio = cal.get(Calendar.YEAR);
				if (mes == month && anio == year) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByMonth(int month) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT * FROM TAREA");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int mes = cal.get(Calendar.MONTH) + 1;
				if (mes == month) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public List<TareaVO> listarTareasByYear(int year) {
		List<TareaVO> listaTareas = new ArrayList<TareaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT * FROM TAREA");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setMateriaId(rs.getInt("MATERIA_IDMATERIA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				String fechaE = rs.getString("FECHAENTREGATAREA");
				tar.setFechaEntrega(fechaE);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date fechaEntrega = formatter.parse(fechaE);
					tar.setFechaE(fechaEntrega);
				} catch (Exception e) {
					e.printStackTrace();
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(tar.getFechaE());
				int anio = cal.get(Calendar.YEAR);
				if (anio == year) {
					listaTareas.add(tar);
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}

	public String mesbyInt(int month) {
		String monthString;
		switch (month) {
		case 1:
			monthString = "Enero";
			break;
		case 2:
			monthString = "Febrero";
			break;
		case 3:
			monthString = "Marzo";
			break;
		case 4:
			monthString = "Abril";
			break;
		case 5:
			monthString = "Mayo";
			break;
		case 6:
			monthString = "Junio";
			break;
		case 7:
			monthString = "Julio";
			break;
		case 8:
			monthString = "Agosto";
			break;
		case 9:
			monthString = "Septiembre";
			break;
		case 10:
			monthString = "Octubre";
			break;
		case 11:
			monthString = "Noviembre";
			break;
		case 12:
			monthString = "Diciembre";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		return monthString;
	}
	
	public String diabyInt(int day) {
		String dayString;
		switch (day) {
		case 1:
			dayString = "Domingo";
			break;
		case 2:
			dayString = "Lunes";
			break;
		case 3:
			dayString = "Martes";
			break;
		case 4:
			dayString = "Miercoles";
			break;
		case 5:
			dayString = "Jueves";
			break;
		case 6:
			dayString = "Viernes";
			break;
		case 7:
			dayString = "Sabado";
			break;
		default:
			dayString = "Invalid month";
			break;
		}
		return dayString;
	}

}
