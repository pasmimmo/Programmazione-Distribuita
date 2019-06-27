
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

    private final static QName _ElencoCompletoResponse_QNAME = new QName("http://ejb/", "elencoCompletoResponse");
    private final static QName _ElencoCompleto_QNAME = new QName("http://ejb/", "elencoCompleto");
    private final static QName _CercaTipo_QNAME = new QName("http://ejb/", "cercaTipo");
    private final static QName _CercaTipoResponse_QNAME = new QName("http://ejb/", "cercaTipoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ejb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CercaTipo }
     * 
     */
    public CercaTipo createCercaTipo() {
        return new CercaTipo();
    }

    /**
     * Create an instance of {@link CercaTipoResponse }
     * 
     */
    public CercaTipoResponse createCercaTipoResponse() {
        return new CercaTipoResponse();
    }

    /**
     * Create an instance of {@link ElencoCompleto }
     * 
     */
    public ElencoCompleto createElencoCompleto() {
        return new ElencoCompleto();
    }

    /**
     * Create an instance of {@link ElencoCompletoResponse }
     * 
     */
    public ElencoCompletoResponse createElencoCompletoResponse() {
        return new ElencoCompletoResponse();
    }

    /**
     * Create an instance of {@link Molecola }
     * 
     */
    public Molecola createMolecola() {
        return new Molecola();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElencoCompletoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "elencoCompletoResponse")
    public JAXBElement<ElencoCompletoResponse> createElencoCompletoResponse(ElencoCompletoResponse value) {
        return new JAXBElement<ElencoCompletoResponse>(_ElencoCompletoResponse_QNAME, ElencoCompletoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElencoCompleto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "elencoCompleto")
    public JAXBElement<ElencoCompleto> createElencoCompleto(ElencoCompleto value) {
        return new JAXBElement<ElencoCompleto>(_ElencoCompleto_QNAME, ElencoCompleto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CercaTipo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "cercaTipo")
    public JAXBElement<CercaTipo> createCercaTipo(CercaTipo value) {
        return new JAXBElement<CercaTipo>(_CercaTipo_QNAME, CercaTipo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CercaTipoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ejb/", name = "cercaTipoResponse")
    public JAXBElement<CercaTipoResponse> createCercaTipoResponse(CercaTipoResponse value) {
        return new JAXBElement<CercaTipoResponse>(_CercaTipoResponse_QNAME, CercaTipoResponse.class, null, value);
    }

}
