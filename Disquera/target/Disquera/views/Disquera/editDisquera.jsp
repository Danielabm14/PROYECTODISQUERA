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
    <form action="disqueracontroller" method="POST" id="form">
    <header> <div class="arriba"><a href="menu.jsp"><img src="img/atras.png" alt=""></a></div></header>
        <div class="form">
            <c:forEach var="disquera" items="${disqueraL}">
            <h1>Edita la disquera "${disquera.getNombreDisquera()}"</h1>

            <div class="grupo">
                <input type="text" name="nitDisquera" id="nitDisquera" value="${disquera.getNitDisquera()}" required><span class="barra"></span>
                <label for="">NIT DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreDisquera" id="nombreDisquera" value="${disquera.getNombreDisquera()}" required><span class="barra"></span>
                <label for="">NOMBRE DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input hidden type="tel"  name="telefonoDisquera" id="telefonoDisquera" value="${disquera.getTelefonoDisquera()}" required><span class="barra"></span>
                <label for="">TELEFONO DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input hidden type="text"  name="direccionDisquera" id="direccionDisquera" value="${disquera.getDireccionDisquera()}" required><span class="barra"></span>
                <label for="">DIRECCIÓN DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input hidden type="checkbox" name="estadoDisquera" id="estadoDisquera" value="${disquera.getEstadoDisquera()}" checked class="form-check-input">
                <label hidden for="chkestado"> Activo</label>
                <label for="">ESTADO</label>
            </div>
            <div class="botones">
            <button type="submit" name="accion" value="Edit">Editar</button> 
             </div>
            </div>
    </form>
</c:forEach>
    <script src="main.js"></script>
</body>
</html>