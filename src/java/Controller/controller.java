/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RecibosDTO;
import Model.RecibosFormaPagoDTO;
import Model.TotalVentasDTO;
import Model.VentasArticulosDTO;
import Model.VentasDTO;
import Service.VentaService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/*")
public class controller extends HttpServlet {

    private VentaService ventaService = new VentaService();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        String[] pathParts = path.split("/");
        String endpoint = pathParts[pathParts.length - 1];

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        switch (endpoint) {
            case "ventas":
                int totalVentas = ventaService.getTotalVentas();
                out.print(objectMapper.writeValueAsString(new VentasDTO(totalVentas)));
                break;

            case "numeroVentas":
                int numeroVentas = ventaService.getNumeroVentas();
                out.print(objectMapper.writeValueAsString(new TotalVentasDTO(numeroVentas)));
                break;

            case "recibos":
                int totalRecibos = ventaService.getTotalRecibos();
                out.print(objectMapper.writeValueAsString(new RecibosDTO(totalRecibos)));
                break;

            case "ventasPorArticulo":
                List<VentasArticulosDTO> ventasPorArticulo = ventaService.getVentasPorArticulo();
                out.print(objectMapper.writeValueAsString(ventasPorArticulo));
                break;

            case "recibosPorFormaPago":
                List<RecibosFormaPagoDTO> recibosPorFormaPago = ventaService.getRecibosPorFormaPago();
                out.print(objectMapper.writeValueAsString(recibosPorFormaPago));
                break;

        }

        out.flush();
        out.close();
    }
}
