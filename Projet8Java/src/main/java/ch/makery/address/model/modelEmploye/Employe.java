package ch.makery.address.model.modelEmploye;

public class Employe {
    private String numEmp;
    private String civilite;
    private String nom;
    private String prenom;
    private String mail;
    private String poste;
    private String lieu;

    public Employe(String numEmp, String civilite, String nom, String prenom, String mail, String poste, String lieu) {
        this.numEmp = numEmp;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.poste = poste;
        this.lieu = lieu;
    }
    public Employe() {

    }

    public String getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
