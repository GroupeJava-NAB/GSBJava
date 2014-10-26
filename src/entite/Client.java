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
}
