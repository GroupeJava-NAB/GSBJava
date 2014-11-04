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
public class Categorie {
    private String code;
    private String designation;
    
    public Categorie( String code, String designation){
        super();
        this.code = code;
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }    
}
