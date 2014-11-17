package controle.connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import entite.Parametres;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Classe non trouvée"
                    + " pour le chargement "
                    + "du pilote JDBC MySQL",
                    "ALERTE", JOptionPane.ERROR_MESSAGE);
            ok = false;
            etatConnexion = false;
        }
        if (ok == true) {
            try {
                String urlBD = lesParametres.getServeurBD();
                String nomUtilisateur = lesParametres.getNomUtilisateur();
                String MDP = lesParametres.getMotDePasse();
                laConnectionStatique = (Connection) DriverManager.getConnection(urlBD, nomUtilisateur,
                        MDP);
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

    public static boolean isEtatConnexion() {
        return etatConnexion;
    }
    public static Connection getLaConnectionStatique() {
        return laConnectionStatique;
    }
    public static Parametres getLesParametres() {
        return lesParametres;
    }

    public static boolean controle(String Nom,
            String MotDePasse) {
        boolean verificationSaisie;
        if (Nom.equals(lesParametres.getNomUtilisateur())
                && MotDePasse.equals(lesParametres.getMotDePasse())) {
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

    // méthode provisoire juste pour test
    public static void transfertDonnees() throws SQLException {
        System.out.println("Parcours du jeu d'enregistrements");
        System.out.println("---------------------------------");
        Statement leStatement = null;
        ResultSet jeuEnreg = null;
        String vCode = "";
        String vNom = "";
        String vPrenom = "";
        String chaineSQL = "select * from clients";
        leStatement =
                (Statement) laConnectionStatique.createStatement();
        jeuEnreg = leStatement.executeQuery(chaineSQL);
        while (jeuEnreg.next()) {
            vCode = jeuEnreg.getString(1);
            vNom = jeuEnreg.getString(2);
            vPrenom = jeuEnreg.getString("prenom");
            System.out.println(vCode + ", " + vNom
                    + ", " + vPrenom);
        }
        leStatement.close();
    }
}
