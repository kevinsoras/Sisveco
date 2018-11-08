package pe.edu.upeu.Spring01.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.Spring01.dao.UsuarioDao;
import pe.edu.upeu.Spring01.pojo.Usuario;
@Repository
public class UsuarioDaoImp implements UsuarioDao{
	@Autowired
	private DataSource dataSource;
	private PreparedStatement ps;
	private Connection cx = null;

	@Override
	public int create(Usuario user) throws SQLException {
		int x = 0;
		try {
			cx = dataSource.getConnection();
			ps = cx.prepareStatement("insert into usuario(idusuario, nom_user,clave,estado) values(null,?,?,1)");
			ps.setString(1, user.getNomuser());
			ps.setString(2, user.getClave());
			x = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}finally {
			if(cx!=null) {
				cx.close();
			}
		}
		return x;
	}

	@Override
	public int update(Usuario user) {
		// TODO Auto-generated method stub
		int x =0;
		cx = null;
		try {
			cx = dataSource.getConnection();
			ps = cx.prepareStatement("UPDATE usuario SET clave=? WHERE idusuario=?");
			ps.setString(1, user.getClave());
			ps.setInt(2, user.getIduser());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error: "+e);// TODO: handle exception
		}
		return x;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub

		int x =0;
		cx = null;
		try {
			cx = dataSource.getConnection();
			ps= cx.prepareStatement("Delete from usuario WHERE idusuario=?");
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return x;

	}

	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		cx = null;
		Usuario u = new Usuario();
		try {
			cx = dataSource.getConnection();
			ps= cx.prepareStatement("select *from usuario where idusuario=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			u.setIduser(rs.getInt("idusuario"));
			u.setNomuser(rs.getString("nom_user"));
			u.setClave(rs.getString("clave"));
			u.setEstado(rs.getString("estado"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return u;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		cx = null;
		List<Usuario> lista = new ArrayList<>();
		ResultSet rs;
		try {
			cx = dataSource.getConnection();
			ps = cx.prepareStatement("select *from usuario");
			rs = ps.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setIduser(rs.getInt("idusuario"));
				u.setNomuser(rs.getString("nom_user"));
				u.setClave(rs.getString("clave"));
				u.setEstado(rs.getString("estado"));
				lista.add(u);
			}
		} catch (Exception e) {
			System.out.println("Error1: "+e);
		}
		return lista;
	}

}
