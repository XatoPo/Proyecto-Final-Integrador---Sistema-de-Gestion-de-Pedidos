package clases;

import java.util.ArrayList;
import java.util.List;

public class proovedor{
    private String id_prov;
    private String nom_prov;
    private String descd_prov;
    private ubigeo ubigeo_proovedor;
    private List<contacto> contacto_proovedor;

    public proovedor() {
    }
    
    // Constructor que no recibe el ID como argumento
    public proovedor(String nom_prov, String descd_prov, ubigeo ubigeo_proovedor, List<contacto> contacto_proovedor) {
        this.nom_prov = nom_prov;
        this.descd_prov = descd_prov;
        this.ubigeo_proovedor = ubigeo_proovedor;
        this.contacto_proovedor = new ArrayList<>();
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getDescd_prov() {
        return descd_prov;
    }

    public void setDescd_prov(String descd_prov) {
        this.descd_prov = descd_prov;
    }

    public ubigeo getUbigeo_proovedor() {
        return ubigeo_proovedor;
    }

    public void setUbigeo_proovedor(ubigeo ubigeo_proovedor) {
        this.ubigeo_proovedor = ubigeo_proovedor;
    }

    public List<contacto> getContacto_proovedor() {
        return contacto_proovedor;
    }

    public void setContacto_proovedor(List<contacto> contacto_proovedor) {
        this.contacto_proovedor = contacto_proovedor;
    }
     
}
