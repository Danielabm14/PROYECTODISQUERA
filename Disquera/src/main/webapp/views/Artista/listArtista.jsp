<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
     <!-- Favicon-->
     <link rel="icon" type="image/x-icon" href="../assets/img/123.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Buscar</title>
    <link rel="stylesheet" href="css/Listar.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="arriba">
        <a href="menu.jsp"><img src="img/atras.png" alt=""></a>
         <h2>Formulario Para el registro de Artista</h2>
       </div>
     <table>
         <thead>
         <tr>
             <th> ID</th>
             <th>NUMERO DOCUMENTO</th>
             <th>TIPO DOCUMENTO</th>
             <th>NOMBRE ARTISTA</th>
             <th>APELLIDO ARTISTA</th>
             <th>NOMBRE ARTISTICO</th>
             <th>FECHA NACIMIENTO</th>
             <th>EMAIL</th>
             <th>ESTADO</th>
             <th>CAMBIO DE ESTADO</th>
             <th>ACCIONES</th>
         </tr>
     </thead>
         <c:forEach var="artistaL" items="${artistaL}"> 
             <tr>
                 <td>${artistaL.getIdArtista()}</td><!--ID-->
                 <td>${artistaL.getNumeroDocumento()}</td><!--Nit-->
                 <td>${artistaL.getTipoDocumento()}</td><!--Nombre-->
                 <td>${artistaL.getNombreArtista()}</td><!--Telefono-->
                 <td>${artistaL.getApellidoArtista()}</td><!--Direccion-->
                 <td>${artistaL.getNombreArtistico()}</td>
                 <td>${artistaL.getFechaNacimiento()}</td>
                 <td>${artistaL.getEmailArtista()}</td>
             
             <c:if test="${artistaL.getEstadoArtista() == true}">
                
                 <td><span>Activo</span></td> 
             </c:if>
             <c:if test="${artistaL.getEstadoArtista() == false}">
                 <td><span>Inactivo</span></td> 
             </c:if>
             <td>
             <c:if test="${artistaL.getEstadoArtista() == true}">
                     <a href="artistacontroller?accion=estadoArtista&idArtista=${artistaL.getIdArtista()}&estadoArtista=false"><button class="acciones btn" type="button">Inactivar</button> </a> 
             </c:if>
             <c:if test="${artistaL.getEstadoArtista() == false}">
                     <a href="artistacontroller?accion=estadoArtista&idArtista=${artistaL.getIdArtista()}&estadoArtista=true"><button class="acciones btn" type="button">Activar</button> </a>
             </c:if>
            </td>
             <td>
                 <a href="artistacontroller?accion=Editar&idArtista=${artistaL.getIdArtista()}"><button class="acciones btn" type="button" value="Editar" name="accion">Editar</button> </a>
             
                 <a onclick="return desea_Eliminar()"  href="artistacontroller?accion=Eliminar&idArtista=${artistaL.getIdArtista()}"><button class="acciones btn" type="button">Eliminar</button> </a>
             </td>
         </tr>
     </c:forEach> 
   
    </table>
    <script>

        function desea_Eliminar(){
            var mostrar = confirm("Estas seguro que deseas eliminar el artista?")

            if(mostrar == true){
                return true;
            }else{
                return false;
            }
        }

      </script>  
    <script src="main.js"></script>
</body>
</html>