<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
     <!-- Favicon-->
     <link rel="icon" type="image/x-icon" href="../assets/img/123.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar</title>
    <link rel="stylesheet" href="css/vistas.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
</head>
<body>
    <form action="albumController" method="POST">
<header> <div class="arriba"><a href="menu.jsp"><img src="img/atras.png" alt=""></a></div></header>
        <div class="form">
            <c:forEach var="album" items="${albumL}">
                <h2 class="editar">Editar el album  "${album.getNombreAlbum()}"</h2>
                  
                    <div class="grupo">
                    <input type="text" name="nombreAlbum" id="nombreAlbum" value="${album.getNombreAlbum()}" required><span class="barra"></span>
                    <label for="nombreAlbum">NOMBRE ALBUM:</label>
                    </div>
                    
                    <div class="grupo">
                    <input hidden type="number"  name="anoPublicado" id="anoPublicado" value="${album.getanoPublicado()}" required><span class="barra"></span>
                    <label for="anoPublicado">AÑO PUBLICADO:</label>
                    </div>

                <div class="grupo">
                    <input hidden type="checkbox" name="estadoAlbum" id="estadoAlbum" value="${album.getEstadoAlbum()}" checked class="form-check-input">
                    <label hidden for="chkestado"> Activo</label>
                    <label for="estadoAlbum">ESTADO DEL ALBUM:</label>
                </div>
                <div class="botones">
                <button type="submit" name="accion" value="Edit">Editar</button>
                 </div>
            </div>
        </div>
      </form>
    </c:forEach>
    <script src="main.js"></script>
</body>
</html>