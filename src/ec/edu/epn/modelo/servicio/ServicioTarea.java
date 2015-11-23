package ec.edu.epn.modelo.servicio;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

			PreparedStatement st = con
					.prepareStatement("Select * from TAREA where IDTAREA=?");
			st.setInt(1, idTarea);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			st.setDate(3, (Date) tar.getFechaEntrega());
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
					"UPDATE TAREA SET TITULOTAREA=?, DESCRIPCIONTAREA=?, FECHAENTREGATAREA=? MATERIA_IDMATERIA=? WHERE IDTAREA=?");
			st.setString(1, tarFin.getTitulo());
			st.setString(2, tarFin.getDescripcion());
			st.setDate(3, (Date) tarFin.getFechaEntrega());
			st.setInt(4, tarFin.getMateriaId());
			st.setInt(5, tarInicio.getId());
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
			PreparedStatement st = con
					.prepareStatement("delete from Tarea where IDTAREA=?");
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
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.NOMBREMATERIA LIKE ? AND t.TITULOTAREA LIKE ?");
			st.setString(1, "%"+nombreMateria+"%");
			st.setString(2, "%"+tituloTarea+"%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT IDTAREA, TITULOTAREA, DESCRIPCIONTAREA, FECHAENTREGATAREA FROM TAREA WHERE TITULOTAREA LIKE ?");
			st.setString(1, "%"+tituloTarea+"%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.NOMBREMATERIA LIKE ?");
			st.setString(1, "%"+nombreMateria+"%");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND m.NOMBREMATERIA LIKE ? AND t.TITULOTAREA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%"+nombreMateria+"%");
			st.setString(3, "%"+tituloTarea+"%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND t.TITULOTAREA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%"+tituloTarea+"%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
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
			PreparedStatement st = con.prepareStatement("SELECT t.IDTAREA, t.TITULOTAREA, t.DESCRIPCIONTAREA, t.FECHAENTREGATAREA FROM TAREA t JOIN MATERIA m ON t.MATERIA_IDMATERIA = m.IDMATERIA WHERE m.USUARIO_EMAILUSR=? AND m.NOMBREMATERIA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%"+nombreMateria+"%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				TareaVO tar = new TareaVO();
				tar.setId(rs.getInt("IDTAREA"));
				tar.setTitulo(rs.getString("TITULOTAREA"));
				tar.setDescripcion(rs.getString("DESCRIPCIONTAREA"));
				tar.setFechaEntrega(rs.getDate("FECHAENTREGATAREA"));
				listaTareas.add(tar);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTareas;
	}
	
	
}
