package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Tarefa;
import model.Usuario;

public class TarefaDao {
	
	private int chaveSequencial = 0;
	
	public Tarefa buscaTarefaIdTarefa(int id) throws ClassNotFoundException {
		String SELECT_TAREFA = "SELECT id_tarefa, titulo, descricao, data_criacao, data_conclusao, status, id_usuario FROM tarefas" +
								" WHERE id_tarefa=?;";
		
		Tarefa tarefa = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
		    .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
		
		    // Step 2:Create a statement using connection object
		    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAREFA)) {
		    preparedStatement.setInt(1, id);
		
		    System.out.println(preparedStatement);
		    // Step 3: Execute the query or update query
		    try (ResultSet resultSet = preparedStatement.executeQuery();) {
		    	if (resultSet.next()) {
		    		tarefa = new Tarefa();
		    		tarefa.setId_tarefa(resultSet.getInt("id_tarefa"));
		    		tarefa.setTitulo(resultSet.getString("titulo"));
		    		tarefa.setDescricao(resultSet.getString("descricao"));
		    		tarefa.setData_criacao(resultSet.getDate("data_criacao"));
		    		tarefa.setData_conclusao(resultSet.getDate("data_conclusao"));
		    		tarefa.setStatus(resultSet.getBoolean("status"));
		    		tarefa.setId_usuario(resultSet.getInt("id_usuario"));
		    	}
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
		
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		return tarefa;
	}

	public List<Tarefa> buscaTarefaIdUsuario(int id) throws ClassNotFoundException {
		String SELECT_TAREFA = "SELECT id_tarefa, titulo, descricao, data_criacao, data_conclusao, status, id_usuario FROM tarefas" +
								" WHERE id_usuario=?;";
		List<Tarefa> tarefas = null;
		Tarefa tarefa = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
		    .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
		
		    // Step 2:Create a statement using connection object
		    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAREFA)) {
		    preparedStatement.setInt(1, id);
		
		    System.out.println(preparedStatement);
		    // Step 3: Execute the query or update query
		    try (ResultSet resultSet = preparedStatement.executeQuery();) {
		    	tarefas = new ArrayList<>();
		    	while (resultSet.next()) {
		    		tarefa = new Tarefa();
		    		tarefa.setId_tarefa(resultSet.getInt("id_tarefa"));
		    		tarefa.setTitulo(resultSet.getString("titulo"));
		    		tarefa.setDescricao(resultSet.getString("descricao"));
		    		tarefa.setData_criacao(resultSet.getDate("data_criacao"));
		    		tarefa.setData_conclusao(resultSet.getDate("data_conclusao"));
		    		tarefa.setStatus(resultSet.getBoolean("status"));
		    		tarefa.setId_usuario(resultSet.getInt("id_usuario"));
		    		tarefas.add(tarefa);
		    	}
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
		
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		return tarefas;
	}
	
	public int alterarTarefa(Tarefa tarefa) throws ClassNotFoundException {
		
		String UPDATE_TAREFA = "UPDATE tarefas SET titulo=?, descricao=?, data_conclusao=?, status=?" +
				" WHERE id_tarefa = ?;";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		int result = 0;
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TAREFA)) {
				preparedStatement.setString(1, tarefa.getTitulo());
				preparedStatement.setString(2, tarefa.getDescricao());
				System.out.println(tarefa.isStatus());
				if(tarefa.isStatus()) {
	            	preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
	            } else {
	            	preparedStatement.setDate(3, null);
	            }
				preparedStatement.setBoolean(4, tarefa.isStatus());
				preparedStatement.setInt(5, tarefa.getId_tarefa());
				
				System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	}
	
	public int registerTarefa(Tarefa tarefa) throws ClassNotFoundException {
		
		String SELECT_TAREFA = "SELECT max(id_tarefa) FROM tarefas";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			try (Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
			
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAREFA)) {
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
			if (resultSet.next()) {
				chaveSequencial = resultSet.getInt("max(id_tarefa)");
				chaveSequencial++;
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
			}
		
        String INSERT_TAREFAS_SQL = "INSERT INTO tarefas" +
            "  (id_tarefa, titulo, descricao, data_criacao, data_conclusao, status, id_usuario) VALUES " +
            " (?,?,?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAREFAS_SQL)) {
            preparedStatement.setInt(1, chaveSequencial);
            preparedStatement.setString(2, tarefa.getTitulo());
            preparedStatement.setString(3, tarefa.getDescricao());
            preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
            if(tarefa.isStatus()) {
            	preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
            } else {
            	preparedStatement.setDate(5, null);
            }
            preparedStatement.setBoolean(6, tarefa.isStatus());
            preparedStatement.setInt(7, tarefa.getId_usuario());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }

	public int removeTarefa(int id_tarefa) throws ClassNotFoundException {
		String REMOVE_TAREFA = "DELETE FROM tarefas" +
				" WHERE id_tarefa=?;";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_TAREFA)) {
				preparedStatement.setInt(1, id_tarefa);
				
				System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
	}

}
