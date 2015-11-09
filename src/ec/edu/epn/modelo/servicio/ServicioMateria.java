package ec.edu.epn.modelo.servicio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.epn.modelo.vo.InformacionConexionBDD;
import ec.edu.epn.modelo.vo.MateriaVO;
import ec.edu.epn.modelo.vo.UsuarioVO;

public class ServicioMateria {

	InformacionConexionBDD ic = new InformacionConexionBDD();

	public MateriaVO buscarMateria(String nombre, UsuarioVO usuario) {
		MateriaVO mat = new MateriaVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());

			PreparedStatement st = con
					.prepareStatement("Select * from MATERIA where NOMBREMATERIA=? and USUARIO_EMAILUSR=?");
			st.setString(1, nombre);
			st.setString(2, usuario.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				mat.setNombre(rs.getString("NOMBREMATERIA"));
				mat.setProfesor(rs.getString("PROFESORMATERIA"));
				mat.setAula(rs.getString("AULAMATERIA"));
				//mat.setUsuario(rs.getString("USUARIO_EMAILUSR"));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mat;
	}

	public void registrarMateria(MateriaVO mat, UsuarioVO usr) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"Insert into MATERIA (NOMBREMATERIA,PROFESORMATERIA, AULAMATERIA, USUARIO_EMAILUSR) values (?,?,?,?)");
			st.setString(1, mat.getNombre());
			st.setString(2, mat.getProfesor());
			st.setString(3, mat.getAula());
			st.setString(4, usr.getEmail());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MateriaVO> listarUsuario(UsuarioVO usr) {
		List<MateriaVO> listaMaterias = new ArrayList<MateriaVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement("SELECT NOMBREMATERIA, PROFESORMATERIA, AULAMATERIA FROM MATERIA WHERE USUARIO_EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				MateriaVO mat = new MateriaVO();
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
					"UPDATE MATERIA SET NOMBREMATERIA=?,PROFESORMATERIA=?, AULAMATERIA=? WHERE NOMBREMATERIA=?");
			st.setString(1, matFin.getNombre());
			st.setString(2, matFin.getProfesor());
			st.setString(3, matFin.getAula());
			st.setString(5, matInicio.getNombre());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void eliminarUsuario(MateriaVO mat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("delete from MATERIA where NOMBREMATERIA=?");
			st.setString(1, mat.getNombre());
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
