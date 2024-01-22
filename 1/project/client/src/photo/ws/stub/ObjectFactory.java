
package photo.ws.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the photo.ws.stub package. 
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

    private final static QName _SaveModelResponse_QNAME = new QName("http://session.photo/", "saveModelResponse");
    private final static QName _LoadModel_QNAME = new QName("http://session.photo/", "loadModel");
    private final static QName _SaveModel_QNAME = new QName("http://session.photo/", "saveModel");
    private final static QName _LoadModelResponse_QNAME = new QName("http://session.photo/", "loadModelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: photo.ws.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadModel }
     * 
     */
    public LoadModel createLoadModel() {
        return new LoadModel();
    }

    /**
     * Create an instance of {@link SaveModel }
     * 
     */
    public SaveModel createSaveModel() {
        return new SaveModel();
    }

    /**
     * Create an instance of {@link LoadModelResponse }
     * 
     */
    public LoadModelResponse createLoadModelResponse() {
        return new LoadModelResponse();
    }

    /**
     * Create an instance of {@link CustomerOrder }
     * 
     */
    public CustomerOrder createCustomerOrder() {
        return new CustomerOrder();
    }

    /**
     * Create an instance of {@link PhotoData }
     * 
     */
    public PhotoData createPhotoData() {
        return new PhotoData();
    }

    /**
     * Create an instance of {@link SaveModelResponse }
     * 
     */
    public SaveModelResponse createSaveModelResponse() {
        return new SaveModelResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveModelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://session.photo/", name = "saveModelResponse")
    public JAXBElement<SaveModelResponse> createSaveModelResponse(SaveModelResponse value) {
        return new JAXBElement<SaveModelResponse>(_SaveModelResponse_QNAME, SaveModelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://session.photo/", name = "loadModel")
    public JAXBElement<LoadModel> createLoadModel(LoadModel value) {
        return new JAXBElement<LoadModel>(_LoadModel_QNAME, LoadModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://session.photo/", name = "saveModel")
    public JAXBElement<SaveModel> createSaveModel(SaveModel value) {
        return new JAXBElement<SaveModel>(_SaveModel_QNAME, SaveModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadModelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://session.photo/", name = "loadModelResponse")
    public JAXBElement<LoadModelResponse> createLoadModelResponse(LoadModelResponse value) {
        return new JAXBElement<LoadModelResponse>(_LoadModelResponse_QNAME, LoadModelResponse.class, null, value);
    }

}
