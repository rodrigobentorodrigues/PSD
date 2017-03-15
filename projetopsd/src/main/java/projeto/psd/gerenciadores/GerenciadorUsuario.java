
package projeto.psd.gerenciadores;

import java.sql.SQLException;
import java.util.List;
import projeto.psd.entidades.Usuario;
import projeto.psd.factorys.DaoFactory;
import projeto.psd.interfaces.DaoFactoryIf;
import projeto.psd.interfaces.UsuarioDaoIf;

public class GerenciadorUsuario{

    public GerenciadorUsuario(){};
    
    public boolean add(String login, String senha, String nome, String apelido, String dataDeNascimento, String cidade, String email,
        String profissao, String descricao, String status, double altura, double peso, String corDoCabelo, String passatempos, 
        String fotoPerfil) throws ClassNotFoundException, SQLException{
        
        Usuario usu = new Usuario(login, senha, nome, apelido, dataDeNascimento, 
                cidade, email, profissao, descricao, status, altura, peso, 
                corDoCabelo, passatempos, fotoPerfil);
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.add(usu);
        
    }
    
    public boolean update(String login, String senha, String nome, String apelido, String dataDeNascimento, String cidade, String email,
        String profissao, String descricao, String status, double altura, double peso, String corDoCabelo, String passatempos, 
        String fotoPerfil) throws ClassNotFoundException, SQLException{
        
        Usuario usu = new Usuario(login, senha, nome, apelido, dataDeNascimento, 
                cidade, email, profissao, descricao, status, altura, peso, 
                corDoCabelo, passatempos, fotoPerfil);
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.update(usu);
        
    }
    
    public boolean remove(String login, String senha) throws ClassNotFoundException, SQLException{
       
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.remove(login, senha);
        
    }
    
    public List<Usuario> listAll() throws ClassNotFoundException, SQLException{
        
        DaoFactory fabricaDao = new DaoFactory();
        DaoFactoryIf fabricaBd = fabricaDao.getDaoFactory();
        UsuarioDaoIf cad = fabricaBd.criaDaoUsuario();
        return cad.listAll();
        
    }
    
}