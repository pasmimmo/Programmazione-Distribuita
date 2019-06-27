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
public interface EJBRemote {
    public List<String> getAll();
    public List<String> getOpen();
    public String findByName(String bakeryName);
    public String ciao(String nome);
}
