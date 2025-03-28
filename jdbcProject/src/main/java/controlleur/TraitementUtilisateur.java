/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlleur;

import dao.DbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.Utilisateur;

/**
 *
 * @author prodi
 */
public class TraitementUtilisateur {
    
    //Ajouter Utilisateur
    public void ajouter(Utilisateur u){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqAjout = "INSERT INTO utilisateur (Prenom, Nom, Login, Password) VALUES ('"
                +u.getPrenom()+"','"+u.getNom()+"','"+u.getLogin()+"','"+u.getPassword()+"')";
        
        try {
            Dbcon.st.executeUpdate(ReqAjout);
            JOptionPane.showMessageDialog(null, "Utilisateur Ajouté avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modifer Utilisateur
    public void modifier(Utilisateur u){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqModif = "UPDATE utilisateur SET Prenom= '"+u.getPrenom()+"',Nom='"+u.getNom()+"',"
                + "Login='"+u.getLogin()+"',Password = '"+u.getPassword()+"' WHERE ID='"+u.getId()+"'";
        
        try {
            Dbcon.st.executeUpdate(ReqModif);
            JOptionPane.showMessageDialog(null, "Utilisateur Modifié avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Rechercher Utilisateur par ID
    public Utilisateur search(int id){
        Utilisateur U = null;
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqSearch = "SELECT * FROM utilisateur WHERE ID = '"+id+"'";
        
        try {
            ResultSet res;
            res = Dbcon.st.executeQuery(ReqSearch);
            if (res.next()){
                U = new Utilisateur(res.getInt("ID"),res.getString("Prenom"),res.getString("Nom"),
                        res.getString("Login"),res.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return U;
    }
    
    //Supprimer Utilisateur par ID
    public void DelUser(Utilisateur u){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String del = "DELETE FROM utilisateur WHERE ID ='"+u.getId()+"'";
        try {
            Dbcon.st.executeUpdate(del);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Utilisateur Supprimer avec succès");
    }
    
    //Liste Utilisateur
    public ResultSet list(){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqList="SELECT * FROM utilisateur";
        ResultSet res = null;
        try {
            res = Dbcon.st.executeQuery(ReqList);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    //Connection
    public boolean Login(String log, String Pass){
        boolean L = false;
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        String ReqLogin="SELECT * FROM utilisateur WHERE Login = '"+log+"' AND Password = '"+Pass+"'";
        
        ResultSet res = null;
        try {
            res = Dbcon.st.executeQuery(ReqLogin);
            if(res.next()){
                L = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }
}
