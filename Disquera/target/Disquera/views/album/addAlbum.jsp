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
    <form action="albumController" method="POST">
        <header>
            <div class="arriba"><a href="menu.jsp"><img src="img/atras.png" alt=""></a><h1>AGREGA TU ALBUM</h1></div>
        </header>
            <div class="form">
                <div class="grupo">
                    <input type="text" name="nombreAlbum" id="nombreAlbum" required><span class="barra"></span>
                    <label for="nombreAlbum">NOMBRE DEL ALBUM</label>
                </div>
    
                <div class="grupo">
                    <input type="number" name="anoPublicado" id="anoPublicado" required><span class="barra"></span>
                    <label for="anoPublicado">AÑO PUBLICADO</label>
                </div>
               
                <div class="grupo">
                    <label for="estadoAlbum">Estado Album</label>
                    <input type="checkbox" name="estadoAlbum" id="estadoAlbum" checked class="form-check-input">
                    <label for="chkestado"> Activo</label>
                </div>
                
                <div class="botones"></div>
                <button type="submit" value="Limpiar">Limpiar</button>
                <button type="submit" name="accion" value="add">Registrar</button>
            </div>
    </form>
    <script src="main.js"></script>
</body>
</html>