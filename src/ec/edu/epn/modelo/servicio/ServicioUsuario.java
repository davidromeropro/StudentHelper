package ec.edu.epn.modelo.servicio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.epn.modelo.vo.UsuarioVO;

public class ServicioUsuario {
	
	InformacionConexionBDD ic = new InformacionConexionBDD();

	public UsuarioVO buscarUsuario(String email) {
		UsuarioVO usr = new UsuarioVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("Select * from USUARIO where EMAILUSR=? and ESTADOUSR=?");
			st.setString(1, email);
			st.setBoolean(2, true);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				usr.setNombre(rs.getString("NOMBREUSR"));
				usr.setEmail(rs.getString("EMAILUSR"));
				usr.setPassword(rs.getString("PASSWORDUSR"));
				usr.setApellido(rs.getString("APELLIDOUSR"));
				usr.setEstado(rs.getBoolean("ESTADOUSR"));
				usr.setAdministrador(rs.getBoolean("ADMINISTRADORUSR"));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;
	}

	public void registrarUsuario(UsuarioVO usr) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"Insert into USUARIO (EMAILUSR,PASSWORDUSR, NOMBREUSR, APELLIDOUSR, ESTADOUSR, ADMINISTRADORUSR) values (?,?,?,?,?,?) ");
			st.setString(1, usr.getEmail());
			st.setString(2, usr.getPassword());
			st.setString(3, usr.getNombre());
			st.setString(4, usr.getApellido());
			st.setBoolean(5, true);
			st.setBoolean(6, false);
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<UsuarioVO> listarUsuariosAll() {
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = null;
			st = con.prepareStatement("Select * from USUARIO");
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				UsuarioVO usr = new UsuarioVO();
				usr.setNombre(rs.getString("NOMBREUSR"));
				usr.setEmail(rs.getString("EMAILUSR"));
				usr.setPassword(rs.getString("PASSWORDUSR"));
				usr.setApellido(rs.getString("APELLIDOUSR"));
				usr.setAdministrador(rs.getBoolean("ADMINISTRADORUSR"));
				usr.setEstado(rs.getBoolean("ESTADOUSR"));
				listaUsuarios.add(usr);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}

	public List<UsuarioVO> listarUsuariosByMail(String emailUsuario) {
		List<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = null;
			st = con.prepareStatement("Select * from USUARIO where EMAILUSR LIKE ?");
			st.setString(1, "%" + emailUsuario + "%");			
			st.execute();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				UsuarioVO usr = new UsuarioVO();
				usr.setNombre(rs.getString("NOMBREUSR"));
				usr.setEmail(rs.getString("EMAILUSR"));
				usr.setPassword(rs.getString("PASSWORDUSR"));
				usr.setApellido(rs.getString("APELLIDOUSR"));
				usr.setAdministrador(rs.getBoolean("ADMINISTRADORUSR"));
				usr.setEstado(rs.getBoolean("ESTADOUSR"));
				listaUsuarios.add(usr);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	public void modificarUsuario(UsuarioVO usrInicio, UsuarioVO usrFin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"UPDATE USUARIO PASSWORDUSR=?, NOMBREUSR=?, APELLIDOUSR=? WHERE EMAILUSR=?");
			st.setString(1, usrFin.getPassword());
			st.setString(2, usrFin.getNombre());
			st.setString(3, usrFin.getApellido());
			st.setString(4, usrInicio.getEmail());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void darDeBajaUsuario(UsuarioVO usr) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"UPDATE USUARIO SET ESTADOUSR=? WHERE EMAILUSR=?");
			st.setBoolean(1, false);
			st.setString(2, usr.getEmail());
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void eliminarUsuario(UsuarioVO usr) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("delete from USUARIO where EMAILUSR=?");
			st.setString(1, usr.getEmail());
			st.execute();
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UsuarioVO buscarUsuarioByEmail(String email) {
		UsuarioVO usr = new UsuarioVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con
					.prepareStatement("Select * from USUARIO where EMAILUSR=?");
			st.setString(1, email);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				usr.setNombre(rs.getString("NOMBREUSR"));
				usr.setEmail(rs.getString("EMAILUSR"));
				usr.setPassword(rs.getString("PASSWORDUSR"));
				usr.setApellido(rs.getString("APELLIDOUSR"));
				usr.setAdministrador(rs.getBoolean("ADMINISTRADORUSR"));
				usr.setEstado(rs.getBoolean("ESTADOUSR"));
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usr;
	}

}
