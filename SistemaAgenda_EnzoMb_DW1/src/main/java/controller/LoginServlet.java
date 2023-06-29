package controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import dao.UsuarioDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/Login", "/"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDao userDao = new UsuarioDao();
	boolean primeiraExecucao;
	boolean verificaLogin;
	boolean userSucesso;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		verificaLogin = false;
		primeiraExecucao = true;
		userSucesso = false;
		
		request.setAttribute("verificaLogin", verificaLogin);
		request.setAttribute("primeiraExecucao", primeiraExecucao);
		request.setAttribute("userSucesso", userSucesso);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("usuario");
        String password = request.getParameter("senha");
        
        Usuario user = null;
        primeiraExecucao = false;
        userSucesso = false;
        
        try {
        	String usuario = userDao.VerificaSenha(username);
        	if(usuario != null) {
			if(checkPassword(password, usuario)) {
			try {
			    user = userDao.LoginUsuario(username);
			} catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			}
			}
        	}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(user != null) {
        	//Pendurando os parametros recebidos para o JSP
        	boolean tarefaCadastrada = false;
        	boolean tarefaAlterada = false;
            request.setAttribute("id_usuario", user.getId());
            request.setAttribute("nome_usuario", user.getNome());
            verificaLogin = true;
            request.setAttribute("verificaLogin", verificaLogin);
    		request.setAttribute("primeiraExecucao", primeiraExecucao);
    		request.setAttribute("tarefaCadastrada", tarefaCadastrada);
    		request.setAttribute("tarefaAlterada", tarefaAlterada);
    		
            RequestDispatcher dispatcher = request.getRequestDispatcher("/tarefaListagem");
    		dispatcher.forward(request, response);
        } else {
        	System.out.println("Usuario ou senha incorretos!!");
        	verificaLogin = false;
        	request.setAttribute("verificaLogin", verificaLogin);
    		request.setAttribute("primeiraExecucao", primeiraExecucao);
    		request.setAttribute("userSucesso", userSucesso);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
    		dispatcher.forward(request, response);
        }
        
	}

}
