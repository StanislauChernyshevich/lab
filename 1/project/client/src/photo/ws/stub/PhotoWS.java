
package photo.ws.stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.1-02/02/2007 03:56 AM(vivekp)-FCS
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PhotoWS", targetNamespace = "http://session.photo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PhotoWS {


    /**
     * 
     * @return
     *     returns photo.ws.stub.PhotoData
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "loadModel", targetNamespace = "http://session.photo/", className = "photo.ws.stub.LoadModel")
    @ResponseWrapper(localName = "loadModelResponse", targetNamespace = "http://session.photo/", className = "photo.ws.stub.LoadModelResponse")
    public PhotoData loadModel();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "saveModel", targetNamespace = "http://session.photo/", className = "photo.ws.stub.SaveModel")
    @ResponseWrapper(localName = "saveModelResponse", targetNamespace = "http://session.photo/", className = "photo.ws.stub.SaveModelResponse")
    public void saveModel(
        @WebParam(name = "arg0", targetNamespace = "")
        PhotoData arg0);

}
