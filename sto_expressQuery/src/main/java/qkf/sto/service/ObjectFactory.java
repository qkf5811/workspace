
package qkf.sto.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the qkf.sto.service package. 
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

    private final static QName _QueryJsonByCodeResponse_QNAME = new QName("http://service.sto.qkf/", "queryJsonByCodeResponse");
    private final static QName _QueryJsonByCode_QNAME = new QName("http://service.sto.qkf/", "queryJsonByCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: qkf.sto.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryJsonByCode }
     * 
     */
    public QueryJsonByCode createQueryJsonByCode() {
        return new QueryJsonByCode();
    }

    /**
     * Create an instance of {@link QueryJsonByCodeResponse }
     * 
     */
    public QueryJsonByCodeResponse createQueryJsonByCodeResponse() {
        return new QueryJsonByCodeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryJsonByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sto.qkf/", name = "queryJsonByCodeResponse")
    public JAXBElement<QueryJsonByCodeResponse> createQueryJsonByCodeResponse(QueryJsonByCodeResponse value) {
        return new JAXBElement<QueryJsonByCodeResponse>(_QueryJsonByCodeResponse_QNAME, QueryJsonByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryJsonByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sto.qkf/", name = "queryJsonByCode")
    public JAXBElement<QueryJsonByCode> createQueryJsonByCode(QueryJsonByCode value) {
        return new JAXBElement<QueryJsonByCode>(_QueryJsonByCode_QNAME, QueryJsonByCode.class, null, value);
    }

}
