package controlador;
import java.sql.*;
import java.util.*;
import clases.*;
import util.MySQLConexion;
public class NegocioMass {
    public void adi_Empleados(empleado e){
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
}
