package ec.edu.epn.modelo.servicio;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ec.edu.epn.modelo.vo.InformacionConexionBDD;
import ec.edu.epn.modelo.vo.UsuarioVO;

public class ServicioUsuario {
	
	InformacionConexionBDD ic = new InformacionConexionBDD();

	public UsuarioVO buscarUsuario(String email, String password) {
		UsuarioVO usr = new UsuarioVO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());

			PreparedStatement st = con
					.prepareStatement("Select * from USUARIO where EMAILUSR=? and PASSWORDUSR=? and ESTADOUSR=?");
			st.setString(1, email);
			st.setString(2, password);
			st.setBoolean(3, true);
			st.execute();
			ResultSet rs = st.getResultSet();
			while (rs.next()) {
				usr.setNombre(rs.getString("NOMBREUSR"));
				usr.setEmail(rs.getString("EMAILUSR"));
				usr.setPassword(rs.getString("PASSWORDUSR"));
				usr.setApellido(rs.getString("APELLIDOUSR"));
				usr.setEstado(rs.getBoolean("ESTADOUSR"));
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
					"Insert into USUARIO (EMAILUSR,PASSWORDUSR, NOMBREUSR, APELLIDOUSR, ESTADOUSR) values (?,?,?,?,?) ");
			st.setString(1, usr.getEmail());
			st.setString(2, usr.getPassword());
			st.setString(3, usr.getNombre());
			st.setString(4, usr.getApellido());
			st.setBoolean(5, true);
			st.execute();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarUsuario(UsuarioVO usrInicio, UsuarioVO usrFin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(ic.getUrl(), ic.getUsuarioDB(), ic.getPasswordDB());
			PreparedStatement st = con.prepareStatement(
					"UPDATE USUARIO SET EMAILUSR=?,PASSWORDUSR=?, NOMBREUSR=?, APELLIDOUSR=? WHERE EMAILUSR=?");
			st.setString(1, usrFin.getEmail());
			st.setString(2, usrFin.getPassword());
			st.setString(3, usrFin.getNombre());
			st.setString(4, usrFin.getApellido());
			st.setString(5, usrInicio.getEmail());
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
			st.setBoolean(1, true);
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

}
