/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DataResponse;
import Model.RecibosFormaPagoDTO;
import Model.VentasArticulosDTO;
import Service.VentaService;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;


@WebServlet("/apiVentas")
public class controller extends HttpServlet {

    private VentaService ventasService;

    @Override
    public void init() throws ServletException {
        super.init();
        ventasService = new VentaService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            double totalVentas = ventasService.getTotalVentas();
            int numeroVentas = ventasService.getNumeroVentas();
            double totalRecibos = ventasService.getTotalRecibos();
            List<VentasArticulosDTO> ventasPorArticulo = ventasService.getVentasPorArticulo();
            List<RecibosFormaPagoDTO> recibosFormaPago = ventasService.getRecibosPorFormaPago();
            DataResponse dataResponse = new DataResponse(totalVentas, numeroVentas, totalRecibos, ventasPorArticulo, recibosFormaPago);

            Gson gson = new Gson();
            String json = gson.toJson(dataResponse);

            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
          
        } catch (SQLException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
