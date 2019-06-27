/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Column;
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
    @NamedQuery(name = "molecola.findAll", query = "SELECT m FROM Molecola m"),
    @NamedQuery(name = "molecola.findByName", query = "SELECT m FROM Molecola m WHERE m.Nome = :nome"),
    @NamedQuery(name = "molecola.findByType", query = "SELECT m FROM Molecola m WHERE m.Tipo = :tipo")
})
public class Molecola implements Serializable{
    @Id @GeneratedValue
    Long id;
    @Column(unique = true)
    String  Nome;
    String Tipo;

    public Molecola() {
    }

    public Molecola(String Nome, String Tipo) {
        this.Nome = Nome;
        this.Tipo = Tipo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new  StringBuilder();
        builder.append("{\n Nome Molecola: ").append(Nome)
                .append("\t tipo molecola:").append(Tipo)
                .append("\n}");
        return builder.toString();
    }
    
    
}
