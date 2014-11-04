/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

// pour la connexion à la BD
import controle.connection.ControleConnexion;
import java.sql.Connection;
// pour les requêtes SQL
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//pour la structure d’accueil des données
import java.util.ArrayList;
// pour la gestion de la propriété date
import java.util.Date;
// pour les boîtes de dialogue 
import javax.swing.JOptionPane;
// Import pour l'ajout de client
import java.sql.*;

/**
 *
 * @author Utilisateur
 */

public class Client extends Personne {
    // PROPRIETES
    // ==========
    // Propriétés de base de la classe
    // -------------------------------

private boolean carte_fidele;
private Date date;

// Propriété pour établir la connexion avec la BD
// -----------------------------------------------
private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
// propriété de type ArrayList qui contiendra les enregistrements de la BD
private final ArrayList<Client> lesEnreg = new ArrayList<>();


public String getCode() {
return code;
}

public String getNom() {
 return nom;
}

public String getPrenom() {
 return prenom;
}

public boolean isCarte_Fidele() {
 return carte_fidele;
}

public Date getDate_creation() {
 return date;
}

public ArrayList<Client> getlesEnreg() {
 return lesEnreg;
}

public void setCode(String code) {
this.code = code;
}

public void setNom(String nom) {
this.nom = nom;
}

public void setPrenom(String prenom) {
this.prenom = prenom;
}

public void setCarte_fidele(boolean carte_fidele) {
this.carte_fidele = carte_fidele;
}

public void setDate_creation(Date date_creation) {
this.date = date_creation;
}

// CONSTRUCTEURS
// -------------

// 1er Constructeur
public Client(String vCode, String vNom, String vPrenom,boolean vCarteFidele,
        Date vDateCreation) {
super (vCode, vNom, vPrenom);
this.code = vCode;
this.nom = vNom;
this.prenom = vPrenom;
carte_fidele = vCarteFidele;
date = vDateCreation;
} 

// 2ème Constructeur
public Client(String vCode) {
super(vCode);
this.code = vCode;
} 

// 3ème constructeur
public Client() {
// à activer dès création de la méthode
// lireRecupCRUD();
}

// 4ème constructeur
public Client(String vNom, String vPrenom){
nom = vNom;
prenom = vPrenom;

} 

//------------------------------------------------------------------------------
// CRUD
//------------------------------------------------------------------------------

//Lecture de la table entière et récupération des enregistrements
private void lireRecupCRUD(){
    try{
        Statement state = laConnexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * "
            + "FROM clients ORDER BY nom");
        while(rs.next()){
            String codeJ = rs.getString("code");
            String nomJ= rs.getString("nom");
            String prenomJ = rs.getString("prenom");
            boolean carte_fideleJ = rs.getBoolean("carte_fidele");
            Date date_creation = rs.getDate("date");
            lesEnreg.add(new Client(codeJ, nomJ, prenomJ, carte_fideleJ, date_creation));
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,
                "Problème rencontré :" +e.getMessage(),
                "Résultat", JOptionPane.ERROR_MESSAGE);
    }
}

//Ajout d'un nouveau client
public boolean creerCRUD(String vCode, String vNom,
        String vPrenom, int vCarte_fidele, String vDate){
    boolean bCreation = false;
    String requete = null;
    try {
        requete = "Insert Into "
                + "clients VALUES (?,?,?,?,?)";
        PreparedStatement prepare = laConnexion.prepareStatement(requete);
        prepare.setString(1, vCode);
        prepare.setString(2, vNom);
        prepare.setString(3, vPrenom);
        prepare.setInt(4, vCarte_fidele);
        prepare.setString(5, vDate);
        prepare.executeUpdate();
        prepare.close();
        bCreation = true;
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Ajout dans la BD non effectué : "
            +e.getMessage(), "Problème rencontré",
            JOptionPane.ERROR_MESSAGE);
    }
    return bCreation;
}

// Modification d'un client
public boolean modifierCRUD(String vCode, String vNom,
    String vPrenom, int vCarte_fidele, String vDate) {
    boolean bCreation = false;
    String requete = null;
try { 
    requete = "UPDATE clients SET"
    + " nom = ?,"
    + " prenom = ?,"
    + " carte_fidele = ?, "
    + " date = ?"
    + " WHERE code = ?"; 
    PreparedStatement prepare = 
    laConnexion.prepareStatement(requete);
    prepare.setString(1, vNom);
    prepare.setString(2, vPrenom);
    prepare.setInt(3, vCarte_fidele);
    prepare.setString(4, vDate);
    prepare.setString(5, vCode);
    prepare.executeUpdate();
    prepare.close();
    bCreation = true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
        "Ajout dans la BD non effectué : "
        + e.getMessage(), "Problème rencontré",
        JOptionPane.ERROR_MESSAGE);      
    }
    return bCreation;
 }

