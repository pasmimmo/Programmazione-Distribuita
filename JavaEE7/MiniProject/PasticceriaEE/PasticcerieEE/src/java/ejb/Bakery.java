/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pasmimmo
 */
@Entity
@NamedQueries({
@NamedQuery(name="Bakery.getAll", query = "SELECT b FROM Bakery b"),
@NamedQuery(name="Bakery.getOpen", query="SELECT b FROM Bakery b WHERE b.inAttivita = true"),
@NamedQuery(name="Bakery.findByName", query ="SELECT b FROM Bakery b WHERE b.nome = :nome")})
@Table(name="bakery")
public class Bakery implements Serializable{
    
    @Id
    String nome;
    Double fatturato;
    @Column(name = "aperto")
    Boolean inAttivita;
    
    public Bakery(){}

    public Bakery(String nome, Double fatturato, Boolean inAttivita) {
        this.nome = nome;
        this.fatturato = fatturato;
        this.inAttivita = inAttivita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getFatturato() {
        return fatturato;
    }

    public void setFatturato(Double fatturato) {
        this.fatturato = fatturato;
    }

    public Boolean getInAttivita() {
        return inAttivita;
    }

    public void setInAttivita(Boolean inAttivita) {
        this.inAttivita = inAttivita;
    }

    @Override
    public String toString() {
        return "Bakery{" + "nome=" + nome + ", fatturato=" + fatturato + ", inAttivita=" + inAttivita + '}';
    }
    
    
    
    
}
