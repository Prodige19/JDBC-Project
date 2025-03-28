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
import modele.Secretaire;

/**
 *
 * @author prodi
 */
public class TraitementSecretaire {
    //Ajouter Secretaire
    public void ajouterS(Secretaire S){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqAjout = "INSERT INTO secretaire (Matricule, Prenom, Nom, Login, Passwd) VALUES('"
                +S.getMatricule()+"','"+S.getPrenom()+"','"+S.getNom()+"','"+S.getLogin()+"','"+S.getPassword()+"')";
        
        try {
            Dbcon.st.executeUpdate(ReqAjout);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementSecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Modifer Secretaire
    public void Modifier(Secretaire S){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqModif = "UPDATE secretaire SET Prenom= '"+S.getPrenom()+"',Nom='"+S.getNom()+"',"
                + "Login='"+S.getLogin()+"',Password = '"+S.getPassword()+"') WHERE ID='"+S.getMatricule()+"'";
        
        try {
            Dbcon.st.executeUpdate(ReqModif);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Rechercher Secretaire par Matricule
    public Secretaire SearchSecret(String Matricule){
        Secretaire S = null;
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqSearch = "SELECT * FROM secretaire WHERE Matricule='"+Matricule+"'";
        try {
            ResultSet res = Dbcon.st.executeQuery(ReqSearch);
            if (res.next()){
                S = new Secretaire(res.getString("Matricule"),res.getString("Prenom"),res.getString("Nom"),
                res.getString("Login"),res.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementSecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Secrétaire ");
        return S;
    }
    
    //Supprimer Secretaire par ID
    public void delsecret(Secretaire S){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String Reqdel = "DELETE FROM secretaire WHERE Matricule = '"+S.getMatricule()+"'";
        try {
            Dbcon.st.executeUpdate(Reqdel);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementSecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Liste Secretaire
    public ResultSet ListSecret(){
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        
        String ReqListSecret = "SELECT * FROM secretaire";
        ResultSet res = null;
        
        try {
            res = Dbcon.st.executeQuery(ReqListSecret);
        } catch (SQLException ex) {
            Logger.getLogger(TraitementSecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean Login(String Log, String Pass){
        boolean L = false;
        
        DbConnect Dbcon = new DbConnect();
        Dbcon.connect();
        String ReqLogin="SELECT * FROM secretaire WHERE Login = '"+Log+"' AND Password = '"+Pass+"'";
        
        ResultSet res = null;
        try {
            res = Dbcon.st.executeQuery(ReqLogin);
            if(res.next()){
                L = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraitementSecretaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }
}
