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
        const response = await fetch('/WebAppTituana/apiVentas'); 
        if (!response.ok) {
            throw new Error(response.statusText);
        }
        const data = await response.json(); 

        document.getElementById('totalVentas').textContent = data.totalVentas;
        document.getElementById('numeroVentas').textContent = data.numeroVentas;
        document.getElementById('totalRecibos').textContent = data.totalRecibos;

        const ventasPorArticuloList = document.getElementById('ventasPorArticulo');
        ventasPorArticuloList.innerHTML = '';
        data.ventasPorArticulo.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `${item.articulo}: ${item.numeroVentas}`;
            ventasPorArticuloList.appendChild(li);
        });

        const recibosFormaPagoList = document.getElementById('recibosFormaPago');
        recibosFormaPagoList.innerHTML = ''; 
        data.recibosFormaPago.forEach(item => {
            const li = document.createElement('li');
            li.textContent = `${item.formaPago}: ${item.numeroRecibos}`;
            recibosFormaPagoList.appendChild(li);
        });

    } catch (error) {
        console.error('Error', error);
    }
}