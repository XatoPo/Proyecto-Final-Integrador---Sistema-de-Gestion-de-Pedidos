package clases;

public class detalle_pedido extends producto{
    private int cant_produc_pedi;

    public detalle_pedido() {
    }
    
    public double precio_tot_pedi() {
        return cant_produc_pedi * super.getPrecio_empaq_produc();
    }

    public int getCant_produc_pedi() {
        return cant_produc_pedi;
    }

    public void setCant_produc_pedi(int cant_produc_pedi) {
        this.cant_produc_pedi = cant_produc_pedi;
    }
    
}
