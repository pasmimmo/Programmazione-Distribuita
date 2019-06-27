/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
    @NamedQuery(name = "Negiozio.PrintByRegion", query = "SELECT n FROM Negozio n WHERE n.regione = :regione"),
    @NamedQuery(name = "Negozio.PrintAll", query = "SELECT n FROM Negozio n"),
    @NamedQuery(name = "Negozio.PrintById", query = "SELECT n FROM Negozio n WHERE n.id = :id"),
    @NamedQuery(name = "Negozio.PrintDrunkPeopleShops", query = "SELECT n FROM Negozio n WHERE n.birra > n.birraAnalcolica"),
    @NamedQuery(name = "Negozio.PrintByName", query = "SELECT n FROM Negozio n WHERE n.nome = :nome"),
    @NamedQuery(name = "Negozio.PrintByDirector", query = "SELECT n FROM Negozio n WHERE n.direttore = :direttore")
})
public class Negozio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private Double birra,birraAnalcolica;
    private String citta,provincia,regione,nome,direttore;
    //@update sistemato solo il nome delle variabili per dare una lettura migliore
    public Negozio(){/*costruttore vuoto*/}
    /**
     * 
     * @param nome
     * @param direttore
     * @param birraAnalcolica
     * @param birra
     * @param citta
     * @param provincia
     * @param regione 
     */
    public Negozio(String nome, String direttore, Double birra, Double birraAnalcolica, String citta, String provincia, String regione){
        this.birra = birra;
        this.birraAnalcolica = birraAnalcolica;
        this.citta = citta;
        this.provincia = provincia;
        this.regione = regione;
        this.nome = nome;
        this.direttore = direttore;
    }
    
    
    public String getDirettore() {
        return direttore;
    }

    public void setDirettore(String direttore) {
        this.direttore = direttore;
    }
    

    public Long getId() {
        return id;
    }

    public Double getBirra() {
        return birra;
    }

    public void setBirra(Double birra) {
        this.birra = birra;
    }

    public Double getBirraAnalcolica() {
        return birraAnalcolica;
    }

    public void setBirraAnalcolica(Double birraAnalcolica) {
        this.birraAnalcolica = birraAnalcolica;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder builder= new StringBuilder();
        builder.append("Negozio: ").append(nome)
                .append(" id: ").append(id)
                .append("direttore: ").append(direttore)
                .append("\nVendite Analcoliche,\tVendite Alcoliche\n")
                .append(birraAnalcolica).append("\t\t").append(birra);
        return builder.toString();
    }
    
    
}
