<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
     <!-- Favicon-->
     <link rel="icon" type="image/x-icon" href="../assets/img/123.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar</title>
    <link rel="stylesheet" href="css/Listar.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
</head>
<body>
  <div class="arriba">
   <a href="menu.jsp"><img src="img/atras.png" alt=""></a>
    <h2>Formulario Para el registro de Album</h2>
  </div>
<table>
    <thead>
    <tr>
        <th> ID</th>
        <th>NOMBRE</th>
        <th>AÑO</th>
        <th>ESTADO</th>
        <th>CAMBIO DE ESTADO</th>
        <th>ACCIONES</th>
    </tr>
</thead>
    <c:forEach var="albumL" items="${albumL}"> 
        <tr>
            <td>${albumL.getIdAlbum()}</td><!--ID-->
            <td>${albumL.getNombreAlbum()}</td><!--Nombre-->
            <td>${albumL.getanoPublicado()}</td><!--Año-->
        
        <c:if test="${albumL.getEstadoAlbum() == true}">
           
            <td><span>Activo</span></td> 
        </c:if>
        <c:if test="${albumL.getEstadoAlbum() == false}">
            <td><span>Inactivo</span></td> 
        </c:if>
        <td>
        <c:if test="${albumL.getEstadoAlbum() == true}">

                <a href="albumController?accion=estadoAlbum&idAlbum=${albumL.getIdAlbum()}&estadoAlbum=false"><button class="acciones btn" type="button">Inactivar</button> </a> 

        </c:if>
        <c:if test="${albumL.getEstadoAlbum() == false}">

                <a href="albumController?accion=estadoAlbum&idAlbum=${albumL.getIdAlbum()}&estadoAlbum=true"><button class="acciones btn" type="button">Activar</button> </a>

        </c:if>
    </td> 
        <td>
            <a href="albumController?accion=Editar&idAlbum=${albumL.getIdAlbum()}"><button class="acciones btn" type="button" value="Editar" name="accion">Editar</button> </a>
        
            <a onclick="return desea_Eliminar()" href="albumController?accion=Eliminar&idAlbum=${albumL.getIdAlbum()}"><button class="acciones btn" type="button">Eliminar</button> </a>
        </td>
    </tr>
</c:forEach> 
</table>
         
      <script>

        function desea_Eliminar(){
            var mostrar = confirm("Estas seguro que deseas eliminar el Album?")

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