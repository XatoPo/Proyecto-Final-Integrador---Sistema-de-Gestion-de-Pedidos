package clases;

public class pedido {
    private String id_pedi;
    private String fech_pedi;
    private String hora_pedi;
    private String id_prov;
    private String id_emp;
    private String estado_pedi;

    public pedido() {
    }

    public pedido(String fech_pedi, String hora_pedi, String id_prov, String id_emp, String estado_pedi) {
        this.fech_pedi = fech_pedi;
        this.hora_pedi = hora_pedi;
        this.id_prov = id_prov;
        this.id_emp = id_emp;
        this.estado_pedi = estado_pedi;
    }

    public String getEstado_pedi() {
        return estado_pedi;
    }

    public void setEstado_pedi(String estado_pedi) {
        this.estado_pedi = estado_pedi;
    }

    public String getId_pedi() {
        return id_pedi;
    }

    public void setId_pedi(String id_pedi) {
        this.id_pedi = id_pedi;
    }

    public String getFech_pedi() {
        return fech_pedi;
    }

    public void setFech_pedi(String fech_pedi) {
        this.fech_pedi = fech_pedi;
    }

    public String getHora_pedi() {
        return hora_pedi;
    }

    public void setHora_pedi(String hora_pedi) {
        this.hora_pedi = hora_pedi;
    }

    public String getId_prov() {
        return id_prov;
    }

    public void setId_prov(String id_prov) {
        this.id_prov = id_prov;
    }

    public String getId_emp() {
        return id_emp;
    }

    public void setId_emp(String id_emp) {
        this.id_emp = id_emp;
    }
    
    
}
