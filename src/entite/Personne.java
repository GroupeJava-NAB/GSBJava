/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Utilisateur
 */
public class Personne {
    String code;
    String nom;
    String prenom;

public String getCode() {
return code;
}

public void setCode(String code) {
this.code = code;
}

public String getNom() {
return nom;
}

public void setNom(String nom) {
this.nom = nom;
}

public String getPrenom() {
return prenom;
}

public void setPrenom(String prenom) {
this.prenom = prenom;
}

// 1er constructeur
public Personne (String vCode, String vNom, String vPrenom) {
code = vCode;
nom = vNom;
prenom = vPrenom;
}

// 2ème constructeur pour les recherches
public Personne (String vCode){
code = vCode;
}

// 3ème constructeur pour une simple lecture de collection Défaut
public Personne () {
}
}
