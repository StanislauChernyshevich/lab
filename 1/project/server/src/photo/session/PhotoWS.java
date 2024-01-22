package photo.session;

import photo.bean.PhotoData;
import photo.processor.Processor;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless(name = "PhotoWSEJB")
@WebService
public class PhotoWS {
  public PhotoData loadModel() {
    return Processor.loadModel();
  }

  public void saveModel(PhotoData photoData) {
    Processor.saveModel(photoData);
  }
}
