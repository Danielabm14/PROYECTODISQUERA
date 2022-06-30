package model.disquera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexion;



public class disqueraDao {

     //Atributos para realizar operaciones sobre la base de datos

     Connection con; //objeto de conexión
     PreparedStatement ps; //preparar sentencias
     ResultSet rs; //almacenar consutas
     String sql =null;
     int d;  //cantidad de filas que devuelve una sentencia



     // REGRISTRAR------------------------------------------------------------------------>
     public int Formulario(disqueraVo disquera) throws SQLException {
        sql= "INSERT INTO Disquera( nitDisquera, nombreDisquera, telefonoDisquera, direccionDisquera, estadoDisquera)  values(?,?,?,?,?)";
           try{
               con= conexion.conectar();
               ps=con.prepareStatement(sql);
               ps.setString(1,disquera.getNitDisquera());
               ps.setString(2,disquera.getNombreDisquera());
               ps.setString(3,disquera.getTelefonoDisquera());
               ps.setString(4,disquera.getDireccionDisquera());
               ps.setBoolean(5,disquera.getEstadoDisquera());


               System.out.println(ps);
               System.out.println(ps);
               ps.executeUpdate(); //Ejecuta la sentencia
               ps.close();//cierra sentencia
               System.out.println("Se registró la disquera correctamente");
            }catch(Exception e){
                System.out.println("Error en el regisro "+e.getMessage().toString());
            }
            finally{
                con.close();//cerrando conexión
            }
            return d;
        }

        // LISTAR   

    public List<disqueraVo> Listar() throws SQLException{
        List<disqueraVo> disqueraList= new ArrayList<>();
          sql= "SELECT * FROM Disquera";
          try{
              con=conexion.conectar();
              ps=con.prepareStatement(sql);
              rs=ps.executeQuery(sql);
              while (rs.next()){
                  disqueraVo d= new disqueraVo();
                  //Escribir en el setter cada valor encontrado
                  d.setIdDisquera(rs.getInt("idDisquera"));
                  d.setNitDisquera(rs.getString("nitDisquera"));
                  d.setNombreDisquera(rs.getString("nombreDisquera"));
                  d.setTelefonoDisquera(rs.getString("telefonoDisquera"));
                  d.setDireccionDisquera(rs.getString("direccionDisquera"));
                  d.setEstadoDisquera(rs.getBoolean("estadoDisquera"));
                  disqueraList.add(d);
              }
              ps.close();
              System.out.println("Consulta Exitosa");
           } catch (Exception e) {
               System.out.println("La consulta no pudo ser ejecutada" + e.getMessage() .toString());
          }
        finally{
            con.close();
        }
        return disqueraList;
      }

  //ELIMINAR

public void Eliminar(int idDisquera) throws SQLException{
    sql="DELETE FROM disquera WHERE idDisquera=" +idDisquera;

    try{
        con=conexion.conectar();
        ps=con.prepareStatement(sql); //Preparar Sentiencia
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se elimino Correctamente");
    }catch(Exception e){
        System.out.println("Error en la eliminación "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    
    }
}

//ESTADO

public void estado(Boolean estadoDisquera, int idDisquera) throws SQLException {
    sql="UPDATE Disquera SET estadoDisquera="+estadoDisquera+" WHERE idDisquera="+idDisquera;  //Variable para sql
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se cambio el estado a" +estadoDisquera+"Correctamente");

    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" +e.getMessage().toString());
    }
    finally{
        con.close(); //cerrando sesion
    }

}

//EDITAR

public List<disqueraVo>Listardisquera(int idDisquera) throws SQLException{
    List<disqueraVo> disquera= new ArrayList<>();
    sql="SELECT * FROM Disquera WHERE idDisquera="+idDisquera; //Variable para la bd
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
       while (rs.next()) {
           disqueraVo d = new disqueraVo();
           //Escribir el setter en cada valor encontrado
           d.setIdDisquera(rs.getInt("idDisquera"));
           d.setNitDisquera(rs.getString("nitDisquera"));
           d.setNombreDisquera(rs.getString("nombreDisquera"));
           d.setTelefonoDisquera(rs.getString("telefonoDisquera"));
           d.setDireccionDisquera(rs.getString("direccionDisquera"));
           d.setEstadoDisquera(rs.getBoolean("estadoDisquera"));
           disquera.add(d);
       }
       ps.close();
       System.out.println("Consulta exitosa a Disquera especifica");
    } catch (Exception e) {
       System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString()); //Error
    }
    finally{
        con.close();
    }
    return disquera;
}

// ACTUALIZAR
public int Actualizar(disqueraVo disquera) throws SQLException{
    sql="UPDATE Disquera SET nitDisquera=?,nombreDisquera=?, telefonoDisquera=?,  direccionDisquera=? WHERE idDisquera=?";//variable para el sql

    try{
        con=conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setString(1, disquera.getNitDisquera());
        ps.setString(2, disquera.getNombreDisquera());
        ps.setString(3, disquera.getTelefonoDisquera());
        ps.setString(4, disquera.getDireccionDisquera());
        ps.setInt(5, disquera.getIdDisquera());
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito la Disquera correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return d;//retornar numero de filas
}
}
