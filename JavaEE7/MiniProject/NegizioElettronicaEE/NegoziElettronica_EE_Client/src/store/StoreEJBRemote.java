/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author amori
 */
@Remote
public interface StoreEJBRemote {

    List<Store> PrintAll();

    List<Store> PrintByRegion(String region);

    Store PrintById(Long id);

    List<Store> PrintActiveShops();
    
}
