package entite;

public class Parametres {

    private String nomUtilisateur;
    private String motDePasse;
    private String serveurBD;
    private String driverSGBD;

    public Parametres() {
        nomUtilisateur = "root";
        motDePasse = "tempo";
        driverSGBD = "com.mysql.jdbc.Driver";
        serveurBD = "jdbc:mysql://localhost:1527/gsb";
    }

    public String getDriverSGBD() {
        return driverSGBD;
    }
    public void setDriverSGBD(String driverSGBD) {
        this.driverSGBD = driverSGBD;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public String getServeurBD() {
        return serveurBD;
    }
    public void setServeurBD(String serveurBD) {
        this.serveurBD = serveurBD;
    }
}
