/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import controle.connection.ControleConnexion;
import java.sql.Connection;
import java.util.ArrayList;
/**
 *
 * @author Utilisateur
 */
public class ModeReglement {
private int code;
private String type;
private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
private final ArrayList<ModeReglement> lesEnreg = new ArrayList<>();

// Contructeur 1
public ModeReglement(){
    // à activer dès création de la méthode
    // lireRecupCRUD();    
}

// Contructeur 2
public ModeReglement(int code, String type){
    this.code = code;
    this.type = type;
}

//Constructeur 3
// Pour la gestion des factures
public ModeReglement(String vType){
    type = vType;
}

//Getteur/Setter

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public ArrayList<ModeReglement> getLesEnreg() {
        return lesEnreg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }
}
