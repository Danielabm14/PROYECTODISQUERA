<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - youtube.com/codingnepal -->
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">  
    <title>Menu</title>
    <link rel="stylesheet" href="css/estilosmenu.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Iconscout Link For Icons -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
  </head>
  <body>
    <div class="wrapper">
      <div class="content">
        <ul class="menu">

            <!--DISQUERA-->
            <li class="item share">

                <div>
      
                  <span>Disquera</span>
                </div>
                <i class="uil uil-angle-right"></i>
                <ul class="share-menu">
                  <li class="item">
                    <!--iconos-->
                    <a  href="disqueracontroller?accion=Formulario"><span>Agregar Disquera</span></a>
                  </li>
                  <li class="item">
                    
                    <a href="disqueracontroller?accion=Listar"><span>Listar Disquera</span></a>
                  </li>
                </ul>
              </li>

              <!--ARTISTA-->

          <li class="item share">
            <div>
     
              <span>Artista</span>
            </div>
            <i class="uil uil-angle-right"></i>
            <ul class="share-menu">
              <li class="item">
                <!--iconos-->
                <a href="artistacontroller?accion=Formulario"><span>Agregar Artista</span></a>
              </li>
              <li class="item">
                
                <a href="artistacontroller?accion=Listar"><span>Listar Artista</span></a>
              </li>
            </ul>
          </li>

<!--album-->
            <li class="item share">

                <div>
                
                <span>Album</span>
                </div>
                <i class="uil uil-angle-right"></i>
                <ul class="share-menu">
                <li class="item">
                    <!--iconos-->
                    <a href="albumController?accion=Formulario"><span>Agregar Album</span></a>
                </li>
                <li class="item">
                    
                    <a href="albumController?accion=Listar"><span>Listar Album</span></a>
                </li>
                </ul>
            </li>
          
        </div>
      </div>
    </div>

    <h1>DALE CLICK DERECHO DONDE QUIERAS</h1>
    <script src="js/vistamenu.js"></script>
  </body>
</html>

