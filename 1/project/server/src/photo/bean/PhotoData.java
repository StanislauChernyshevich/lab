package photo.bean;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/*
* photo data keeper
* */
public class PhotoData implements Serializable {
  private List<CustomerOrder> customerOrders;

  public PhotoData() {
    customerOrders = new ArrayList<CustomerOrder>();
  }

  public List<CustomerOrder> getCustomerOrders() {
    return customerOrders;
  }

  public void setCustomerOrders(List<CustomerOrder> customerOrders) {
    this.customerOrders = customerOrders;
  }

  public void addCustomerOrder(CustomerOrder customerOrder) {
    customerOrders.add(customerOrder);
  }
}
