package projeto.psd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import projeto.psd.entidades.Usuario;
import projeto.psd.gerenciadores.GerenciadorUsuario;

public class Buscador extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        String nome = req.getParameter("busca");
        List<Usuario> lista = null;
        
        GerenciadorUsuario gu = new GerenciadorUsuario();
        HttpSession session = req.getSession(false);
        
        try {
            
            lista = gu.read(nome);
        } catch (ClassNotFoundException ex) {
            //redirecionar para pagina de erro
        } catch (SQLException ex) {
            //redirecionar para pagina de erro
        }
        
        synchronized(session){
            session.setAttribute("encontrados", lista);
        }
        
        //String url = resp.encodeRedirectURL("Encontrados.jsp");
        //resp.sendRedirect(url);
    }
    
}
        
