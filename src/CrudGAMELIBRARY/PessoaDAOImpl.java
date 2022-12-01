package CrudGAMELIBRARY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class  PessoaDAOImpl implements PessoaDAO {
	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/cadastro";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "alunofatec";
	private Connection con = null;
	
	PessoaDAOImpl(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar (Pessoa p) {
		
		String sql = "INSERT INTO Pessoa (Id, nome, Endereco, telefone, Cpf)";
		sql += " VALUES ('" + p.getId() + "', ";
		sql += " '" + p.getNome() + "',";
		sql += " '" + p.getEndereco() + "',";
		sql += " '" + p.getTelefone() + "',";
		sql += " '" + p.getCpf() + "',";
	
	
		
		System.out.println("Query preparada: " + sql);
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso");
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Pessoa> listar(String nome) {
	
			String sql = "SELECT * FROM Pessoa";
			List<Pessoa> pessoas = new ArrayList<>();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	Pessoa p = new Pessoa();
	            	p.setId(rs.getString("Id"));
	            	p.setNome(rs.getString("Nome"));
	          
	            	p.setEndereco(rs.getString("Endereco"));
	            	p.setTelefone(rs.getString("Telefone"));
	            	p.setCpf(rs.getString("Cpf"));
	            	
	                pessoas.add(p);
	 	
	            }
					}catch (SQLException e) {
							e.printStackTrace();
	        }
		return pessoas;
	}
	public void excluir(Pessoa p) {
	
		String sql = "DELETE FROM Pessoa where Id = ";
		sql += " '" + p.getId() + "' ";
		System.out.println("Query preparada: " + sql);
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deseja Mesmo Excluir ?");
		} catch (SQLException e) {
            e.printStackTrace();
        }
}
}