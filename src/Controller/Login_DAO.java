/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.Login_DAO;
import static View.Login_GUI.email10_txt;
import static View.Login_GUI.senha10_txt;
import View.MenuNormal_GUI;
import View.Menu_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;


/**
 *
 * @author lucas
 */
public class Login_DAO {
    
    public static String url2 = "jdbc:mysql://localhost:3306/aprender"
        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

    public static String tipoUsuarioLogado;
    static String username = "root";        //nome de um usuário de seu BD
  static String password = "";  
    
    
   public static void login(View.Login_GUI telainicial) {
    String email = View.Login_GUI.email10_txt.getText();
    String senha = View.Login_GUI.senha10_txt.getText();

    Model.Conecta_DB.carregaDriver();

    try (Connection con = DriverManager.getConnection(url2, username, password)) {
        String sql = "SELECT cli_nome, cli_tipo, foto_path FROM FUNC WHERE cli_email = ? AND cli_senha = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String nome = rs.getString("cli_nome");
            String tipo = rs.getString("cli_tipo");
             tipoUsuarioLogado = tipo;
            String foto = rs.getString("foto_path");

            javax.swing.ImageIcon icon = null;
            if (foto != null && !foto.trim().isEmpty()) {
                try {
                    foto = foto.replace("\\\\", "\\");
                    java.io.File f = new java.io.File(foto);
                    if (f.exists()) {
                        javax.swing.ImageIcon rawIcon = new javax.swing.ImageIcon(foto);
                        java.awt.Image img = rawIcon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
                        icon = new javax.swing.ImageIcon(img);
                    }
                } catch (Exception e) {}
            }

            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Bem-vindo, " + nome + "!",
                "Login realizado com sucesso",
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                icon
            );

            // Abre a tela conforme o tipo
           if (tipo.equalsIgnoreCase("admin")) {
    new View.Menu_GUI("admin").setVisible(true);
} else {
    new View.Menu_GUI("normal").setVisible(true);
}


            // 🔹 Fecha a tela de login
            telainicial.dispose();

        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
    }
}


    
}
