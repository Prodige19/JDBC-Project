package modele;

public class Secretaire {
    private String Matricule;
    private String Prenom;
    private String Nom;
    private String Login;
    private String Password;

    //Constructeur sans paramètres
    public Secretaire() {
    }

    //Constructeur avec paramètres
    public Secretaire(String Matricule, String Prenom, String Nom, String Login, String Password) {
        this.Matricule = Matricule;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Login = Login;
        this.Password = Password;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    } 
}
