<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
     <!-- Favicon-->
     <link rel="icon" type="image/x-icon" href="../assets/img/123.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDITAR</title>
    <link rel="stylesheet" href="css/vistas.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
</head>
<body>
        <form action="artistacontroller" method="POST">
            <header> <div class="arriba"><a href="menu.jsp"><img src="img/atras.png" alt=""></a></div></header>
        <div class="form">
            <c:forEach var="artista" items="${artistaL}">
            <h1>Edita el artista "${artista.getNombreArtista()}"</h1>
            <div class="grupo">
                <input type="text" name="idArtista" id="idArtista" value="${artista.getIdArtista()}" required><span class="barra"></span>
                <label for="">ID DEL ARTISTA</label>
            </div>

            <div class="grupo">
                <input type="text" name="numeroDocumento" id="numeroDocumento" value="${artista.getNumeroDocumento()}" required><span class="barra"></span>
                <label for="">NUMERO DE DOCUMENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="tipoDocumento" id="tipoDocumento" value="${artista.getTipoDocumento()}" required><span class="barra"></span>
                <label for="">TIPO DE DOCUMENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreArtista" id="nombreArtista" value="${artista.getNombreArtista()}" required><span class="barra"></span>
                <label for="">NOMBRE DEL ARTISTA</label>
            </div>

            <div class="grupo">
                <input type="text" name="apellidoArtista" id="apellidoArtista" value="${artista.getApellidoArtista()}" required><span class="barra"></span>
                <label for="">APELLIDO DEL ARTISTA</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreArtistico" id="nombreArtistico" value="${artista.getNombreArtistico()}" required><span class="barra"></span>
                <label for="">NOMBRE ARTISTICO</label>
            </div>

            <div class="grupo">
                <input type="text" name="fechaNacimiento" id="fechaNacimiento" value="${artista.getFechaNacimiento()}" required><span class="barra"></span>
                <label for="">FECHA DE NACIMIENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="emailArtista" id="emailArtista" value="${artista.getEmailArtista()}" required><span class="barra"></span>
                <label for="">EMAIL</label>
            </div>

            <div class="grupo">
                <input type="text" name="estadoArtista" id="estadoArtista" value="${artista.getEstadoArtista()}" required><span class="barra"></span>
                <label hidden for="chkestado"> Activo</label>
                <label for="">ESTADO</label>
            </div>
            
            <div class="botones">
            <button type="submit" name="accion" value="Edit">Editar</button>       
            </div>       
    </form>
</c:forEach>
</div>
    <script src="main.js"></script>
</body>
</html>