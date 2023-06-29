package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Tarefa;
import dao.TarefaDao;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/registerTarefa")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TarefaDao tarefaDao = new TarefaDao();
	Tarefa tarefa = new Tarefa();
	String nome_usuario;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id_usuario");
		int id_usuario = Integer.valueOf(paramId);
		
		nome_usuario = request.getParameter("nome_usuario");
		
		System.out.println(id_usuario);
		
		tarefa.setId_usuario(id_usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cadastroTarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String status = request.getParameter("status");
		
		boolean tarefaCadastrada = true;
    	boolean tarefaAlterada = false;
		
		tarefa.setTitulo(titulo);
		tarefa.setDescricao(descricao);
		
		if(status == null) {
			tarefa.setStatus(false);
		} else {
			tarefa.setStatus(true);
		}
		
		try {
			tarefaDao.registerTarefa(tarefa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generasted catch block
			e.printStackTrace();
		}
		
		request.setAttribute("id_usuario", tarefa.getId_usuario());
		request.setAttribute("tarefaCadastrada", tarefaCadastrada);
		request.setAttribute("tarefaAlterada", tarefaAlterada);
		request.setAttribute("nome_usuario", nome_usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/tarefaListagem");
		dispatcher.forward(request, response);
	}

}
