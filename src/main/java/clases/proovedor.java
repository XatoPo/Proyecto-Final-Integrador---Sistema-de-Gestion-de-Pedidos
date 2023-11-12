package clases;


public class proovedor{
    private String id_prov;
    private String nom_prov;
    private String descd_prov;
    private ubigeo datos_ubigeo_prov;
    private contacto datos_contacto_prov;
    
    public proovedor() {
    }
    
    // Constructor que no recibe el ID como argumento
    public proovedor(String nom_prov, String descd_prov, ubigeo datos_ubigeo_prov, contacto datos_contacto_prov) {
        this.nom_prov = nom_prov;
        this.descd_prov = descd_prov;
        this.datos_ubigeo_prov = datos_ubigeo_prov;
        this.datos_contacto_prov = datos_contacto_prov;
    }

    public proovedor(String id_prov, String nom_prov, String descd_prov, ubigeo datos_ubigeo_prov, contacto datos_contacto_prov) {
        this.id_prov = id_prov;
        this.nom_prov = nom_prov;
        this.descd_prov = descd_prov;
        this.datos_ubigeo_prov = datos_ubigeo_prov;
        this.datos_contacto_prov = datos_contacto_prov;
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

    public ubigeo getDatos_ubigeo_prov() {
        return datos_ubigeo_prov;
    }

    public void setDatos_ubigeo_prov(ubigeo datos_ubigeo_prov) {
        this.datos_ubigeo_prov = datos_ubigeo_prov;
    }

    public contacto getDatos_contacto_prov() {
        return datos_contacto_prov;
    }

    public void setDatos_contacto_prov(contacto datos_contacto_prov) {
        this.datos_contacto_prov = datos_contacto_prov;
    }

}
