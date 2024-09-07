/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.addEventListener('DOMContentLoaded', () => {
    fetchData();
});

async function fetchData() {
    try {
        const responses = await Promise.all([
            fetch('/api/ventas'),
            fetch('/api/numeroVentas'),
            fetch('/api/recibos'),
            fetch('/api/ventasPorArticulo'),
            fetch('/api/recibosPorFormaPago')
        ]);

        const [ventasData, numeroVentasData, recibosData, ventasPorArticuloData, recibosPorFormaPagoData] = await Promise.all(
            responses.map(response => response.json())
        );

        document.getElementById('totalVentas').textContent = ventasData.totalVentas;
        document.getElementById('numeroVentas').textContent = numeroVentasData.numeroVentas;
        document.getElementById('totalRecibos').textContent = recibosData.totalRecibos;

        const ventasPorArticuloList = document.getElementById('ventasPorArticulo');
        ventasPorArticuloData.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `${item.articulo}: ${item.numeroVentas}`;
            ventasPorArticuloList.appendChild(li);
        });

        const recibosPorFormaPagoList = document.getElementById('recibosPorFormaPago');
        recibosPorFormaPagoData.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `${item.formaPago}: ${item.numeroRecibos}`;
            recibosPorFormaPagoList.appendChild(li);
        });

    } catch (error) {
        console.error('Error', error);
       }
}