// Suppressio d'un client

public boolean supprimerCRUD(String vCode) {
    boolean bSuppression = true;
    String requete = null;
// Vérifier avant qu’il n’existe aucune facture
try {
    String requeteClient = 
        "SELECT count(*) AS nbLignes FROM factures "
        + " WHERE code_client LIKE ’" + vCode + "’";
    Statement state = laConnexion.createStatement();
    ResultSet jeuEnreg = state.executeQuery(requeteClient);
    int nbLignes = 0;
    jeuEnreg.next();
    nbLignes = jeuEnreg.getInt("nbLignes");
    if (nbLignes > 0) {        
        bSuppression = false;
        JOptionPane.showMessageDialog(null, 
        "Il existe des factures pour ce client."
        + " Suppression interdite.",
        "Résultat", JOptionPane.ERROR_MESSAGE);
        bSuppression = false;
        } else {
        JOptionPane.showMessageDialog(null, 
        "Aucune facture pour ce client."
        + " Suppression autorisée.",
        "Résultat", JOptionPane.INFORMATION_MESSAGE);
    }
} catch (SQLException e) {
    bSuppression = false;
    JOptionPane.showMessageDialog(null,
        "Aucune suppression effectuée dans la BD : "
        + e.getMessage(),
        "Problème rencontré",
        JOptionPane.ERROR_MESSAGE);
}
if (bSuppression) {    
    try {
        requete = "DELETE FROM clients"
                + " WHERE Code = ’" + vCode + "’";
        Statement state = laConnexion.createStatement();        
        int nbEnregSup = state.executeUpdate(requete);
        if (nbEnregSup == 0) {
        JOptionPane.showMessageDialog(null,
            "Aucun enregistrement correspondant.",
            "Résultat", JOptionPane.ERROR_MESSAGE);  
        }
    } catch (SQLException e) {
        bSuppression = false;
        JOptionPane.showMessageDialog(null,            
            "Aucune suppression effectuée dans la BD : "
            + e.getMessage(),
            "Problème rencontré", 
            JOptionPane.ERROR_MESSAGE);
    }    
}
return bSuppression;
}

// Recherche 1
public ArrayList<Client> chercherCRUD(String vCode,
    String vNom, String vPrenom) {
if (vCode.equals("")) {
    vCode = "%";
}
if (vNom.equals("")) {
    vNom = "%";
}
if (vPrenom.equals("")) {
    vPrenom = "%";
}
String requete = "SELECT * FROM clients"
    + " WHERE code LIKE ’" + vCode + "’"
    + " AND nom LIKE ’" + vNom + "’"
    + " AND prenom LIKE ’" + vPrenom + "’";
try {
    Statement state = laConnexion.createStatement();
    ResultSet rs = state.executeQuery(requete);
    while (rs.next()) {
        String codeJ = rs.getString("code");
        String nomJ = rs.getString("nom");
        String prenomJ = rs.getString("prenom");
        boolean carte_fideleJ = rs.getBoolean("carte_fidele");
        Date date_creation = rs.getDate("date");
// ajout à l’Arraylist
        lesEnreg.add(new Client(codeJ, nomJ,
            prenomJ, carte_fideleJ, date_creation));
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, 
        "Problème rencontré : "
        + e.getMessage(),
        "Résultat", 
        JOptionPane.ERROR_MESSAGE);
}
return lesEnreg;
}

// Recherche 2
public ArrayList<Client> chercherCRUD(String recherche) {
String requete = "SELECT * FROM clients"
    + " WHERE code LIKE ’%" + recherche + "%’"
    + " OR nom LIKE ’%" + recherche + "%’"
    + " OR prenom LIKE ’%" + recherche + "%’";
try {
    Statement state = laConnexion.createStatement();
    ResultSet rs = state.executeQuery(requete);
    while (rs.next()) {
        String codeJ = rs.getString("code");
        String nomJ = rs.getString("nom");
        String prenomJ = rs.getString("prenom");
        boolean carte_fideleJ = rs.getBoolean("carte_fidele");
        Date date_creation = rs.getDate("date");
        lesEnreg.add(new Client(codeJ, nomJ, prenomJ,
                carte_fideleJ, date_creation));
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, 
        "Problème rencontré : "
        + e.getMessage(),
        "Résultat", JOptionPane.ERROR_MESSAGE);
}
return lesEnreg;
}

}
