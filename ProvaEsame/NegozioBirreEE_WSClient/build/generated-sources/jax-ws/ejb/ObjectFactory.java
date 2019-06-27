
package ejb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ejb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CambioDirettoreResponse_QNAME = new QName("http://ejb/", "cambio_direttoreResponse");
    private final static QName _CambioDirettore_QNAME = new QName("http://ejb/", "cambio_direttore");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CambioDirettoreResponse }
     * 
     */
    public CambioDirettoreResponse createCambioDirettoreResponse() {
        return new CambioDirettoreResponse();
    }

    /**
     * Create an instance of {@link CambioDirettore }
     * 
     */
    public CambioDirettore createCambioDirettore() {
        return new CambioDirettore();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambioDirettoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "cambio_direttoreResponse")
    public JAXBElement<CambioDirettoreResponse> createCambioDirettoreResponse(CambioDirettoreResponse value) {
        return new JAXBElement<CambioDirettoreResponse>(_CambioDirettoreResponse_QNAME, CambioDirettoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CambioDirettore }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "cambio_direttore")
    public JAXBElement<CambioDirettore> createCambioDirettore(CambioDirettore value) {
        return new JAXBElement<CambioDirettore>(_CambioDirettore_QNAME, CambioDirettore.class, null, value);
    }

}
