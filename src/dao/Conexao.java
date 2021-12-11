package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String hostname = "localhost";
    private static final int    porta = 3306;
    private static final String database = "apito_final";
    private static final String username = "root";
    private static final String password = "";
    private Connection conexao;

    public Conexao(){
        try {
            String url = "jdbc:mysql://" + hostname + ":" + porta + "/" + database;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexao = DriverManager.getConnection(url, username, password);

            System.out.println("Conexão estabelecida....");
            
        } catch (SQLException ex) {
            System.err.println("ERRO de conexão" + ex.getMessage());
        } catch(Exception ex){
            System.err.println("ERRO genérico" + ex.getMessage());
        }
    }

    /**
     * Método que retorna o estado da conexão com o banco
     * @return conexao
     */
    public Connection getConnection(){
        return this.conexao;
    }

    /**
     * Método que fecha a conexão com o banco de dados
     */
    public void closeConexao(){
        try {
            conexao.close();
        } catch (Exception e) {
            System.err.println("ERRO ao desconectar..." + e.getMessage());
        }
    }
    
}
