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
 * PoJo (classe java) che con l'aggiunta di @Entity diventa un Entity che sarà quindi posta nell'unità di persistenza,
 * mappata sul Database tramite (ORM) e gestita da un EntityManger (a carico del container) il tutto
 * sftuttando le API di Java Persistence Api (JPA)
 * 
 * @author pasmimmo
 */
@Entity
@NamedQueries({
    /*Definizione di NamedQueries, queri statiche che vengono create a tempo di compilazione,
    molto efficienti rispetto alle DynamicQueries (create a runtime), inoltre va notato l'uso del JPQL,
    un linguaggio SQL-Like che effettua query ragionando su oggetti e non tabelle*/
    @NamedQuery(name = "Negiozio.PrintByRegion", query = "SELECT n FROM Negozio n WHERE n.regione = :regione"),
    @NamedQuery(name = "Negozio.PrintAll", query = "SELECT n FROM Negozio n"),
    @NamedQuery(name = "Negozio.PrintById", query = "SELECT n FROM Negozio n WHERE n.id = :id"),
    @NamedQuery(name = "Negozio.PrintDrunkPeopleShops", query = "SELECT n FROM Negozio n WHERE n.birra > n.birraAnalcolica"),
    @NamedQuery(name = "Negozio.PrintByName", query = "SELECT n FROM Negozio n WHERE n.nome = :nome"),
    @NamedQuery(name = "Negozio.PrintByDirector", query = "SELECT n FROM Negozio n WHERE n.direttore = :direttore")
})
public class Negozio implements Serializable {

    private static final long serialVersionUID = 1L;
    /*Annotazione per dire che il campo è la chiave primaria @Id e i valori sono autogenerati dal container @GeneratedValue*/
    @Id @GeneratedValue
    private Long id;
    /*a seguire le variabili del nostro oggetto che mediante ORM verranno mappate come colonne nel DB*/
    private Double birra,birraAnalcolica;
    private String citta,provincia,regione,nome,direttore;
    public Negozio(){/*costruttore vuoto*/}
    /**
     * Costruttore dell'oggetto negozio, da notare la mancanza di Id, la cui creazione la demandiamo alla EntityManager
     * 
     * @param nome Nome del negozio
     * @param direttore Nome del direttore del negozio
     * @param birraAnalcolica Q.ta di birra analcolica venduta
     * @param birra Q.ta di birra alcolica venduta
     * @param citta Città in cui si trova il negozio
     * @param provincia Provincia del negozio
     * @param regione Regione del negozio
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
