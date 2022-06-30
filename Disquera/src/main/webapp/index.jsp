<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MAGIC RECORDS</title>
    <link rel="shortcut icon" href="./images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/estilos.css">

    <meta name="theme-color" content="#2091F9">

    <meta name="title" content="Aprende CSS desde cero">
    <meta name="description"
        content="Hola, soy una descripción que verás cuando busques algo de mi temática en Google.">


    <meta property="og:type" content="website">
    <meta property="og:url" content="https://alexcgdesign.github.io">
    <meta property="og:title" content="Aprende CSS desde cero">
    <meta property="og:description"
        content="Hola, soy una descripción que verás cuando busques algo de mi temática en Google.">
    <meta property="og:image" content="https://alexcgdesign.github.io/img/css.jpg">

    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:url" content="https://www.jordanalex.com/">
    <meta property="twitter:title" content="Aprende CSS desde cero">
    <meta property="twitter:description"
        content="Hola, soy una descripción que verás cuando busques algo de mi temática en Google.">
    <meta property="twitter:image" content="https://alexcgdesign.github.io/img/css.jpg">
</head>

<body>

    <header class="hero">
        <nav class="nav container">
            <div class="nav__logo">
                <h2 class="nav__title">MAGIC RECORDS</h2>
            </div>

            <ul class="nav__link nav__link--menu">
                <li class="nav__items">
                    <a href="index.jsp" class="nav__links">Inicio</a>
                </li>
                <li class="nav__items">
                    <a href="#" class="nav__links">Acerca de</a>
                </li>
                <li class="nav__items">
                    <a href="#" class="nav__links">Contacto</a>
                </li>
                <li class="nav__items">
                    <a href="#" class="nav__links">Blog</a>
                </li>

                <li class="nav__items">
                    <a href="menu.jsp" class="nav__links">Menu</a>
                </li>

                <img src="img/close.svg" class="nav__close">
            </ul>

            <div class="nav__menu">
                <img src="img/menu.svg" class="nav__img">
            </div>
        </nav>

        <section class="hero__container container">
            <h1 class="hero__title">MAGIC RECORDS</h1>
            <p class="hero__paragraph">"Mi música es compleja, tiene matices de mi y mi gente, mis sentimientos, mis penas, mis dudas y, por supuesto, lo que diga mi disquera.“</p>
            <a href="menu.jsp" class="cta">Comienza ahora</a>
        </section>
    </header>

    <main>
        <section class="container about">
            <h2 class="subtitle">Magic Records</h2>
            <p class="about__paragraph">En M.RCORDS brindamos soluciones musicales para artistas, músicos y creadores de contenido.</p>

            <div class="about__main">
                <article class="about__icons">
                    <img src="img/shapes.svg" class="about__icon">
                    <h3 class="about__title">Desarrolle y gestione su music carrera</h3>
                    <p class="about__paragrah">Tu carrera musical no se limita a descargas y transmitir. herramientas y servicios digitales pueden ayudarle: <br>
                    - Mejore la calidad de sus productos musicales <br>
                    -Amplie su base de fans</p>
                </article>

                <article class="about__icons">
                    <img src="img/paint.svg" class="about__icon">
                    <h3 class="about__title">Recoger regalías de composición y licencia tu música</h3>
                    <p class="about__paragrah">Cuando se venden, streamed, o actuada en vivo, las canciones  que escribes generan muchas regalías que no puedes conseguir sin un administrador de publicación
                        MagicDiffusion te los transfiere con la ayuda de nuestro sello musical.
                    </p>
                </article>

                <article class="about__icons">
                    <img src="img/code.svg" class="about__icon">
                    <h3 class="about__title">VAMOS AYUDARTE A: </h3>
                    <p class="about__paragrah">
                        - Ayudarle a colocar sus proyectos en comerciales, películas, TV y más. <br>
                        -Registre su musica en todo el mundo en 60+ paises.</p>
                </article>
            </div>
        </section>

         
</body>

</html>