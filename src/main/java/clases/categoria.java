package clases;

public class categoria {
    private String id_ctg;
    private String nom_ctg;

    public categoria() {
    }

    public categoria(String id_ctg, String nom_ctg) {
        this.id_ctg = id_ctg;
        this.nom_ctg = nom_ctg;
    }

    public String getNom_ctg() {
        return nom_ctg;
    }

    public void setNom_ctg(String nom_ctg) {
        this.nom_ctg = nom_ctg;
    }

    public String getId_ctg() {
        return id_ctg;
    }

    public void setId_ctg(String id_ctg) {
        this.id_ctg = id_ctg;
    }    
    
}
