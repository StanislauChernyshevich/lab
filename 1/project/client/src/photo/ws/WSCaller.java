package photo.ws;

import photo.ws.stub.PhotoWS;
import photo.ws.stub.PhotoWSService;
import photo.ws.stub.PhotoData;

public class WSCaller {
  private static WSCaller caller;
   private PhotoWS ws;

   public WSCaller(PhotoWS ws) {
     this.ws = ws;
   }

   public static WSCaller getCaller() {
     if(caller == null) {
       caller = new WSCaller((new PhotoWSService()).getPhotoWSPort());
     }
     return caller;
   }

  public PhotoData loadModel() {
    return ws.loadModel();
  }

  public void saveModel(PhotoData photoData) {
    ws.saveModel(photoData);
  }
}
