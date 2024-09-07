/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
public class RecibosFormaPagoDTO {
    private String formaPago;
    private int numeroRecibos;

    public RecibosFormaPagoDTO(String formaPago, int numeroRecibos) {
        this.formaPago = formaPago;
        this.numeroRecibos = numeroRecibos;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public int getNumeroRecibos() {
        return numeroRecibos;
    }

    public void setNumeroRecibos(int numeroRecibos) {
        this.numeroRecibos = numeroRecibos;
    }
}
