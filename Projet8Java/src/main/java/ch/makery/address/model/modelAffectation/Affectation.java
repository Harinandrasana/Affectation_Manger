package ch.makery.address.model.modelAffectation;

public class Affectation {
    private int numAffectation;
    private String numEmp;
    private String ancientLieu;
    private String nouveauLieu;
    private String dateAffectation;
    private String datePriseService;
    public String nom;
    public String prenom;
    public String poste;

    public Affectation(Integer numAffectation, String numEmp, String ancienLieu, String nouveauLieu, String dateAffectation, String datePriseService) {
        this.numAffectation = numAffectation;
        this.numEmp = numEmp;
        this.ancientLieu = ancienLieu;
        this.nouveauLieu = nouveauLieu;
        this.dateAffectation = dateAffectation;
        this.datePriseService = datePriseService;
    }

    public Affectation(Integer numAffectation, String numEmp, String ancienLieu, String nouveauLieu, String dateAffectation, String datePriseService, String nom,String prenom,String poste) {
        this.numAffectation = numAffectation;
        this.numEmp = numEmp;
        this.ancientLieu = ancienLieu;
        this.nouveauLieu = nouveauLieu;
        this.dateAffectation = dateAffectation;
        this.datePriseService = datePriseService;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;

    }

    public Affectation() {
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setPoste(String poste){
        this.poste = poste;
    }

    public String getNom(){
        return  nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public int getNumAffectation() {
        return numAffectation;
    }

    public void setNumAffectation(int numAffectation) {
        this.numAffectation = numAffectation;
    }

    public String getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(String numEmp) {
        this.numEmp = numEmp;
    }

    public String getAncientLieu() {
        return ancientLieu;
    }

    public void setAncientLieu(String ancientLieu) {
        this.ancientLieu = ancientLieu;
    }

    public String getNouveauLieu() {
        return nouveauLieu;
    }

    public void setNouveauLieu(String nouveauLieu) {
        this.nouveauLieu = nouveauLieu;
    }

    public String getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(String dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public String getDatePriseService() {
        return datePriseService;
    }

    public void setDatePriseService(String datePriseService) {
        this.datePriseService = datePriseService;
    }
}
