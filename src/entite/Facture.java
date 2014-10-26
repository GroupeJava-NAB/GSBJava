/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import controle.connection.ControleConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Utilisateur
 */
public class Facture {
    private String code;
    private Client code_client;
    private double total_ttc;
    private int codeModeReglement;
    private ModeReglement mode_reglement;
    private Date date;
    
    private static Connection laConnexion = ControleConnexion.getLaConnectionStatique();
    private final ArrayList<Facture> lesEnreg = new ArrayList<>();
    
    //Constructeur 1
    public Facture(String code, Client code_client, double total_ttc,
            ModeReglement mode_reglement, Date date){
        this.code=code;
        this.code_client = code_client;
        this.total_ttc = total_ttc;
        this.mode_reglement = mode_reglement;
        this.date = date;
    }
    // Constructeur 2
    public Facture(){
    // à activer dès création de la méthode
    // lireRecupCRUD();
    }
    
    // Constructeur 3 pour initier la recherche
    public Facture(String code){
    }
    
    //Getters/Setters

    public String getCode() {
        return code;
    }

    public Client getCode_client() {
        return code_client;
    }

    public double getTotal_ttc() {
        return total_ttc;
    }

    public int getCodeModeReglement() {
        return codeModeReglement;
    }

    public ModeReglement getMode_reglement() {
        return mode_reglement;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Facture> getLesEnreg() {
        return lesEnreg;
    }         
}
