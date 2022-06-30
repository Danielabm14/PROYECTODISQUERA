package model.album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexion;


public class albumDao {

    //Atributos para realizar operaciones sobre la base de datos

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; //almacenar consutas
    String sql =null;
    int a;  //cantidad de filas que devuelve una sentencia
    
   

    // REGISTRAR
    public int Formulario(albumVo aVo) throws SQLException {
        sql= "INSERT INTO album(nombreAlbum, anoPublicado, estadoAlbum)  values(?,?,?)";
           try{
               con= conexion.conectar();
               ps=con.prepareStatement(sql);
               ps.setString(1,aVo.getNombreAlbum());
               ps.setString(2,aVo.getanoPublicado());
               ps.setBoolean(3,aVo.getEstadoAlbum());
               System.out.println(ps);
               System.out.println(ps);
               ps.executeUpdate(); //Ejecuta la sentencia
               ps.close();//cierra sentencia
               System.out.println("Se registró el album correctamente");
            }catch(Exception e){
                System.out.println("Error en el regisro "+e.getMessage().toString());
            }
            finally{
                con.close();//cerrando conexión
            }
            return a;
        }
           
    // LISTAR   

    public List<albumVo> Listar() throws SQLException{
      List<albumVo> albumList= new ArrayList<>();
        sql= "SELECT * FROM album";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()){
                albumVo a= new albumVo();
                //Escribir en el setter cada valor encontrado
                a.setIdAlbum(rs.getInt("idAlbum"));
                a.setNombreAlbum(rs.getString("nombreAlbum"));
                a.setAnoPublicado(rs.getString("anoPublicado"));
                a.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                albumList.add(a);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
         } catch (Exception e) {
             System.out.println("La consulta no pudo ser ejecutada" + e.getMessage() .toString());
        }
      finally{
          con.close();
      }
      return albumList;
    }

   
         //ELIMINAR

         public void Eliminar(int idAlbum) throws SQLException{
            sql="DELETE FROM album WHERE idAlbum=" +idAlbum;
        
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

public void estado(Boolean estadoAlbum, int idAlbum) throws SQLException {
    sql="UPDATE album SET estadoAlbum="+estadoAlbum+" WHERE idAlbum="+idAlbum;  //Variable para sql
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se cambio el estado a" +estadoAlbum+"Correctamente");

    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" +e.getMessage().toString());
    }
    finally{
        con.close(); //cerrando sesion
    }

}

//EDITAR

public List<albumVo>Listaralbum(int idAlbum) throws SQLException{
    List<albumVo> album= new ArrayList<>();
    sql="SELECT * FROM album WHERE idAlbum="+idAlbum; //Variable para la bd
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        rs=ps.executeQuery(sql);
       while (rs.next()) {
           albumVo a = new albumVo();
           //Escribir el setter en cada valor encontrado
           a.setIdAlbum(rs.getInt("idAlbum"));
           a.setNombreAlbum(rs.getString("nombreAlbum"));
           a.setAnoPublicado(rs.getString("anoPublicado"));
           a.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
           album.add(a);
       }
       ps.close();
       System.out.println("Consulta exitosa a Album especifico");
    } catch (Exception e) {
       System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString()); //Error
    }
    finally{
        con.close();
    }
    return album;
}


// ACTUALIZAR
public int Actualizar(albumVo album) throws SQLException{
    sql="UPDATE album SET nombreAlbum=?,anoPublicado=?, estadoAlbum=? WHERE idAlbum=?";//variable para el sql

    try{
        con=conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setString(1, album.getNombreAlbum());
        ps.setString(2, album.getanoPublicado());
        ps.setBoolean(3, album.getEstadoAlbum());
        ps.setInt(4, album.getIdAlbum());
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito el genero correctamente");
        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return a;//retornar numero de filas
}

}


        
