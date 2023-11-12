package clases;

public class gui_entrega {
    private String id_guia;
    private String id_pedi;
    private String fech_entrg;

    public gui_entrega() {
    }

    public gui_entrega(String id_guia, String id_pedi, String fech_entrg) {
        this.id_guia = id_guia;
        this.id_pedi = id_pedi;
        this.fech_entrg = fech_entrg;
    }

    public gui_entrega(String id_pedi, String fech_entrg) {
        this.id_pedi = id_pedi;
        this.fech_entrg = fech_entrg;
    }

    public String getFech_entrg() {
        return fech_entrg;
    }

    public void setFech_entrg(String fech_entrg) {
        this.fech_entrg = fech_entrg;
    }

    public String getId_guia() {
        return id_guia;
    }

    public void setId_guia(String id_guia) {
        this.id_guia = id_guia;
    }

    public String getId_pedi() {
        return id_pedi;
    }

    public void setId_pedi(String id_pedi) {
        this.id_pedi = id_pedi;
    }
    
}
