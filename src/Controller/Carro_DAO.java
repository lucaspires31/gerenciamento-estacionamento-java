
package Controller;
import Controller.Carro_DAO;
import static Controller.Visitante_DAO.url2;
import static Controller.Visitante_DAO.username;
import static View.CadastroEst_GUI.cor1_txt;
import static View.CadastroEst_GUI.mod1_txt;
import static View.CadastroEst_GUI.num1_txt;
import static View.CadastroEst_GUI.codvis_txt;
import static View.CadastroEst_GUI.pla77_txt;
import static View.CadastroEst_GUI.tip1_txt;
import View.ConsultaEst_GUI;
import static View.ConsultaEst_GUI.cod8_txt;
import static View.ConsultaEst_GUI.cor_txt;
import static View.ConsultaEst_GUI.mod_txt;
import static View.ConsultaEst_GUI.nomeVisitante_txt;
import static View.ConsultaEst_GUI.docVisitante_txt;
import static View.ConsultaEst_GUI.num_txt;
import static View.ConsultaEst_GUI.date_txt;
import static View.ConsultaEst_GUI.pla200_txt;
import static View.ConsultaEst_GUI.status1_txt;
import static View.ConsultaEst_GUI.time_txt;
import static View.ConsultaEst_GUI.tip_txt;
import static View.EntradaEst_GUI.cod132_txt;
import static View.ExcluirEst_GUI.cod7_txt;
import static View.HistoricoEst_GUI.cod120_txt;
import static View.HistoricoEst_GUI.de1_txt;
import static View.HistoricoEst_GUI.ds1_txt;
import static View.HistoricoEst_GUI.he1_txt;
import static View.HistoricoEst_GUI.hs1_txt;
import static View.HistóricoVis_GUI.cod119_txt;
import static View.HistóricoVis_GUI.de_txt;
import static View.HistóricoVis_GUI.ds_txt;
import static View.HistóricoVis_GUI.he_txt;
import static View.HistóricoVis_GUI.hs_txt;
import static View.SaidaEst_GUI.cod22_txt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




public class Carro_DAO {
    
 static int cod;
 static String placa;
 static String modelo;
 static String cor;
 static String tipo;
 static String numero;
 
    
public static String url2 = "jdbc:mysql://localhost:3306/aprender"
        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";

