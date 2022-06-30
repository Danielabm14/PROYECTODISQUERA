package controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.disquera.disqueraDao;
import model.disquera.disqueraVo;


public class disqueracontroller extends HttpServlet {

    disqueraDao dDao= new disqueraDao();
    disqueraVo  dVo= new disqueraVo();


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
             case "estadoDisquera":
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
         

        switch(accion){
            case "add":
                add(req,resp);
            break;

           case "Edit":
                Edit(req, resp);
                break;
        }
    }

        //REGISTRAR--------------------------------------------------------------------------
    
        private void Formulario(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/Disquera/addDisquera.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
            }
        }

        //LISTAR -------------------------------------------------------------------------------------
        private void Listar(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List disqueraList=dDao.Listar();
                req.setAttribute( "disqueraL", disqueraList);
                req.getRequestDispatcher("views/Disquera/listDisquera.jsp").forward(req, resp);
                System.out.println("Datos Listados Correctamente");
            } catch (Exception e) {
               System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
            }
        }

        //ELIMINAR---------------------------------------------------------------------------------
        private void Eliminar(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("idDisquera")!=null){
                dVo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera"))); //Cambiar de string a int
            }
            try {
                dDao.Eliminar(dVo.getIdDisquera());;
                System.out.println("El estado se cambio exitosamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }

        //ESTADO--------------------------------------------------------------------------------
        private void estado(HttpServletRequest req, HttpServletResponse resp) {
            if (req.getParameter("idDisquera")!=null) {
                dVo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera"))); //cambiar de string a int
            }
            if (req.getParameter("estadoDisquera")!=null) {
                dVo.setEstadoDisquera(Boolean.parseBoolean(req.getParameter("estadoDisquera"))); //Cambiar de string  a boolean
            }
            try {
                dDao.estado(dVo.getEstadoDisquera(), dVo.getIdDisquera());
                System.out.println("El estado se cambio Exitosamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado "+e.getMessage().toString());
            }
        }
        //EDITAR---------------------------------------------------------------------------------
        private void Editar(HttpServletRequest req, HttpServletResponse resp) {
            System.out.println("Entro al editar");  
            if (req.getParameter("idDisquera")!=null) {
                dVo.setIdDisquera(Integer.parseInt(req.getParameter("idDisquera")));
                try {
                    List disqueraList=dDao.Listardisquera(dVo.getIdDisquera());   
                    req.setAttribute("disqueraL", disqueraList);
                    req.getRequestDispatcher("views/Disquera/editDisquera.jsp").forward(req, resp);
                } catch (Exception e) {
                   System.out.println("Hay problemas al listar los datos" +e.getMessage().toString());
                }
                
            }
        }
    
//METODOS DEL DO POST-------------------------------------------------------------------

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("nitDisquera")!=null){
            dVo.setNitDisquera(req.getParameter("nitDisquera"));
        }
        if(req.getParameter("nombreDisquera")!=null){
            dVo.setNombreDisquera(req.getParameter("nombreDisquera"));
        }

        if(req.getParameter("telefonoDisquera")!=null){
            dVo.setTelefonoDisquera(req.getParameter("telefonoDisquera"));
        }
        if(req.getParameter("direccionDisquera")!=null){
            dVo.setDireccionDisquera(req.getParameter("direccionDisquera"));
        }
            
            if(req.getParameter("estadoDisquera")!=null){
                dVo.setEstadoDisquera(true);
            }
            else{
                dVo.setEstadoDisquera(false);
            }

            try {
                dDao.Formulario(dVo);
                System.out.println("Disquera insertada correctamente");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en la inserción del registro "+e.getMessage().toString());
            }
    }

    private void Edit(HttpServletRequest req, HttpServletResponse resp) {
      
            if (req.getParameter("nitDisquera")!=null) {
                dVo.setNitDisquera(req.getParameter("nitDisquera"));
            }
            if (req.getParameter("nombreDisquera")!=null) {
                dVo.setNombreDisquera(req.getParameter("nombreDisquera"));
            }
            if (req.getParameter("telefonoDisquera")!=null) {
                dVo.setTelefonoDisquera(req.getParameter("telefonoDisquera"));
            }
            if (req.getParameter("direccionDisquera")!=null) {
                dVo.setDireccionDisquera(req.getParameter("direccionDisquera"));
            }
            if (req.getParameter("estadoDisquera")!=null) {
                dVo.setEstadoDisquera(true);
            }
            else{
                dVo.setEstadoDisquera(false);
            }
            try {
                dDao.Actualizar(dVo);
                System.out.println("Editar el registro de Disquera");
                Listar(req, resp);
            } catch (Exception e) {
                System.out.println("Error al editar del registro "+e.getMessage().toString());
            }
    }



    }





