/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 * Interfaccia usata per l'invocazione dei metodi remoti
 * @author pasmimmo
 */
@Remote
public interface NegozioEJBRemote {
        public List<Negozio> printByRegion(String regione);
        public List<Negozio> printById(Long id);
        //
        public List<Negozio> printAll();
        public List<Negozio> printDrunkPeopleShops();

}
