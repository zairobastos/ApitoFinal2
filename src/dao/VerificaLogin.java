package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class VerificaLogin {
    
    Connection conn  = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Conexao conexaoBanco = new Conexao();

    public VerificaLogin(){

    }

    public boolean verificaLogin(String email, String senha){
        conn = conexaoBanco.getConnection();
        String SQL = "SELECT * FROM usuario WHERE email_user = ? AND senha_user = ?";

        try{
            pst = (PreparedStatement)conn.prepareStatement(SQL);

                pst.setString(1, email);
                pst.setString(2, senha);

            rs = pst.executeQuery();
            if(rs.next()){
                conexaoBanco.closeConexao();
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos" );
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
}
