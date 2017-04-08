package projeto.psd.daos;

import projeto.psd.factorys.ConFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getNome());
        stmt.setString(4, u.getApelido());
        stmt.setString(5, u.getDataDeNascimento());
        stmt.setString(6, u.getCidade());
        stmt.setString(7, u.getEmail());
        stmt.setString(8, u.getProfissao());
        stmt.setString(9, u.getDescricao());
        stmt.setString(10, u.getStatus());
        stmt.setDouble(11, u.getAltura());
        stmt.setDouble(12, u.getPeso());
        stmt.setString(13, u.getCorDoCabelo());
        stmt.setString(14, u.getPassatempos());
        stmt.setString(15, u.getFotoPerfil());
        int vrf = stmt.executeUpdate();
        stmt.close();

        return vrf > 0;
    }

    @Override
    public List<Usuario> read(String nome) throws SQLException {
        String sql = "SELECT * FROM usuario where nome = ?";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nome);
        
        List<Usuario> lista = new ArrayList<Usuario>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setLogin(rs.getString(1));
            u.setSenha(rs.getString(2));
            u.setNome(rs.getString(3));
            u.setApelido(rs.getString(4));
            u.setDataDeNascimento(rs.getString(5));
            u.setCidade(rs.getString(6));
            u.setEmail(rs.getString(7));
            u.setProfissao(rs.getString(8));
            u.setDescricao(rs.getString(9));
            u.setStatus(rs.getString(10));
            u.setAltura(rs.getDouble(11));
            u.setPeso(rs.getDouble(12));
            u.setCorDoCabelo(rs.getString(13));
            u.setPassatempos(rs.getString(14));
            u.setFotoPerfil(rs.getString(15));
            lista.add(u);
        }
        stmt.close();
        rs.close();
        return lista;
    }

    @Override
    public boolean remove(String login, String senha) throws SQLException {

        String sql = "DELETE FROM usuario WHERE login = '" + login
                + "' AND senha = '" + senha + "'";
        PreparedStatement stmt;

        stmt = con.prepareStatement(sql);
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;

    }

    @Override
    public boolean update(Usuario u) throws SQLException {

        String sql = "UPDATE usuario SET senha = ?, nome = ?, "
                + "apelido = ?, dataDeNascimento = ?, cidade = ?, email = ?, "
                + "profissao = ?, descricao = ?, status = ?, altura = ?, peso = ?, "
                + "cordocabelo = ?, passatempos = ?, fotoperfil = ? WHERE login = ?";
        PreparedStatement stmt;

        stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getSenha());
        stmt.setString(2, u.getNome());
        stmt.setString(3, u.getApelido());
        stmt.setString(4, u.getDataDeNascimento());
        stmt.setString(5, u.getCidade());
        stmt.setString(6, u.getEmail());
        stmt.setString(7, u.getProfissao());
        stmt.setString(8, u.getDescricao());
        stmt.setString(9, u.getStatus());
        stmt.setDouble(10, u.getAltura());
        stmt.setDouble(11, u.getPeso());
        stmt.setString(12, u.getCorDoCabelo());
        stmt.setString(13, u.getPassatempos());
        stmt.setString(14, u.getLogin());
        stmt.setString(15, u.getFotoPerfil());
        int vrf = stmt.executeUpdate();
        stmt.close();
        return vrf > 0;

    }

    @Override
    public List<Usuario> listAll() throws SQLException {

        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt;
        List<Usuario> lista = new ArrayList<Usuario>();

        stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setLogin(rs.getString(1));
            u.setSenha(rs.getString(2));
            u.setNome(rs.getString(3));
            u.setApelido(rs.getString(4));
            u.setDataDeNascimento(rs.getString(5));
            u.setCidade(rs.getString(6));
            u.setEmail(rs.getString(7));
            u.setProfissao(rs.getString(8));
            u.setDescricao(rs.getString(9));
            u.setStatus(rs.getString(10));
            u.setAltura(rs.getDouble(11));
            u.setPeso(rs.getDouble(12));
            u.setCorDoCabelo(rs.getString(13));
            u.setPassatempos(rs.getString(14));
            u.setFotoPerfil(rs.getString(15));
            lista.add(u);
        }
        stmt.close();
        rs.close();
        return lista;

    }

}
