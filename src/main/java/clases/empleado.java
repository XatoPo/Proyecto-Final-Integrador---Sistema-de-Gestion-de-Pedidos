package clases;

public class empleado {
    private String id_emp;
    private String nom_pat_emp;
    private String nom_mat_emp;
    private String ape_pat_emp;
    private String ape_mat_emp;
    private contacto datos_contacto_emp;
    private String cargo_emp;
    private ubigeo datos_ubigeo_emp;
    private String fech_nac_emp;
    private String password_emp;
    
    /*
    PARA ENCRIPTAR EN LA BD USEN:
    AES_ENCRYPT('password_emp', 'aB7xY9zL3pQ')
    
    PARA DESENCRIPTAR USEN:
    AES_DECRYPT(password_emp, 'aB7xY9zL3pQ') AS password_emp
    */

    public empleado() {
    }

    public empleado(String nom_pat_emp, String nom_mat_emp, String ape_pat_emp, String ape_mat_emp, contacto datos_contacto_emp, String cargo_emp, ubigeo datos_ubigeo_emp, String fech_nac_emp, String password_emp) {
        this.nom_pat_emp = nom_pat_emp;
        this.nom_mat_emp = nom_mat_emp;
        this.ape_pat_emp = ape_pat_emp;
        this.ape_mat_emp = ape_mat_emp;
        this.datos_contacto_emp = datos_contacto_emp;
        this.cargo_emp = cargo_emp;
        this.datos_ubigeo_emp = datos_ubigeo_emp;
        this.fech_nac_emp = fech_nac_emp;
        this.password_emp = password_emp;
    }
    
    public String nomCompleto() {
        String nombre_completo = nom_pat_emp + " " + nom_mat_emp + " " + ape_pat_emp + " " + ape_mat_emp;
        return nombre_completo;
    }

    public String getFech_nac_emp() {
        return fech_nac_emp;
    }

    public void setFech_nac_emp(String fech_nac_emp) {
        this.fech_nac_emp = fech_nac_emp;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }

    public String getNom_pat_emp() {
        return nom_pat_emp;
    }

    public void setNom_pat_emp(String nom_pat_emp) {
        this.nom_pat_emp = nom_pat_emp;
    }

    public String getNom_mat_emp() {
        return nom_mat_emp;
    }

    public void setNom_mat_emp(String nom_mat_emp) {
        this.nom_mat_emp = nom_mat_emp;
    }

    public String getApe_pat_emp() {
        return ape_pat_emp;
    }

    public void setApe_pat_emp(String ape_pat_emp) {
        this.ape_pat_emp = ape_pat_emp;
    }

    public String getApe_mat_emp() {
        return ape_mat_emp;
    }

    public void setApe_mat_emp(String ape_mat_emp) {
        this.ape_mat_emp = ape_mat_emp;
    }

    public contacto getDatos_contacto_emp() {
        return datos_contacto_emp;
    }

    public void setDatos_contacto_emp(contacto datos_contacto_emp) {
        this.datos_contacto_emp = datos_contacto_emp;
    }

    public String getCargo_emp() {
        return cargo_emp;
    }

    public void setCargo_emp(String cargo_emp) {
        this.cargo_emp = cargo_emp;
    }

    public ubigeo getDatos_ubigeo_emp() {
        return datos_ubigeo_emp;
    }

    public void setDatos_ubigeo_emp(ubigeo datos_ubigeo_emp) {
        this.datos_ubigeo_emp = datos_ubigeo_emp;
    }

    public String getPassword_emp() {
        return password_emp;
    }

    public void setPassword_emp(String password_emp) {
        this.password_emp = password_emp;
    }
    
}
