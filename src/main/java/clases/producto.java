package clases;

public class producto extends categoria{
    private String id_produc;
    private String nom_produc;
    private String marca_produc;
    private double precio_empaq_produc;
    private int cant_x_empaq_produc;
    private String tipo_empq_produc;

    public producto() {
    }

    public producto(String nom_produc, String marca_produc, double precio_empaq_produc, int cant_x_empaq_produc, String tipo_empq_produc, String id_ctg, String nom_ctg) {
        super(id_ctg, nom_ctg);
        this.nom_produc = nom_produc;
        this.marca_produc = marca_produc;
        this.precio_empaq_produc = precio_empaq_produc;
        this.cant_x_empaq_produc = cant_x_empaq_produc;
        this.tipo_empq_produc = tipo_empq_produc;
    }

    public String getTipo_empq_produc() {
        return tipo_empq_produc;
    }

    public void setTipo_empq_produc(String tipo_empq_produc) {
        this.tipo_empq_produc = tipo_empq_produc;
    }

    public String getId_produc() {
        return id_produc;
    }

    public void setId_produc(String id_produc) {
        this.id_produc = id_produc;
    }

    public String getNom_produc() {
        return nom_produc;
    }

    public void setNom_produc(String nom_produc) {
        this.nom_produc = nom_produc;
    }

    public String getMarca_produc() {
        return marca_produc;
    }

    public void setMarca_produc(String marca_produc) {
        this.marca_produc = marca_produc;
    }

    public double getPrecio_empaq_produc() {
        return precio_empaq_produc;
    }

    public void setPrecio_empaq_produc(double precio_empaq_produc) {
        this.precio_empaq_produc = precio_empaq_produc;
    }

    public int getCant_x_empaq_produc() {
        return cant_x_empaq_produc;
    }

    public void setCant_x_empaq_produc(int cant_x_empaq_produc) {
        this.cant_x_empaq_produc = cant_x_empaq_produc;
    }
    
}
