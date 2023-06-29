package controller;

import java.io.IOException;

import dao.TarefaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;

/**
 * Servlet implementation class MostraTarefaServlet
 */
@WebServlet("/mostraTarefa")
public class MostraTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId_tarefa = request.getParameter("id_tarefa");
		int id_tarefa = Integer.valueOf(paramId_tarefa);
		
		String nome_usuario = request.getParameter("nome_usuario");
		
		TarefaDao tarefaDao = new TarefaDao();
		Tarefa tarefa = null;
		
		try {
			tarefa = tarefaDao.buscaTarefaIdTarefa(id_tarefa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(tarefa.getTitulo());
		
		request.setAttribute("nome_usuario", nome_usuario);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/edicaoTarefa.jsp");
		
		request.setAttribute("tarefa", tarefa);

		rd.forward(request, response);
	}

}
