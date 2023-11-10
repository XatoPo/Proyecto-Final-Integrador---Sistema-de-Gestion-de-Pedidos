package controlador;

import java.sql.*;
import java.util.*;
import clases.*;
import interfaces.*;
import util.MySQLConexion;

public class NegocioMass implements registros, listados, mantenimiento, login, busquedas {
    
    /*-----REGISTRO DE DATOS-----*/
    @Override
    public void adiEmpleado(empleado e){
        Connection cn = MySQLConexion.getConexion();
        String sql = "INSERT INTO empleado (id_emp, nom_pat_emp, nom_mat_emp, "
                + "ape_pat_emp, ape_mat_emp,cargo_emp,fech_nac_emp,"
                + " password_emp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, e.getId_emp());
            st.setString(2, e.getNom_pat_emp());
            st.setString(3, e.getNom_mat_emp());
            st.setString(4, e.getApe_pat_emp());
            st.setString(5, e.getApe_mat_emp());
            /*st.setString(6, e.getDatos_contacto_emp().getId_contac());*/
            /*// Verificar si Id_contac es nulo antes de establecerlo
            if (e.getDatos_contacto_emp().getId_contac() != null) {
                st.setString(6, e.getDatos_contacto_emp().getId_contac());
            } else {
                st.setNull(6, Types.VARCHAR);
            }*/
            st.setString(6, e.getCargo_emp());
            /*st.setString(8, e.getDatos_ubigeo_emp().getId_ubigeo());*/
            /*// Verificar si Id_ubigeo es nulo antes de establecerlo
            if (e.getDatos_ubigeo_emp().getId_ubigeo() != null) {
                st.setString(8, e.getDatos_ubigeo_emp().getId_ubigeo());
            } else {
                st.setNull(8, Types.VARCHAR);
            }*/
            st.setString(7, e.getFech_nac_emp());         
            st.setString(8, e.getPassword_emp());
            int rowsAffected = st.executeUpdate();
    // Hacer algo con el resultado si es necesario        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
        
    @Override   
    public List<empleado> lisEmp(){
        List<empleado> lista=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="select id_emp, nom_pat_emp from empleado";
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               empleado men=new empleado();
               men.setId_emp(rs.getString(1));
               men.setNom_pat_emp(rs.getString(2));
               lista.add(men);
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;  
    }

    @Override
    public void adiContacto(contacto contac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiPedido(pedido pedid, List<detalle_pedido> lista_productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiGuia(gui_entrega guia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiProducto(producto produc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiProovedor(proovedor prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiUbigeo(ubigeo ubigeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    /*-----LISTADO DE DATOS-----*/
    @Override
    public List<categoria> listCategoria(String id_ctg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<contacto> listContactoEmpleado(String id_contac, String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<contacto> listContactoProovedor(String id_contac, String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ubigeo> listUbigeoEmpleado(String id_ubigeo, String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ubigeo> listUbigeoProovedor(String id_ubigeo, String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<empleado> listEmpleado(String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<proovedor> listProovedor(String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<gui_entrega> listGia(String id_guia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<producto> listProducto(String id_produc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<pedido> listPedido(String id_pedi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<detalle_pedido> listDetallePedido(String id_pedi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*-----LOGIN-----*/
    @Override
    public empleado login_emp(String id_emp, String password_emp) {
        empleado emp = null;
        Connection connection = MySQLConexion.getConexion();
        
        String sql = "{CALL sp_login_emp(?, ?)}";
        
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1, id_emp);
            statement.setString(2, password_emp);
      
            emp = new empleado();
            //cambiar get a set
            emp.getId_emp();
            emp.getNom_pat_emp();
            emp.getNom_mat_emp();
            emp.getApe_pat_emp();
            emp.getApe_mat_emp();
            emp.getDatos_contacto_emp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return emp;
    }
}
