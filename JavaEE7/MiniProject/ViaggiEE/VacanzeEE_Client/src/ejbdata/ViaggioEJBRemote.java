/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbdata;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author pasmimmo
 */
@Remote
public interface ViaggioEJBRemote {

    public void rimuoviViaggio(Viaggio viaggio);

    List<Viaggio> stampaTuttiIViaggi();

    List<Viaggio> ricercaPerDestinazione(String destinazione);

    List<Viaggio> ricercaPerCategoria(String category);

    public Viaggio aggiungiViaggio(Viaggio viaggio);

    public List<Viaggio> ricercaPrezzoMax(Integer prezzoMax);

}
