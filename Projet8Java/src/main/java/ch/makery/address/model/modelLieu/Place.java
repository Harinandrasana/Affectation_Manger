package ch.makery.address.model.modelLieu;

public class Place {
    private  String idLieu;
    private  String design;
    private String province;

    public Place(String idLieu, String design, String province) {
        this.idLieu = idLieu;
        this.design = design;
        this.province = province;
    }

    public Place(){
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
