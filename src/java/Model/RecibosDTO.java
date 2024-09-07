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
public class RecibosDTO {
       private int totalRecibos;

    public RecibosDTO(int totalRecibos) {
        this.totalRecibos = totalRecibos;
    }

    public int getTotalRecibos() {
        return totalRecibos;
    }

    public void setTotalRecibos(int totalRecibos) {
        this.totalRecibos = totalRecibos;
    }
}
