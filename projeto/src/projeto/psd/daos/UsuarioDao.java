package projeto.psd.daos;

import projeto.psd.factorys.ConFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.psd.entidades.Usuario;
import projeto.psd.interfaces.UsuarioDaoIf;

public class UsuarioDao implements UsuarioDaoIf {

    private String url;
    private String user;
    private String password;
    private Connection con;

    public UsuarioDao() throws ClassNotFoundException, SQLException {

        this.url = "jdbc:postgresql://localhost:5432/threadlove";
        this.user = "postgres";
        this.password = "123";
        this.con = ConFactory.getConnection(url, user, password);

    }

    @Override
    public boolean add(Usuario u) throws SQLException {

        String sql = "INSERT INTO usuario VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.setString(2, u.getLogin());
        stmt.setString(3, u.getSenha());
        stmt.setString(4, u.getNome());
        stmt.setString(5, u.getApelido());
        stmt.setString(6, u.getDataDeNascimento());
        stmt.setString(7, u.getCidade());
        stmt.setString(8, u.getEmail());
        stmt.setString(9, u.getProfissao());
        stmt.setString(10, u.getDescricao());
        stmt.setString(11, u.getStatus());
        stmt.setDouble(12, u.getAltura());
        stmt.setDouble(13, u.getPeso());
        stmt.setString(14, u.getCorDoCabelo());
        stmt.setString(15, u.getPassatempos());
        stmt.executeUpdate();
        int vrf = stmt.executeUpdate();
        stmt.close();

        return vrf > 0;
    }

    @Override
    public boolean remove(String login, String senha) throws SQLException {

        String sql = "DELETE FROM usuario WHERE login = '" + login
                + "' AND senha = '" + senha + "'";
        PreparedStatement stmt;

        stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;

    }

    @Override
    public boolean update(Usuario u) throws SQLException {

        String sql = "UPDATE usuario SET id = ?, login = ?, senha = ?, nome = ?, "
                + "apelido = ?, dataDeNascimento = ?, cidade = ?, email = ?, "
                + "profissao = ?, descricao = ?, status = ?, altura = ?, peso = ?, "
                + "corDoCabelo = ?, passaTempo = ? WHERE id = ?";
        PreparedStatement stmt;

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.setString(2, u.getLogin());
        stmt.setString(3, u.getSenha());
        stmt.setString(4, u.getNome());
        stmt.setString(5, u.getApelido());
        stmt.setString(6, u.getDataDeNascimento());
        stmt.setString(7, u.getCidade());
        stmt.setString(8, u.getEmail());
        stmt.setString(9, u.getProfissao());
        stmt.setString(10, u.getDescricao());
        stmt.setString(11, u.getStatus());
        stmt.setDouble(12, u.getAltura());
        stmt.setDouble(13, u.getPeso());
        stmt.setString(14, u.getCorDoCabelo());
        stmt.setString(15, u.getPassatempos());
        stmt.setInt(16, u.getId());
        stmt.executeUpdate();
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;

    }

    @Override
    public List<Usuario> listAll() throws SQLException {

        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt;
        List<Usuario> lista = new ArrayList<>();

        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
//              u.setId(rs.getInt(1)); id setado automaticamente
            u.setLogin(rs.getString(2));
            u.setSenha(rs.getString(3));
            u.setLogin(rs.getString(4));
            u.setNome(rs.getString(5));
            u.setApelido(rs.getString(6));
            u.setDataDeNascimento(rs.getString(7));
            u.setCidade(rs.getString(8));
            u.setEmail(rs.getString(9));
            u.setProfissao(rs.getString(10));
            u.setDescricao(rs.getString(11));
            u.setStatus(rs.getString(12));
            u.setAltura(rs.getDouble(13));
            u.setPeso(rs.getDouble(14));
            u.setCorDoCabelo(rs.getString(15));
            u.setPassatempos(rs.getString(16));
            lista.add(u);
        }
        stmt.close();
        rs.close();
        return lista;

    }

}
