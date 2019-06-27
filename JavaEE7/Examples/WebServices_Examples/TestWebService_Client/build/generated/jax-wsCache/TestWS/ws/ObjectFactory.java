
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
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

    private final static QName _RegardsResponse_QNAME = new QName("http://ws/", "regardsResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://ws/", "helloResponse");
    private final static QName _Hello_QNAME = new QName("http://ws/", "hello");
    private final static QName _Regards_QNAME = new QName("http://ws/", "regards");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegardsResponse }
     * 
     */
    public RegardsResponse createRegardsResponse() {
        return new RegardsResponse();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link Regards }
     * 
     */
    public Regards createRegards() {
        return new Regards();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "regardsResponse")
    public JAXBElement<RegardsResponse> createRegardsResponse(RegardsResponse value) {
        return new JAXBElement<RegardsResponse>(_RegardsResponse_QNAME, RegardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Regards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "regards")
    public JAXBElement<Regards> createRegards(Regards value) {
        return new JAXBElement<Regards>(_Regards_QNAME, Regards.class, null, value);
    }

}
