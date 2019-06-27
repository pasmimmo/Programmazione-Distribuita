/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author pasmimmo
 */
@Remote
public interface MolecolaEJBRemote {
    List<Molecola> getElencoCompleto();
    Molecola cercaMolecola(String nomeMolecola);
    List<Molecola> cercaTipo(String tipo);
}
