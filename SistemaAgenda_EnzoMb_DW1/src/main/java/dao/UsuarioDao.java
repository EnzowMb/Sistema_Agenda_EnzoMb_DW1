package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioDao {
	
	private boolean passwordMatch = false;
	
	private int chaveSequencial = 0;
	
	public String VerificaSenha(String username) throws ClassNotFoundException {
		
		String SELECT_USER = "SELECT senha FROM usuarios " + "WHERE login=?;";
		
		String senha = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
			    .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
			
			    // Step 2:Create a statement using connection object
			    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
				preparedStatement.setString(1, username);
				
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
		    	while (resultSet.next()) {
		    		senha = resultSet.getString("senha");
		    	}
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		
		return senha;
	}
	
	public Usuario LoginUsuario(String username) throws ClassNotFoundException {
		 String SELECT_LOGIN = "SELECT id_usuario, nome, login, senha, email FROM usuarios " + 
				 				"WHERE login=?;";
		 
		 Usuario user = null;

	     Class.forName("com.mysql.jdbc.Driver");
		 
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN)) {
		            preparedStatement.setString(1, username);

		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            try (ResultSet resultSet = preparedStatement.executeQuery();) {
		            	if (resultSet.next()) {
		            		user = new Usuario();
		            		user.setId(resultSet.getInt("id_usuario"));
		            		user.setNome(resultSet.getString("nome"));
		            		user.setLogin(resultSet.getString("login"));
		            		user.setSenha(resultSet.getString("senha"));
		            		user.setEmail(resultSet.getString("email"));
		            	}
		            }
		            catch (SQLException e) {
		 				e.printStackTrace();
		 			}

		        } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		 return user;
	 }
	
	public int registerEmployee(Usuario usuario) throws ClassNotFoundException {
		
		String SELECT_USUARIO = "SELECT max(id_usuario) FROM usuarios;";
		
		System.out.println("opa");

		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
		
		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIO)) {
		
		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		try (ResultSet resultSet = preparedStatement.executeQuery();) {
		if (resultSet.next()) {
			chaveSequencial = resultSet.getInt("max(id_usuario)");
			System.out.println(chaveSequencial);
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
		
        String INSERT_USERS_SQL = "INSERT INTO usuarios" +
            "  (id_usuario, nome, login, senha, email) VALUES " +
            " (?,?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, chaveSequencial);
            preparedStatement.setString(2, usuario.getNome());
            preparedStatement.setString(3, usuario.getLogin());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.setString(5, usuario.getEmail());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	
	public boolean VerificaUsername(String username) throws ClassNotFoundException {
		
		username.toLowerCase();
		
		boolean verf = false;
		
		String SELECT_USER = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager
			    .getConnection("jdbc:mysql://localhost:3306/tarefas", "root", "root");
			
			    // Step 2:Create a statement using connection object
			    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
				preparedStatement.setString(1, username);
				
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				resultSet.next();
	            int count = resultSet.getInt(1);
	            if (count > 0) {
	                System.out.println("Usuário já existe.");
	                verf = false;
	            } else {
	                System.out.println("Usuário válido.");
	                verf = true;
	            }
		    		
		    }
		    catch (SQLException e) {
					e.printStackTrace();
				}
			
		} catch (SQLException e) {
		    // process sql exception
		    e.printStackTrace();
		}
		
		return verf;
	}

}