  static String username = "root";        //nome de um usuário de seu BD
  static String password = "";  // senha do BD

    
    public static void cadastrar(){
        //INICIO---------------->
        
        
placa = pla77_txt.getText(); 
modelo = mod1_txt.getText(); 
cor = cor1_txt.getText();
tipo = tip1_txt.getText();
numero = num1_txt.getText();


Model.Conecta_DB.carregaDriver();

       
       
      try { 
               
                   
               
            Connection con = null;
            
            
    try {
    con = (Connection) DriverManager.getConnection(url2, username, password);
    } catch (SQLException ex) {

    Logger.getLogger(ConsultaEst_GUI.class.getName()).log(Level.SEVERE, null, ex);

            
                   }
            
            int visitanteId = Integer.parseInt(codvis_txt.getText());


            // Recebendo os dados a serem inseridos na tabela
            String sql = "INSERT INTO carros(cli_placa,cli_modelo,cli_cor,cli_tipo,cli_numero,visitante_id, cli_status) values('"+placa+"','"+modelo+"','"+cor+"','"+tipo+"','"+numero+"',"+visitanteId+",'dentro')";
     
            try { // Tratamento de Erros para inserção

                // Criando varialvel que executara a inserção
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

  JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                pla77_txt.setText("");
                mod1_txt.setText("");
                tip1_txt.setText("");
                cor1_txt.setText("");
                num1_txt.setText("");
                codvis_txt.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            num1_txt.setText("");
        }
      }
      
      


    public static void consultar() {
    //--Início
    try {
        
        String placa = cod8_txt.getText().trim();

        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite a placa do veículo", "ERRO", 0);
            return;
        }

        
        Model.Conecta_DB.carregaDriver(); 

        try {
            
            Connection con = DriverManager.getConnection(url2, username, password);

            
            String sql = "SELECT c.cli_placa, c.cli_modelo, c.cli_cor, c.cli_tipo, c.cli_numero, " +
                         "v.nome, v.documento, v.foto, c.cli_status, " +
                         "c.data_entrada, c.hora_entrada, c.data_saida, c.hora_saida " +
                         "FROM carros c " +
                         "LEFT JOIN visitante v ON c.visitante_id = v.visitante_id " +
                         "WHERE c.cli_placa = ?";

            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, placa); 

           
            ResultSet rs = stm.executeQuery();

            int i = 0;  

            
            while (rs.next()) {
                String modelo = rs.getString("cli_modelo");
                String cor = rs.getString("cli_cor");
                String tipo = rs.getString("cli_tipo");
                String numero = rs.getString("cli_numero");
                String nomeVisitante = rs.getString("nome");
                String docVisitante = rs.getString("documento");
                String fotoVisitante = rs.getString("foto");
                String status = rs.getString("cli_status");
                String dataEntrada = rs.getString("data_entrada");
                String horaEntrada = rs.getString("hora_entrada");

                
                pla200_txt.setText(placa);
                mod_txt.setText(modelo);
                cor_txt.setText(cor);
                tip_txt.setText(tipo);
                num_txt.setText(numero);
                nomeVisitante_txt.setText(nomeVisitante != null ? nomeVisitante : "N/A");
                docVisitante_txt.setText(docVisitante != null ? docVisitante : "N/A");
                status1_txt.setText(status);
                date_txt.setText(dataEntrada != null ? dataEntrada : "");
                time_txt.setText(horaEntrada != null ? horaEntrada : "");

                i++;  
            }

            
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Dado não cadastrado", "Resultado", -1);
            }

        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, "\nErro ao consultar!", "ERRO", 0);
        }

    } catch (NumberFormatException erro) {
        
        JOptionPane.showMessageDialog(null, "Digite a placa corretamente", "ERRO", 0);
        cod8_txt.setText("");
    }
    //--Fim
}


        
        
        
        //--Fim
        
        
        
        public static void alterar(){
        //---inicio  
      placa = pla200_txt.getText(); 
      modelo = mod_txt.getText(); 
      cor = cor_txt.getText();
      tipo = tip_txt.getText();
      numero = num_txt.getText();

       Model.Conecta_DB.carregaDriver();
       
      try {     
            Connection con = null;
      try {
            con = (Connection) DriverManager.getConnection(url2, username, password);
      }catch (Exception ex) {
            Logger.getLogger(ConsultaEst_GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
            String sql = "UPDATE carros SET cli_placa='"+placa+"', cli_modelo='"+modelo+"',cli_cor='"+cor+"',cli_tipo='"+tipo+"',cli_numero='"+numero+"' WHERE carro_id="+cod8_txt.getText();
            
     
            try { 
                PreparedStatement inserir = (PreparedStatement) con.prepareStatement(sql);
                inserir.execute(); // Executando a inserção

                JOptionPane.showMessageDialog(null,"\nInserção realizada com sucesso!!!\n","",-1);
                cod8_txt.setText("");
                date_txt.setText("");
                mod_txt.setText("");
                cor_txt.setText("");
                tip_txt.setText("");
                num_txt.setText("");
                nomeVisitante_txt.setText("");
                docVisitante_txt.setText("");
                status1_txt.setText("");
                time_txt.setText("");
                pla200_txt.setText("");
                


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na inserção!","ERRO!",0);
            }

        }catch(NumberFormatException erro){
            // Tratamento de erro caso o usuario não digite o telefone corretamente
            JOptionPane.showMessageDialog(null,"Digite os dados corretamente","ERRO",0);
            docVisitante_txt.setText("");
        }    

        
        
       //-- Fim         

        
        
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
                    Logger.getLogger(ConsultaEst_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
           

            // Criando String com comando SQL para exclusão
            String sql = "DELETE FROM carros WHERE carro_id = "+cod7_txt.getText();

            try // Tratamento de erros para exclusão
            {// Criando Variavel para executar a ação
                PreparedStatement excluir = (PreparedStatement) con.prepareStatement(sql);
                excluir.execute();// Executando a exclusão

                JOptionPane.showMessageDialog(null,"\nExclusão realizada com sucesso!!!\n","",-1);
                cod7_txt.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"\nErro na exclusão!","ERRO!",0);
            }

        } catch(NumberFormatException erro){ // Codigo digitado com caracteres não numericos
            JOptionPane.showMessageDialog(null,"Digite o código corretamante","ERRO",0);
            cod7_txt.setText("");

        }

        
    //---Fim    
    }
            
    public static void registrarSaida() {
    try {
        int codigo = Integer.parseInt(cod22_txt.getText());

        Model.Conecta_DB.carregaDriver();
        Connection con = DriverManager.getConnection(url2, username, password);

        // Verifica se o carro existe e qual o status atual
        String checkSql = "SELECT cli_status FROM carros WHERE carro_id = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setInt(1, codigo);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String statusAtual = rs.getString("cli_status");

            if ("fora".equalsIgnoreCase(statusAtual)) {
                JOptionPane.showMessageDialog(null, "Este carro já está com status 'fora'.");
            } else {
                // Atualiza status + data e hora de saída
                String updateSql = "UPDATE carros SET cli_status = 'fora', data_saida = CURRENT_DATE, hora_saida = CURRENT_TIME WHERE carro_id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateSql);
                updateStmt.setInt(1, codigo);
                int rows = updateStmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Saída registrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar a saída.");
                }
                updateStmt.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado!");
        }

        rs.close();
        checkStmt.close();
        con.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao registrar saída: " + e.getMessage());
    }
}

    
    
    
    public static void registrarEntrada() {
    try {
        int codigo = Integer.parseInt(cod132_txt.getText());

        Model.Conecta_DB.carregaDriver();
        Connection con = DriverManager.getConnection(url2, username, password);

        String checkSql = "SELECT cli_status FROM carros WHERE carro_id = ?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);
        checkStmt.setInt(1, codigo);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String statusAtual = rs.getString("cli_status");

            if ("dentro".equalsIgnoreCase(statusAtual)) {
                JOptionPane.showMessageDialog(null, "Este carro já está com status 'dentro'.");
            } else {
                String updateSql = "UPDATE carros SET cli_status = 'dentro' WHERE carro_id = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateSql);
                updateStmt.setInt(1, codigo);
                int rows = updateStmt.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Entrada registrada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar a entrada.");
                }
                updateStmt.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado!");
        }

        rs.close();
        checkStmt.close();
        con.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao registrar entrada: " + e.getMessage());
    }
}
    
    
    
    public static void consultarHorarios() {
    try {
        int codigo = Integer.parseInt(cod120_txt.getText().trim());

        Model.Conecta_DB.carregaDriver();
        try (Connection con = DriverManager.getConnection(url2, username, password)) {

            String sql = "SELECT data_entrada, hora_entrada, data_saida, hora_saida FROM carros WHERE carro_id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, codigo);
                try (ResultSet rs = stmt.executeQuery()) {

                    if (rs.next()) {
                        String dataEntrada = rs.getString("data_entrada");
                        String horaEntrada = rs.getString("hora_entrada");
                        String dataSaida = rs.getString("data_saida");
                        String horaSaida = rs.getString("hora_saida");

                        // Preenche os campos da tela
                        de1_txt.setText(dataEntrada != null ? dataEntrada : "");
                        he1_txt.setText(horaEntrada != null ? horaEntrada : "");
                        ds1_txt.setText(dataSaida != null ? dataSaida : "");
                        hs1_txt.setText(horaSaida != null ? horaSaida : "");

                    } else {
                        JOptionPane.showMessageDialog(null, "Visitante não encontrado!");
                        de1_txt.setText("");
                        he1_txt.setText("");
                        ds1_txt.setText("");
                        hs1_txt.setText("");
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar: " + e.getMessage());
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Digite um código válido!");
    }
}



    

        
    
      
      
      
      
      

    }

