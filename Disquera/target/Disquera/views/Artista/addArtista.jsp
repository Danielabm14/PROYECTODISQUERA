<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
     <!-- Favicon-->
     <link rel="icon" type="image/x-icon" href="../assets/img/123.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar</title>
    <link rel="stylesheet" href="css/vistas.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
</head>
<body>
    <form action="artistacontroller" method="POST" id="form">
    <header>
        <div class="arriba"><a href="menu.jsp"><img src="img/atras.png" alt=""></a><h1>AGREGA AL ARTISTA</h1></div>
    </header>
        <div class="form">
        
            <div class="grupo">
                <input type="text" name="numeroDocumento" id="numeroDocumento" required><span class="barra"></span>
                <label for="">NUMERO DE DOCUMENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="tipoDocumento" id="tipoDocumento" required><span class="barra"></span>
                <label for="">TIPO DE DOCUMENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreArtista" id="nombreArtista" required><span class="barra"></span>
                <label for="">NOMBRE DEL ARTISTA</label>
            </div>

            <div class="grupo">
                <input type="text" name="apellidoArtista" id="apellidoArtista" required><span class="barra"></span>
                <label for="">APELLIDO DEL ARTISTA</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreArtistico" id="nombreArtistico" required><span class="barra"></span>
                <label for="">NOMBRE ARTISTICO</label>
            </div>

            <div class="grupo">
                <input type="date" name="fechaNacimiento" id="fechaNacimiento" required><span class="barra"></span>
                <label for="">FECHA DE NACIMIENTO</label>
            </div>

            <div class="grupo">
                <input type="text" name="emailArtista" id="emailArtista" required><span class="barra"></span>
                <label for="">EMAIL</label>
            </div>

            <div class="grupo">
                <input type="checkbox" name="estadoArtista" id="estadoArtista" checked class="form-check-input" required><span class="barra"></span>
                <label for="">ESTADO</label>
            </div>
            
            <div class="botones"></div>
            <button type="submit" name="accion" value="add">Agregar</button>     
        </div>  
    </form>
    
    <script src="main.js"></script>
</body>
</html>