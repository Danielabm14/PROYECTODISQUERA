package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.artista.artistaDao;
import model.artista.artistaVo;

public class artistacontroller extends HttpServlet {
    
    artistaDao arDao = new artistaDao();
    artistaVo  arVo = new artistaVo();
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
            case "estadoArtista":
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
        //REGISTRAR-------------------------------------------------------------------

        private void Formulario(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/Artista/addArtista.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
            }
        }

        //LISTAR----------------------------------------------------------------------
        private void Listar(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List artistaList=arDao.Listar();
                req.setAttribute( "artistaL", artistaList);
                req.getRequestDispatcher("views/Artista/listArtista.jsp").forward(req, resp);
                System.out.println("Datos Listados Correctamente");
            } catch (Exception e) {
               System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
            }
        }

        //ELIMINAR--------------------------------------------------------------------

         private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("idArtista")!=null){
                arVo.setIdArtista(Integer.parseInt(req.getParameter("idArtista"))); //Cambiar de string a int
            }
            try {
                arDao.Eliminar(arVo.getIdArtista());;
                System.out.println("El estado se cambio exitosamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }

        //ESTADO----------------------------------------------------------------------
        private void estado(HttpServletRequest req, HttpServletResponse resp) {
            if (req.getParameter("idArtista")!=null) {
                arVo.setIdArtista(Integer.parseInt(req.getParameter("idArtista"))); //cambiar de string a int
            }
            if (req.getParameter("estadoArtista")!=null) {
                arVo.setEstadoArtista(Boolean.parseBoolean(req.getParameter("estadoArtista"))); //Cambiar de string  a boolean
            }
            try {
                arDao.estado(arVo.getEstadoArtista(), arVo.getIdArtista());
                System.out.println("El estado se cambio Exitosamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }

        //EDITAR----------------------------------------------------------------------

        private void Editar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.println("Entro al editar");
            if (req.getParameter("idArtista")!=null) {
                arVo.setIdArtista(Integer.parseInt(req.getParameter("idArtista")));
                try {
                    List artistaList=arDao.Listarartista(arVo.getIdArtista());   
                    req.setAttribute("artistaL", artistaList);
                    req.getRequestDispatcher("views/Artista/editArtista.jsp").forward(req, resp);
                } catch (Exception e) {
                   System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
                }
                
            }

        }
    

        // METODOS DEL DOPOST.....................................................................


        private void add(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("numeroDocumento")!=null){
                arVo.setNumeroDocumento(req.getParameter("numeroDocumento"));
            }

            if(req.getParameter("tipoDocumento")!=null){
                arVo.setTipoDocumento(req.getParameter("tipoDocumento"));
            }
            if(req.getParameter("nombreArtista")!=null){
                arVo.setNombreArtista(req.getParameter("nombreArtista"));
            }
            if(req.getParameter("apellidoArtista")!=null){
                arVo.setApellidoArtista(req.getParameter("apellidoArtista"));
            }
            if(req.getParameter("nombreArtistico")!=null){
                arVo.setNombreArtistico(req.getParameter("nombreArtistico"));
            }
            if(req.getParameter("fechaNacimiento")!=null){
                arVo.setFechaNacimiento(req.getParameter("fechaNacimiento"));
            }
            if(req.getParameter("emailArtista")!=null){
                arVo.setEmailArtista(req.getParameter("emailArtista"));
            }
                
                if(req.getParameter("estadoArtista")!=null){
                    arVo.setEstadoArtista(true);
                }
                else{
                    arVo.setEstadoArtista(false);
                }

                try {
                    arDao.Formulario(arVo);
                    System.out.println("Artista insertado correctamente");
                    Listar(req, resp);
                } catch (Exception e) {
                    System.out.println("Error en la inserción del registro "+e.getMessage().toString());
                }
        }

    

        private void Edit(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("numeroDocumento")!=null){
                arVo.setNumeroDocumento(req.getParameter("numeroDocumento"));
            }

            if(req.getParameter("tipoDocumento")!=null){
                arVo.setTipoDocumento(req.getParameter("tipoDocumento"));
            }
            if(req.getParameter("nombreArtista")!=null){
                arVo.setNombreArtista(req.getParameter("nombreArtista"));
            }
            if(req.getParameter("apellidoArtista")!=null){
                arVo.setApellidoArtista(req.getParameter("apellidoArtista"));
            }
            if(req.getParameter("nombreArtistico")!=null){
                arVo.setNombreArtistico(req.getParameter("nombreArtistico"));
            }
            if(req.getParameter("fechaNacimiento")!=null){
                arVo.setFechaNacimiento(req.getParameter("fechaNacimiento"));
            }
            if(req.getParameter("emailArtista")!=null){
                arVo.setEmailArtista(req.getParameter("emailArtista"));
            }
                
                if(req.getParameter("estadoArtista")!=null){
                    arVo.setEstadoArtista(true);
                }
                else{
                    arVo.setEstadoArtista(false);
                }

                try {
                    arDao.Actualizar(arVo);
                    System.out.println("Artista insertado correctamente");
                    Listar(req, resp);
                } catch (Exception e) {
                    System.out.println("Error en la inserción del registro "+e.getMessage().toString());
                }
        }
    
}
