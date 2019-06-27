/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author pasmimmo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "trovaTutti", query = "SELECT v FROM Viaggio v")
    ,
    @NamedQuery(name = "ricercaPrezzo", query = "SELECT v FROM Viaggio v WHERE v.prezzo <= :maxp")
    ,
    @NamedQuery(name = "ricercaDestinazione", query = "SELECT v FROM Viaggio v WHERE v.destinazione = :destinazione")
    ,
    @NamedQuery(name = "ricercaCategoria", query = "SELECT v FROM Viaggio v WHERE v.categoria = :categoria"),})
public class Viaggio implements Serializable {
    
    @Id
    @GeneratedValue
    private Long ID;
    private String categoria;
    private String destinazione;
    private Double prezzo;
    private Integer sconto;
    private Integer disponibilita;
    
    public Viaggio() {/*noop*/
    }
    
    public Viaggio(String destinazione,String categoria, Double prezzo, Integer sconto, Integer disponibilita) {
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }
    
    public Long getID() {
        return ID;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String getDestinazione() {
        return destinazione;
    }
    
    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }
    
    public Double getPrezzo() {
        return prezzo;
    }
    
    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }
    
    public Integer getSconto() {
        return sconto;
    }
    
    public void setSconto(Integer sconto) {
        this.sconto = sconto;
    }
    
    public Integer getDisponibilita() {
        return disponibilita;
    }
    
    public void setDisponibilita(Integer disponibilita) {
        this.disponibilita = disponibilita;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Viaggio a ").append(this.getDestinazione())
                .append("\tcosto: ").append(this.getPrezzo())
                .append("\tcategoria: ").append(getCategoria())
                .append("\n Id: ").append(getID())
                .append("\tdisponibilita: ").append(getDisponibilita())
                .append("\tsconto applicato: ").append(getSconto());
        return builder.toString();
    }
    
}
