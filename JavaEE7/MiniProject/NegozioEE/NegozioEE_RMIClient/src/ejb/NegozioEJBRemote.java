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
public interface NegozioEJBRemote {
    public List<Mouse> getAll();
    
    public List<Mouse> maxPrice(Float price);
    
    public String findByName(String name);
}
