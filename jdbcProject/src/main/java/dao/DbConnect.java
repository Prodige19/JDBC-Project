package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnect {
    
    //Déclaration de url, user et password
    String url = "jdbc:mysql://localhost/afi";
    String user = "root";
    String password = "";

    //creation de la variable connexion
    public Connection C = null;
    
    //creation de la variable statement
    public Statement st = null;
    
    //Creation de la methode connect
    public void connect(){
        
        //Définition des Etapes de connexion jdbc - MySQL
        
        //Etape1 (Chargement du Driver)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Etape2(Connexion à la base de données)
        try {
            C = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Etape3(Creation du Statement)
        try {
            st = C.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
