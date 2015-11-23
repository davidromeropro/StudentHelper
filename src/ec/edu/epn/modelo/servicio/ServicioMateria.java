package ec.edu.epn.modelo.servicio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.epn.modelo.vo.MateriaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

public class ServicioMateria {

	InformacionConexionBDD ic = new InformacionConexionBDD();

	public MateriaVO buscarMateria(int idMateria) {
		MateriaVO mat = new MateriaVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("Select * from MATERIA where IDMATERIA=?");
			st.setInt(1, idMateria);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				mat.setId(rs.getInt("IDMATERIA"));
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				mat.setUsuarioEmail(rs.getString("USUARIO_EMAILUSR"));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

	public void registrarMateria(MateriaVO mat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"Insert into MATERIA (NOMBREMATERIA,PROFESORMATERIA, AULAMATERIA, USUARIO_EMAILUSR) values (?,?,?,?)");
			st.setString(1, mat.getNombre());
			st.setString(2, mat.getProfesor());
			st.setString(3, mat.getAula());
			st.setString(4, mat.getUsuarioEmail());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MateriaVO> listarMateriasAllByUsr(UsuarioVO usr) {
		List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT IDMATERIA, NOMBREMATERIA, PROFESORMATERIA, AULAMATERIA FROM MATERIA WHERE USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				MateriaVO mat = new MateriaVO();
				mat.setId(rs.getInt("IDMATERIA"));
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				listaMaterias.add(mat);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}
	
	public List<MateriaVO> listarMateriasLikeMat(String nombreMateria) {
		List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT IDMATERIA, NOMBREMATERIA, PROFESORMATERIA, AULAMATERIA FROM MATERIA WHERE NOMBREMATERIA LIKE ?");
			st.setString(1, "%"+nombreMateria+"%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				MateriaVO mat = new MateriaVO();
				mat.setId(rs.getInt("IDMATERIA"));
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				listaMaterias.add(mat);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}
	
	public List<MateriaVO> listarMateriasLikeMatByUsr(String nombreMateria, UsuarioVO usr) {
		List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT IDMATERIA, NOMBREMATERIA, PROFESORMATERIA, AULAMATERIA FROM MATERIA WHERE USUARIO_EMAILUSR=? AND NOMBREMATERIA LIKE ?");
			st.setString(1, usr.getEmail());
			st.setString(2, "%"+nombreMateria+"%");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				MateriaVO mat = new MateriaVO();
				mat.setId(rs.getInt("IDMATERIA"));
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				listaMaterias.add(mat);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}
	
	public List<MateriaVO> listarMateriasAll() {
		List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT IDMATERIA, NOMBREMATERIA, PROFESORMATERIA, AULAMATERIA FROM MATERIA");
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				MateriaVO mat = new MateriaVO();
				mat.setId(rs.getInt("IDMATERIA"));
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				listaMaterias.add(mat);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaMaterias;
	}

	public void modificarMateria(MateriaVO matInicio, MateriaVO matFin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"UPDATE MATERIA SET NOMBREMATERIA=?,PROFESORMATERIA=?, AULAMATERIA=? WHERE IDMATERIA=?");
			st.setString(1, matFin.getNombre());
			st.setString(2, matFin.getProfesor());
			st.setString(3, matFin.getAula());
			st.setInt(4, matInicio.getId());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eliminarMateria(MateriaVO mat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("delete from MATERIA where IDMATERIA=?");
			st.setInt(1, mat.getId());
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
