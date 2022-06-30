package model.artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.conexion;
import model.disquera.disqueraVo;


public class artistaDao {

    //Atributos para realizar operaciones sobre la base de datos

    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; //almacenar consutas
    String sql =null;
    int ar;  //cantidad de filas que devuelve una sentencia


     // REGISTRAR
     public int Formulario(artistaVo arVo) throws SQLException {
        sql= "INSERT INTO Artista (numeroDocumento, tipoDocumento, nombreArtista, apellidoArtista, nombreArtistico, fechaNacimiento, emailArtista,  estadoArtista) values(?,?,?,?,?,?,?,?)";
           try{
               con= conexion.conectar();
               ps=con.prepareStatement(sql);
               ps.setString(1,arVo.getNumeroDocumento());
               ps.setString(2,arVo.getTipoDocumento());
               ps.setString(3,arVo.getNombreArtista());
               ps.setString(4,arVo.getApellidoArtista());
               ps.setString(5,arVo.getNombreArtistico());
               ps.setString(6,arVo.getFechaNacimiento());
               ps.setString(7,arVo.getEmailArtista());
               ps.setBoolean(8,arVo.getEstadoArtista());
               System.out.println(ps);
               System.out.println(ps);
               ps.executeUpdate(); //Ejecuta la sentencia
               ps.close();//cierra sentencia
               System.out.println("Se registró la Disquera correctamente");
            }catch(Exception e){
                System.out.println("Error en el regisro "+e.getMessage().toString());
            }
            finally{
                con.close();//cerrando conexión
            }
            return ar;
        }
        // LISTAR   

    public List<artistaVo> Listar() throws SQLException{
        List<artistaVo> artistaList= new ArrayList<>();
          sql= "SELECT * FROM Artista";
          try{
              con=conexion.conectar();
              ps=con.prepareStatement(sql);
              rs=ps.executeQuery(sql);
              while (rs.next()){
                  artistaVo ar= new artistaVo();
                  //Escribir en el setter cada valor encontrado
                  ar.setIdArtista(rs.getInt("idArtista"));
                  ar.setNumeroDocumento(rs.getString("numeroDocumento"));
                  ar.setTipoDocumento(rs.getString("tipoDocumento"));
                  ar.setNombreArtista(rs.getString("nombreArtista"));
                  ar.setApellidoArtista(rs.getString("apellidoArtista"));
                  ar.setNombreArtistico(rs.getString("nombreArtistico"));
                  ar.setFechaNacimiento(rs.getString("fechaNacimiento"));
                  ar.setEmailArtista(rs.getString("emailArtista"));
                  ar.setEstadoArtista(rs.getBoolean("estadoArtista"));
                  artistaList.add(ar);
              }
              ps.close();
              System.out.println("Consulta Exitosa");
           } catch (Exception e) {
               System.out.println("La consulta no pudo ser ejecutada" + e.getMessage() .toString());
          }
        finally{
            con.close();
        }
        return artistaList;
    }

         //ELIMINAR

    public void Eliminar(int idArtista) throws SQLException{
        sql="DELETE FROM Artista WHERE idArtista=" +idArtista;

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

    //ESTADO-------------------------------------------------------------------------

    public void estado(Boolean estadoArtista, int idArtista) throws SQLException{
        sql="UPDATE Artista SET estadoArtista="+estadoArtista+" WHERE idArtista="+idArtista;  //Variable para sql
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se cambio el estado a" +estadoArtista+"Correctamente");

    } catch (Exception e) {
        System.out.println("Error en el cambio de estado" +e.getMessage().toString());
    }
    finally{
        con.close(); //cerrando sesion
    }

    }
    //EDITAR-------------------------------------------------------------------------------

    public List<artistaVo>Listarartista(int idArtista) throws SQLException{
        List<artistaVo> artista= new ArrayList<>();
    sql="SELECT * FROM Artista WHERE idArtista="+idArtista; //Variable para la bd
    try {
        con=conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        rs=ps.executeQuery(sql);
       while (rs.next()) {
           artistaVo ar = new artistaVo();
           //Escribir el setter en cada valor encontrado
           ar.setIdArtista(rs.getInt("idArtista"));
           ar.setNumeroDocumento(rs.getString("numeroDocumento"));
           ar.setTipoDocumento(rs.getString("tipoDocumento"));
           ar.setNombreArtista(rs.getString("nombreArtista"));
           ar.setApellidoArtista(rs.getString("apellidoArtista"));
           ar.setNombreArtistico(rs.getString("nombreArtistico"));
           ar.setFechaNacimiento(rs.getString("fechaNacimiento"));
           ar.setEmailArtista(rs.getString("emailArtista"));
           ar.setEstadoArtista(rs.getBoolean("estadoArtista"));
           artista.add(ar);
       }
       ps.close();
       System.out.println("Consulta exitosa a Artista especifico");
    } catch (Exception e) {
       System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString()); //Error
    }
    finally{
        con.close();
    }
    return artista;

    }
    //ACTUALIZAR-------------------------------------------------------------------------------------
    public int Actualizar(artistaVo artista) throws SQLException{
        sql="UPDATE Artista SET numeroDocumento=?,tipoDocumento=?, nombreArtista=?, apellidoArtista=?, nombreArtistico=?, fechaNacimiento=?, emailArtista=?, estadoArtista=? WHERE idArtista=?";//variable para el sql
    
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); 
            System.out.println(ps);
            ps.setString(1, artista.getNumeroDocumento());
            ps.setString(2, artista.getTipoDocumento());
            ps.setString(3, artista.getNombreArtista());
            ps.setString(4, artista.getApellidoArtista());
            ps.setString(5, artista.getNombreArtistico());
            ps.setString(6, artista.getFechaNacimiento());
            ps.setString(7, artista.getEmailArtista());
            ps.setBoolean(8, artista.getEstadoArtista());
            ps.setInt(9, artista.getIdArtista());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el Artista correctamente");
            
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
    
        finally{
            con.close();//cerrando conexión
        }
        return ar; 
    }
          }


