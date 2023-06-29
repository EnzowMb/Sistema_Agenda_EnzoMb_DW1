package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;
import model.Usuario;
import dao.TarefaDao;

/**
 * Servlet implementation class TarefaListagemServlet
 */
@WebServlet("/tarefaListagem")
public class TarefaListagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id_user = (Integer) request.getAttribute("id_usuario");
		
		TarefaDao tarefaDao = new TarefaDao();
		List<Tarefa> tarefas = null;
		
		try {
			tarefas = tarefaDao.buscaTarefaIdUsuario(id_user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		request.setAttribute("tarefas", tarefas);
		request.setAttribute("id_usuario", id_user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mainPage.jsp");
		dispatcher.forward(request, response);
	}

}
