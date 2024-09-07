/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author User
 */
public class DataResponse {

    private final double totalVentas;
    private final int numeroVentas;
    private final double totalRecibos;
    private final List<VentasArticulosDTO> ventasPorArticulo;
    private final List<RecibosFormaPagoDTO> recibosFormaPago;

    public DataResponse(double totalVentas, int numeroVentas, double totalRecibos, List<VentasArticulosDTO> ventasPorArticulo, List<RecibosFormaPagoDTO> recibosFormaPago) {
        this.totalVentas = totalVentas;
        this.numeroVentas = numeroVentas;
        this.totalRecibos = totalRecibos;
        this.ventasPorArticulo = ventasPorArticulo;
        this.recibosFormaPago = recibosFormaPago;
    }
}
