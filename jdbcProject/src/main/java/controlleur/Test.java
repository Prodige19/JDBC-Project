package controlleur;
import dao.DbConnect;

public class Test {
    
    public static void main(String[]args){
        //Constructeur
        DbConnect Db = new DbConnect();
        
        //Appelle de la methode connect
        Db.connect();
    }
}
