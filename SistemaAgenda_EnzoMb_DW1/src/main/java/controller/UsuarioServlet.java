package controller;

import java.io.IOException;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/registerUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    UsuarioDao usuarioDao = new UsuarioDao();
    boolean modal;
	
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modal = false;
		request.setAttribute("modal", modal);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cadastroUsuario.jsp");
		dispatcher.forward(request, response);
	}
	
	public static String encryptPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        
        String hashedPassword = encryptPassword(senha);

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(hashedPassword);
        usuario.setEmail(email);
        
        try {
        	if(usuarioDao.VerificaUsername(login)) {
        		usuarioDao.registerEmployee(usuario);
        		
        		boolean primeiraExecucao = false;
            	boolean verificaLogin = true;
            	boolean userSucesso = true;
                
                request.setAttribute("verificaLogin", verificaLogin);
        		request.setAttribute("primeiraExecucao", primeiraExecucao);
        		request.setAttribute("userSucesso", userSucesso);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
        		dispatcher.forward(request, response);
        	} else {
        		modal = true;
        		
        		request.setAttribute("modal", modal);
        		
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cadastroUsuario.jsp");
        		dispatcher.forward(request, response);
        	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
