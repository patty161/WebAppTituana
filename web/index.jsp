<%-- 
    Document   : index
    Created on : 7 sep. 2024, 09:27:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard de Ventas</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Dashboard de Ventas</h1>
            </header>
            <section class="info">
                <div class="info-item">
                    <h2>Ventas Totales</h2>
                    <p id="totalVentas">Cargando...</p>
                </div>
                <div class="info-item">
                    <h2>Número de Ventas</h2>
                    <p id="numeroVentas">Cargando...</p>
                </div>
                <div class="info-item">
                    <h2>Recibos Totales</h2>
                    <p id="totalRecibos">Cargando...</p>
                </div>
            </section>
            <section>
                <div class="info-item">
                    <h2>Número de Ventas por Artículo</h2>
                    <ul id="ventasPorArticulo">Cargando...</ul>
                </div>
                <div class="info-item">
                    <h2>Número de Recibos por Forma de Pago</h2>
                    <ul id="recibosFormaPago">Cargando...</ul>
                </div>
            </section>
        </div>
        <script src="script.js"></script>
    </body>
</html>

