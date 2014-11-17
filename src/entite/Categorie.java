package entite;

/*
 * La classe catégorie est à compléter lorsque vous aurez réalisé l'ensemble du
 * projet Xelfi tel que proposé dans le livre. Nous vous laissons donc le soin
 * de créer vous mêmes les méthodes CRUD en vous aidant de tout ce qui a été vu
 * et mis en oeuvre pour bâtir le projet Xelfi. Pensez alors à créer aussi un
 * modèle et une IHM selon la même démarche suivie pour les classes entités
 * Client, Article, Facture et LignesFacture
 */
public class Categorie {

    private String code;
    private String designation;

    public Categorie(String code, String designation) {
        super();
        this.code = code;
        this.designation = designation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
