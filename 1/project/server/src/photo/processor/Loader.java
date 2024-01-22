package photo.processor;

import java.io.*;

import photo.bean.CustomerOrder;
import photo.bean.PhotoData;

public class Loader extends Processor {

  public PhotoData load() {
    photoData = new PhotoData();
    readFile();
    return photoData;
  }

  /**
   * read data from file
   * */
  private void readFile() {

    try {
      File file = new File(getFile());
      BufferedReader br = new BufferedReader(new FileReader(file));

      String callData;
      while ((callData = read(br)) != null) {
        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setCost(read(br));
        customerOrder.setDateOf(read(br));
        customerOrder.setFormat(read(br));
        customerOrder.setName(read(br));
        customerOrder.setNumber(read(br));
        customerOrder.setDone(read(br).equals("1"));

        photoData.addCustomerOrder(customerOrder);

      }

      br.close();
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }


  private String read(BufferedReader br) throws IOException {
    return br.readLine();
  }

}
