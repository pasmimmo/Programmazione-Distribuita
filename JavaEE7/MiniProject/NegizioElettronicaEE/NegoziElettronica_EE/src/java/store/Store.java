/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author amori
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "printAll", query = "SELECT s FROM Store s"),
    @NamedQuery(name = "printById", query = "SELECT s FROM Store s WHERE s.id = :id"),
    @NamedQuery(name = "printByRegion", query = "SELECT s FROM Store s WHERE s.district = :distretto"),
    @NamedQuery(name = "printActiveShop", query = "SELECT s FROM Store s WHERE s.currentYear > s.lastYear")
})
public class Store implements Serializable{
    @Id @GeneratedValue
    private Long id;
    
    private Integer lastYear, currentYear;
    private String city, district, country;
    private String directorName, storeName;

    public Store(Integer lastYear, Integer currentYear, String city, String district, String country, String directorName, String storeName) {
        this.lastYear = lastYear;
        this.currentYear = currentYear;
        this.city = city;
        this.district = district;
        this.country = country;
        this.directorName = directorName;
        this.storeName = storeName;
    }
    
    public Store(){
        
    }

    public Long getId() {
        return id;
    }

    public Integer getLastYear() {
        return lastYear;
    }

    public void setLastYear(Integer lastYear) {
        this.lastYear = lastYear;
    }

    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    @Override
    public String toString(){
        return "Id: "+id+"\nDirectorName: "+directorName+"\nStoreName: "+storeName;
    }
}
