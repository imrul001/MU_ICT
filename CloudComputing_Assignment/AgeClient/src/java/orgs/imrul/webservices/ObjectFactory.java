
package orgs.imrul.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the orgs.imrul.webservices package. 
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

    private final static QName _GetAgeByDateOfBirth_QNAME = new QName("http://webservices.imrul.orgs/", "getAgeByDateOfBirth");
    private final static QName _GetAgeByDateOfBirthResponse_QNAME = new QName("http://webservices.imrul.orgs/", "getAgeByDateOfBirthResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: orgs.imrul.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAgeByDateOfBirth }
     * 
     */
    public GetAgeByDateOfBirth createGetAgeByDateOfBirth() {
        return new GetAgeByDateOfBirth();
    }

    /**
     * Create an instance of {@link GetAgeByDateOfBirthResponse }
     * 
     */
    public GetAgeByDateOfBirthResponse createGetAgeByDateOfBirthResponse() {
        return new GetAgeByDateOfBirthResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAgeByDateOfBirth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.imrul.orgs/", name = "getAgeByDateOfBirth")
    public JAXBElement<GetAgeByDateOfBirth> createGetAgeByDateOfBirth(GetAgeByDateOfBirth value) {
        return new JAXBElement<GetAgeByDateOfBirth>(_GetAgeByDateOfBirth_QNAME, GetAgeByDateOfBirth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAgeByDateOfBirthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.imrul.orgs/", name = "getAgeByDateOfBirthResponse")
    public JAXBElement<GetAgeByDateOfBirthResponse> createGetAgeByDateOfBirthResponse(GetAgeByDateOfBirthResponse value) {
        return new JAXBElement<GetAgeByDateOfBirthResponse>(_GetAgeByDateOfBirthResponse_QNAME, GetAgeByDateOfBirthResponse.class, null, value);
    }

}
