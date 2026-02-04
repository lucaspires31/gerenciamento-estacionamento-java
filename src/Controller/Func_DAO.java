/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.Func_DAO;
import View.ConsultarFunc_GUI;
import static View.ConsultarFunc_GUI.cod11_txt;
import static View.ConsultarFunc_GUI.email4_txt;
import static View.ConsultarFunc_GUI.img5;
import static View.ConsultarFunc_GUI.nom112_txt;
import static View.ConsultarFunc_GUI.senha4_txt;
import static View.ConsultarFunc_GUI.tipo5_txt;
import View.Criar_GUI;
import static View.Criar_GUI.criar_txt;
import static View.Criar_GUI.email3_txt;
import static View.Criar_GUI.img12;
import static View.Criar_GUI.senha2_txt;
import static View.Criar_GUI.tip2_txt;
import View.ExcluirFunc_GUI;
import static View.ExcluirFunc_GUI.cod12_txt;
import static View.Inicio_GUI.email2_txt;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Func_DAO {
    
    static int cod;
 static String tipo;
 static String email;
 static String senha;
  static String criar;
   static String nome;
  


    
public static String url2 = "jdbc:mysql://localhost:3306/aprender"
        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

  static String username = "root";        //nome de um usuário de seu BD
  static String password = "";  // senha do BD

    
    public static void cadastrar(){
        //INICIO---------------->
        
        
tipo = tip2_txt.getText(); 
email= email3_txt.getText(); 
senha = senha2_txt.getText();
criar = criar_txt.getText();



Model.Conecta_DB.carregaDriver();

       
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url2, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Criar_GUI.class.getName()).log(Level.SEVERE, null, ex);
    
    

            
                   }
    
    String caminhoCorrigido = Imagem_DAO.caminhoImagem.replace("\\", "\\\\");

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO func(cli_nome, cli_email, cli_senha, cli_tipo, foto_path ) values('"+criar+"','"+email+"','"+senha+"','"+tipo+"','"+caminhoCorrigido+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                tip2_txt.setText("");
                email3_txt.setText("");
                senha2_txt.setText("");
                criar_txt.setText("");
                






               
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            senha2_txt.setText("");
        }
      }
    
    
    
    public static void consultar(){
        //--Inicio
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            int codigo = Integer.valueOf(cod11_txt.getText());
            

         Model.Conecta_DB.carregaDriver(); // Carregando o driver
              
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url2, username, password);
                } catch (Exception ex) {
                    Logger.getLogger(ConsultarFunc_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT cli_nome,cli_email, cli_senha, cli_tipo, foto_path  FROM func where func_id = "+codigo;
                
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome = rs.getString("cli_nome");
                        String tipo = rs.getString("cli_tipo");
                        String email = rs.getString("cli_email");
                        String senha =  rs.getString("cli_senha");
                        String foto = rs.getString("foto_path");
                        
                        
                        if (foto != null && !foto.isEmpty()) {
                         try {
                        ImageIcon icon = new ImageIcon(foto);
                        Image imgEscalada = icon.getImage().getScaledInstance(
                        img5.getWidth(),
                        img5.getHeight(),
                        Image.SCALE_SMOOTH
                        );

                        img5.setIcon(new ImageIcon(imgEscalada));
                        img5.repaint(); // 🔥 força atualização da imagem
                        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: " + e.getMessage());
                        }
                        } else {
                         img5.setIcon(null);
                        img5.repaint();
                        }

                        
                        

                        i++;

                         tipo5_txt.setText(String.valueOf(tipo));
                         email4_txt.setText(String.valueOf(email));
                         senha4_txt.setText(String.valueOf(senha));
                         nom112_txt.setText(String.valueOf(nome));
                         

                    }

                    if(i==0){ // Verificando se ha dados cadastrados atraves da variavel i

                        JOptionPane.showMessageDialog(null,"Dado não cadastrado","Resultado",-1);

                    }

                } catch (Exception ex) { // Consulta mal sucedida
                    JOptionPane.showMessageDialog(null,"\nErro ao consultar!","ERRO",0);
                }

            } catch (SQLException ex) {
                // Conexão com servidor mal sucedida
                JOptionPane.showMessageDialog(null,"Erro ao conectar com o servidor","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Código fora do formato
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod11_txt.setText("");
        }
        
    }
    
    
    
    public static void alterar(){
        //---inicio  
      tipo = tipo5_txt.getText(); 
      email= email4_txt.getText(); 
      senha = senha4_txt.getText();
      nome = nom112_txt.getText();

       Model.Conecta_DB.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url2, username, password);
      }catch (Exception ex) {
            Logger.getLogger(ConsultarFunc_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE func SET cli_tipo='"+tipo+"', cli_email='"+email+"',cli_senha='"+senha+"', cli_nome='"+nome+"'  WHERE func_id="+cod11_txt.getText();
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                cod11_txt.setText("");
                tipo5_txt.setText("");
                email4_txt.setText("");
                senha4_txt.setText("");
                nom112_txt.setText("");
                


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            senha4_txt.setText("");
        }    

        
        
       //-- Fim     

        
        
       
    }
    
    
    
    public static void excluir(){
     //---Inicio
         
         
        Model.Conecta_DB.carregaDriver();
            try {// Tratamento de erro para a conexao
            // Declarando  a variavel de conexão con
            // e estabelendo a conexão
            Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url2, username, password);
                } catch (Exception ex) {
                    Logger.getLogger(ExcluirFunc_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM func WHERE func_id = "+cod12_txt.getText();

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod12_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod12_txt.setText("");

        }

        
    //---Fim    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
