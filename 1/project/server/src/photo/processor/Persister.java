package photo.processor;

import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

import photo.bean.CustomerOrder;
import photo.bean.PhotoData;

public class Persister extends Processor {

  public void store(PhotoData photoData) {
    this.photoData = photoData;
    saveToFile();
  }

  /**
   * save data to file
   * */
  private void saveToFile(){

    try
    {
      File file = new File(getFile());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for(CustomerOrder customerOrder : photoData.getCustomerOrders()) {
        write(bw, PHOTO);
        write(bw, customerOrder.getCost());
        write(bw, customerOrder.getDateOf());
        write(bw, customerOrder.getFormat());
        write(bw, customerOrder.getName());
        write(bw, customerOrder.getNumber());
        write(bw, customerOrder.isDone()?"1":"0");
      }


      bw.close();
    } catch(IOException ie) {
        ie.printStackTrace();
    }
  }

  private void write(BufferedWriter bw, String content) throws IOException {
    bw.write(content+"\n");
  }
}
