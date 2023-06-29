package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TarefaDao;

/**
 * Servlet implementation class RemoveTarefaServlet
 */
@WebServlet("/removeTarefa")
public class RemoveTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId_tarefa = request.getParameter("id_tarefa");
		int id_tarefa = Integer.valueOf(paramId_tarefa);
		
		String paramId_usuario = request.getParameter("id_usuario");
		int id_usuario = Integer.valueOf(paramId_usuario);
		
		String nome_usuario = request.getParameter("nome_usuario");
		
		System.out.println(id_tarefa);
		
		TarefaDao tarefaDao = new TarefaDao();
		
		try {
			tarefaDao.removeTarefa(id_tarefa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean tarefaCadastrada = false;
    	boolean tarefaAlterada = false;
		
		request.setAttribute("id_usuario", id_usuario);
		request.setAttribute("tarefaCadastrada", tarefaCadastrada);
		request.setAttribute("tarefaAlterada", tarefaAlterada);
		request.setAttribute("nome_usuario", nome_usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/tarefaListagem");
		dispatcher.forward(request, response);
	}

}
