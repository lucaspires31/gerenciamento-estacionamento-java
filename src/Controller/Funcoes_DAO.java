
package Controller;

import View.Inicio_GUI;
import static View.Inicio_GUI.cod1_txt;
import static View.Inicio_GUI.cod2_txt;
import static View.Inicio_GUI.cod1_txt;
import static View.Inicio_GUI.email2_txt;
import static View.Inicio_GUI.email_txt;
import static View.Inicio_GUI.end1_txt;
import static View.Inicio_GUI.end_txt;
import static View.Inicio_GUI.nome1_txt;
import static View.Inicio_GUI.nome_txt;
import static View.Inicio_GUI.nome1_txt;
import static View.Inicio_GUI.tel1_txt;
import static View.Inicio_GUI.tel_txt;
import java.sql.Connection;          // ✅ usa o pacote JDBC padrão
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Funcoes_DAO {
    
 static int cod;
 static String nom;
 static String em;
 static long tel;
 static String end;
    
public static String url2 = "jdbc:mysql://localhost:3307/aprender"
        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

  static String username = "root";        //nome de um usuário de seu BD
  static String password = "1234";  // senha do BD

    
    public static void cadastrar(){
        //INICIO---------------->
        
        
nom = nome_txt.getText(); // recebendo o nome
em = email_txt.getText(); // recebendo o email
end = end_txt.getText(); // recebendo o endereço
tel = Long.valueOf(tel_txt.getText());// recebendo o telefone

Model.Conecta_DB.carregaDriver();

       
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url2, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }

            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO cliente(cli_nome,cli_email,cli_end,cli_tel) values('"+nom+"','"+em+"','"+end+"','"+tel+"')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                nome_txt.setText("");
                email_txt.setText("");
                end_txt.setText("");
                tel_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            tel_txt.setText("");
        }

       
              

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   //FIM ----------->
}
    
    public static void consultar(){
        //--Inicio
        try{     //Iniciando o possivel tratamento de erros
            //Declarando a variavel código
            int codigo = Integer.valueOf(cod1_txt.getText());
            

         Model.Conecta_DB.carregaDriver(); // Carregando o driver
              
            try {// Tratamento de erro para a conexao
                // Declarando  a variavel de conexão con
                // e estabelendo a conexão
                Connection con = null;

                try {
                    con = (Connection) DriverManager.getConnection(url2, username, password);
                } catch (Exception ex) {
                    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Declarando uma string com o comando mySQL para consulta
                String sql = "SELECT cli_nome,cli_email, cli_end , cli_tel FROM cliente where cli_cod = "+codigo;
                // Criando variavel que executara o comando da string sql
                Statement stm = (Statement) con.createStatement();
                try//Tratamento de erro da consulta
                { //Criando variavel que exibira os resultados
                    //Executando o comando da string sql na variavel rs
                    ResultSet rs = stm.executeQuery(sql);

                    int i=0; // Variavel utilizada para saber se ha dados cadastrados

                    while (rs.next()) {  // Criando variaveis que receberão os valores do banco de dados
                        String nome = rs.getString("cli_nome");
                        String email = rs.getString("cli_email");
                        String endereco =  rs.getString("cli_end");
                        String telefone = rs.getString("cli_tel");
                        

                        i++;

                         nome1_txt.setText(String.valueOf(nome));
                         email2_txt.setText(String.valueOf(email));
                         end1_txt.setText(String.valueOf(endereco));
                         tel1_txt.setText(String.valueOf(telefone));

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
            cod1_txt.setText("");
        }

        
        
        
        //--Fim
        
    }
    
    
    
     public static void alterar(){
        //---inicio  
      nom = nome1_txt.getText(); // recebendo o nome
      em  = email2_txt.getText(); // recebendo o email         
      end  = end1_txt.getText(); 
      tel = Long.valueOf(tel1_txt.getText());

       Model.Conecta_DB.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url2, username, password);
      }catch (Exception ex) {
            Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE cliente SET cli_nome='"+nom+"', cli_end='"+end+"',cli_email='"+em+"',cli_tel='"+tel+"' WHERE cli_cod="+cod1_txt.getText();
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); 

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                cod1_txt.setText("");
                nome1_txt.setText("");
                email2_txt.setText("");
                end1_txt.setText("");
                tel1_txt.setText("");


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            tel1_txt.setText("");
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
                    Logger.getLogger(Inicio_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM cliente WHERE cli_cod = "+cod2_txt.getText();

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod2_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod2_txt.setText("");

        }

        
    //---Fim    
    }
    
    
}
