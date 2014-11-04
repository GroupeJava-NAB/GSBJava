/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.connection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import entite.Parametres;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilisateur
 */
public abstract class ControleConnexion {
    static Parametres lesParametres;
    static boolean etatConnexion;
    static Connection laConnectionStatique;
static {
    boolean ok = true;
    lesParametres = new Parametres();
    try {
        Class.forName(lesParametres.getDriverSGBD());
        etatConnexion = true;
    } catch (ClassNotFoundException ex) {
        JOptionPane.showMessageDialog(null,
            "Classe non trouvée"
            + " pour le chargement "
            + "du pilote JDBC MySQL",
            "ALERTE", JOptionPane.ERROR_MESSAGE);
        ok = false;
        etatConnexion = false;
    }
// 2. Etablissement de la connexion
// ---------------------------------
    if (ok) {
        try {
// récupération des paramètres présents
// dans la classe Parametres
            String urlBD = lesParametres.getServeurBD();
            String nomUtilisateur = lesParametres.getNomUtilisateur();
            String MDP = lesParametres.getMotDePasse();
// Création d’une connexion 
// contenant les parametres de connexion
            laConnectionStatique = (Connection) DriverManager
                    .getConnection(urlBD, nomUtilisateur, MDP);
            etatConnexion = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,        
                "Impossible de se connecter"
                + " à la base de données",
                "ALERTE", JOptionPane.ERROR_MESSAGE);
            etatConnexion = false;
        }
    }
}
// Getter
    public static Parametres getLesParametres() {
        return lesParametres;
    }

    public static boolean isEtatConnexion() {
        return etatConnexion;
    }

    public static Connection getLaConnectionStatique() {
        return laConnectionStatique;
    }
    
    
public static boolean controle(String Nom, String MotDePasse) {
// 1. Vérification de la saisie
// ----------------------------
// l’égalité == lesParametres.getNomUtilisateur() ne fonctionne pas ici
// l’emploi de la méthode equals est ici obligatoire
    boolean verificationSaisie;
if (Nom.equals(lesParametres.getNomUtilisateur())
        && MotDePasse.equals(lesParametres
        .getMotDePasse())) {
    verificationSaisie = true;
} else {
    JOptionPane.showMessageDialog(null, 
        "Vérifier votre saisie.",
        "ERREUR", JOptionPane.ERROR_MESSAGE);
    verificationSaisie = false;
}
return verificationSaisie;
}


public static void fermetureSession() {
try {
    laConnectionStatique.close();
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, 
        "Problème rencontré"
        + "à la fermeture de la connexion",
        "ERREUR", JOptionPane.ERROR_MESSAGE);
}
}

public static void transfertDonnees() throws SQLException {
// simple parcours de jeu d’enregistrements
    System.out.println("Parcours du jeu d’enregistrements");
    System.out.println("---------------------------------");
// Interface Statement : pour transmettre des instructions SQL simples
// la fermeture d’un Statement engendre la fermeture
// automatique des tous les ResultSet associés 
    Statement leStatement = null;
// jeu d’enregistrements
    ResultSet jeuEnreg = null;
// variables
    String vCode = "";
    String vNom = "";
    String vPrenom = "";
    String chaineSQL = "select * from clients";
    leStatement = (Statement) laConnectionStatique.createStatement();
    jeuEnreg = leStatement.executeQuery(chaineSQL);
    while (jeuEnreg.next()) {
// utilisation des n° de colonnes
        vCode = jeuEnreg.getString(1);
        vNom = jeuEnreg.getString(2);
// ou des noms de colonnes
        vPrenom = jeuEnreg.getString("prenom");
        System.out.println(vCode + ", " + vNom
        + ", " + vPrenom);
    }
    leStatement.close();
}


}
