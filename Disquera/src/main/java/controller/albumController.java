package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.album.albumDao;
import model.album.albumVo;
    
public class albumController extends HttpServlet{
    albumVo aVo= new albumVo();
    albumDao aDao= new albumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String accion = req.getParameter("accion");
        System.out.println(accion);   
         
        switch (accion) {

             case "Formulario":
                 Formulario(req,resp);
                 break;
            case "Listar":
                Listar(req, resp);
                break;

             case "Eliminar":
                Eliminar(req,resp);
                break;
             case "estadoAlbum":
                estado(req, resp);
                break;
                
            case "Editar":
                Editar(req, resp);
                break;
             }
         }

    


        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doPost");
        String accion = req.getParameter("accion");
        System.out.println(accion);   
        switch(accion){
            case "add":
                add(req,resp);
            break;

            case "Edit":
                Edit(req, resp);
                break;
        }
    }


     //LISTAR-------------------------------------------------------

    
    private void Listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List albumList=aDao.Listar();
            req.setAttribute( "albumL", albumList);
            req.getRequestDispatcher("views/album/listAlbum.jsp").forward(req, resp);
            System.out.println("Datos Listados Correctamente");
        } catch (Exception e) {
           System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
        }

    }

    //ELIMINAR --------------------------------------------------------

    private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum"))); //Cambiar de string a int
        }
        try {
            aDao.Eliminar(aVo.getIdAlbum());;
            System.out.println("El estado se cambio exitosamente");
            Listar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
       
        // REGISTRAR------------------------------------------------------------

        private void Formulario(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/album/addAlbum.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
            }
        }

        // ESTADO------------------------------------------------------------------

        private void estado(HttpServletRequest req, HttpServletResponse resp) {
            if (req.getParameter("idAlbum")!=null) {
                aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum"))); //cambiar de string a int
            }
            if (req.getParameter("estadoAlbum")!=null) {
                aVo.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum"))); //Cambiar de string  a boolean
            }
            try {
                aDao.estado(aVo.getEstadoAlbum(), aVo.getIdAlbum());
                System.out.println("El estado se cambio Exitosamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }
    
     // EDITAR ----------------------------------------------------------------------

                
        private void Editar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.println("Entro al editar");
            if (req.getParameter("idAlbum")!=null) {
                aVo.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
                try {
                    List albumList=aDao.Listaralbum(aVo.getIdAlbum());   
                    req.setAttribute("albumL", albumList);
                    req.getRequestDispatcher("views/album/editAlbum.jsp").forward(req, resp);
                } catch (Exception e) {
                   System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
                }
                
            }
        }
    
       

    
            //METODOS DEL DOPOST --------------------------------------------------

        private void add(HttpServletRequest req, HttpServletResponse resp) {
            
            if(req.getParameter("nombreAlbum")!=null){
                aVo.setNombreAlbum(req.getParameter("nombreAlbum"));
            }

            if(req.getParameter("anoPublicado")!=null){
                aVo.setAnoPublicado(req.getParameter("anoPublicado"));
            }
                
                if(req.getParameter("estadoAlbum")!=null){
                    aVo.setEstadoAlbum(true);
                }
                else{
                    aVo.setEstadoAlbum(false);
                }

                try {
                    aDao.Formulario(aVo);
                    System.out.println("Album insertado correctamente");
                    Listar(req, resp);
                } catch (Exception e) {
                    System.out.println("Error en la inserción del registro "+e.getMessage().toString());
                }
           
        }

        // EDIT -----------------------------------------------------------------------------



        private void Edit(HttpServletRequest req, HttpServletResponse resp) {

                if (req.getParameter("nombreAlbum")!=null) {
                    aVo.setNombreAlbum(req.getParameter("nombreAlbum"));
                }
                if (req.getParameter("anoPublicado")!=null) {
                    aVo.setAnoPublicado(req.getParameter("anoPublicado"));
                }
                if (req.getParameter("estadoAlbum")!=null) {
                    aVo.setEstadoAlbum(true);
                }
                else{
                    aVo.setEstadoAlbum(false);
                }
                try {
                    aDao.Actualizar(aVo);
                    System.out.println("Editar el registro de album");
                    Listar(req, resp);
                } catch (Exception e) {
                    System.out.println("Error al editar del registro "+e.getMessage().toString());
                }
                
            


                
        }
}