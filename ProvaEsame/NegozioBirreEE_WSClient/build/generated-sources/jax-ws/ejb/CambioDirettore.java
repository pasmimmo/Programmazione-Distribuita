
package ejb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cambio_direttore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cambio_direttore">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="old_director_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_director_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cambio_direttore", propOrder = {
    "oldDirectorName",
    "newDirectorName"
})
public class CambioDirettore {

    @XmlElement(name = "old_director_name")
    protected String oldDirectorName;
    @XmlElement(name = "new_director_name")
    protected String newDirectorName;

    /**
     * Recupera il valore della proprietà oldDirectorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldDirectorName() {
        return oldDirectorName;
    }

    /**
     * Imposta il valore della proprietà oldDirectorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldDirectorName(String value) {
        this.oldDirectorName = value;
    }

    /**
     * Recupera il valore della proprietà newDirectorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDirectorName() {
        return newDirectorName;
    }

    /**
     * Imposta il valore della proprietà newDirectorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDirectorName(String value) {
        this.newDirectorName = value;
    }

}
