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
    <form action="disqueracontroller" method="POST" id="form">
        <div class="form">
            <h1>Agrega la disquera</h1>
            

            <div class="grupo">
                <input type="number" name="nitDisquera" id="nitDisquera" required><span class="barra"></span>
                <label for="">NIT DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input type="text" name="nombreDisquera" id="nombreDisquera" required><span class="barra"></span>
                <label for="">NOMBRE DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input type="tel" name="telefonoDisquera" id="telefonoDisquera" required><span class="barra"></span>
                <label for="">TELEFONO DE LA DISQUERA</label>
            </div>

            <div class="grupo">
                <input type="text" name="direccionDisquera" id="direccionDisquera" required><span class="barra"></span>
                <label for="">DIRECCIÓN DE LA DISQUERA</label>
        
            </div>
            <div class="estado">
                <input type="checkbox" name="estadoDisquera" id="estadoDisquera" checked class="form-check-input">
                <label for="chkestado">Activo</label>
                
            </div>

               <div class="botones"></div>
                <button type="submit" value="Limpiar">Limpiar</button>
                <button type="submit" name="accion" value="add">Agregar</button>
            </div>
            </div>
            
    </form>
    
    <script src="main.js"></script>
</body>
</html>