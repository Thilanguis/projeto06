package factories;

import java.sql.Connection;

//https://mvnrepository.com/ Biblioteca para fazer conecção com banco
	
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos
	private static final String HOST = "jdbc:mysql://localhost:3306/bd_aula06?UseTimezone=true&serverTimezone=UTC&useSSL=false"; //ssl= Security soquet layer, true quando o site for online
	private static final String USER = "root";
	private static final String PASS = "1234";
	
	//método para fazer a conexão com o banco de dados
	
	public static Connection getConnection() throws Exception {
		
		return DriverManager.getConnection(HOST, USER, PASS);

	}

}
