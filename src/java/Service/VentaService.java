/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author User
 */
import Config.DatabaseConnection;
import Model.RecibosFormaPagoDTO;
import Model.VentasArticulosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaService {

    public double getTotalVentas() throws SQLException {
        String query = "SELECT SUM(total) AS total_ventas FROM kxt_fac_venta;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getDouble("total_ventas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public int getNumeroVentas() throws SQLException {
        String query = "SELECT COUNT(*) AS numeroVentas FROM kxt_fac_venta";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("numeroVentas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
     
      public double getTotalRecibos() throws SQLException {
        String query = "SELECT SUM(valor) AS totalRecibos FROM public.kxt_fac_venta_cobro"; 
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getDouble("totalRecibos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
      
       public List<VentasArticulosDTO>getVentasPorArticulo() throws SQLException {
          String query = "SELECT artcod, articulo, COUNT(*) AS numeroVentas " +
                       "FROM kxt_fac_venta_det " +
                       "JOIN kxt_act_inventario ON kxt_fac_venta_det.art = kxt_act_inventario.id_act_inventario " +
                       "GROUP BY artcod, articulo";
        List<VentasArticulosDTO> ventasPorArticuloList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                String articulo = resultSet.getString("articulo");
                int numeroVentas = resultSet.getInt("numeroVentas");
                ventasPorArticuloList.add(new VentasArticulosDTO(articulo, numeroVentas));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventasPorArticuloList;
    }
       
        public List<RecibosFormaPagoDTO> getRecibosPorFormaPago() throws SQLException {
      String query = "SELECT f.descripcion_interno AS formaPago, COUNT(*) AS numeroRecibos " +
                       "FROM kxt_fac_venta_cobro c " +
                       "JOIN kxt_cnt_forma_pago f ON c.id_cnt_forma_pago_fk = f.id_cnt_forma_pago " +
                       "GROUP BY f.descripcion_interno";
        List<RecibosFormaPagoDTO> recibosPorFormaPagoList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) { 
                String formaPago = resultSet.getString("formaPago");
                int numeroRecibos = resultSet.getInt("numeroRecibos");
                recibosPorFormaPagoList.add(new RecibosFormaPagoDTO(formaPago, numeroRecibos));
            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recibosPorFormaPagoList;
    }
}
