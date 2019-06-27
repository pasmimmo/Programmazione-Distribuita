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
@NamedQuery(name="Mouse.getAll", query="SELECT m FROM Mouse m"),
@NamedQuery(name="Mouse.findByName", query="SELECT m FROM Mouse m WHERE m.name=:name"),
@NamedQuery(name="Mouse.maxPrice", query="SELECT m FROM Mouse m WHERE m.price < :price")
})
public class Mouse implements Serializable{
    
    @Id @GeneratedValue
    Long id;
    
    String name, model;
    Float price;
    
    public Mouse(){}

    public Mouse(String name, String model, Float price) {
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mouse{" + "name=" + name + ", model=" + model + ", price=" + price + '}';
    }
    
    
    
}
