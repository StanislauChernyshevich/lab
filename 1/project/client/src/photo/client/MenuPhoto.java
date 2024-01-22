package photo.client;

import photo.ws.stub.PhotoData;
import photo.ws.stub.CustomerOrder;
import photo.ws.WSCaller;

import java.util.Collections;
import java.util.List;

public class MenuPhoto extends Menu {
  public void printMenuMain() {
    println("");
    println("1 - ������ ����� ����� �������");
    println("2 - ��������� ����������� ����� �������");
    println("3 - �����");
    int menuItem = Menu.getMenuItem(getMenuInput(3));
    switch(menuItem) {
      case 1:
        MClient.photoData = new PhotoData();
        printMenuPhotoData();
        break;
      case 2:
        if(loadPhotoData()) {
          printMenuPhotoData();
        } else {
          printMenuMain();
        }
        break;
      case 3: MClient.exit(); break;
    }
  }

  private boolean loadPhotoData() {
    MClient.photoData = WSCaller.getCaller().loadModel();
    if(MClient.photoData == null) {
      println("������ �� ���������");
      return false;
    } else {
      println( MClient.photoData.getCustomerOrders().size()+" ��������� �������");
      return true;
    }
  }

  private void printMenuPhotoData() {
    println("");
    println("1 - �������� � ��������");
    println("2 - ����� � ������� ����");
    println("3 - �����");
    int menuItem = Menu.getMenuItem(getMenuInput(3));
    switch(menuItem) {
      case 1: printMenuData(); break;
      case 2: printMenuMain(); break;
      case 3: MClient.exit(); break;
    }
  }

  private void printMenuData() {
    println("");
    println("1 - ������� ��� ������");
    println("2 - �������� �����");
    println("3 - �������� �����");
    println("4 - ������� �����");
    println("5 - ����� � ���� ������ � ��������");
    println("6 - ����� � ������� ����");
    println("7 - �����");

    int menuItem = Menu.getMenuItem(getMenuInput(7));
    switch(menuItem) {
      case 1:
        println("");
        println(MClient.photoData.getCustomerOrders().size()+" ���������� �������");

        int index = 1;
        for(CustomerOrder customerOrder: MClient.photoData.getCustomerOrders()) {
          println("");
          println("#: "+index);
          println("������������ ������: "+customerOrder.getName());
          println("����: "+customerOrder.getDateOf());
          println("������ ������: "+customerOrder.getFormat());
          println("�����: "+customerOrder.getNumber());
          println("��������: "+customerOrder.getCost());
          println("��������: "+ ( customerOrder.isDone()?"��":"���" ));
        }

        printMenuData();
        break;
      case 2:
        println("");
        println("����� �����");

        CustomerOrder newCustomerOrder = new CustomerOrder();

        println("������������ ������");
        newCustomerOrder.setName(getUserInput());
        println("����");
        newCustomerOrder.setDateOf(getUserInput());
        println("������ ������");
        newCustomerOrder.setFormat(getUserInput());
        println("�����");
        newCustomerOrder.setNumber(getUserInput());
        println("��������");
        newCustomerOrder.setCost(getUserInput());
        println("��������");
        newCustomerOrder.setDone(getBooleanInput());

        MClient.photoData.getCustomerOrders().add( newCustomerOrder );

        printMenuPhotoData();
        break;
      case 3:
        println("������� ���������� ����� ������ ("+MClient.photoData.getCustomerOrders().size()+")");
        int number = getMenuItem( getMenuInput( MClient.photoData.getCustomerOrders().size() ) );

        CustomerOrder editCustomerOrder = MClient.photoData.getCustomerOrders().get( number );

        println("������ ������");
        println("������������ ������: "+editCustomerOrder.getName());
        println("����: "+editCustomerOrder.getDateOf());
        println("������ ������: "+editCustomerOrder.getFormat());
        println("�����: "+editCustomerOrder.getNumber());
        println("��������: "+editCustomerOrder.getCost());
        println("��������: "+ ( editCustomerOrder.isDone()?"��":"���" ));

        println("������� ����� ������");
        println("������������ ������");
        editCustomerOrder.setName(getUserInput());
        println("����");
        editCustomerOrder.setDateOf(getUserInput());
        println("������ ������");
        editCustomerOrder.setFormat(getUserInput());
        println("�����");
        editCustomerOrder.setNumber(getUserInput());
        println("��������");
        editCustomerOrder.setCost(getUserInput());
        println("��������");
        editCustomerOrder.setDone(getBooleanInput());

        printMenuPhotoData();

        break;
      case 4:
        println("������� ���������� ����� ������ ("+MClient.photoData.getCustomerOrders().size()+")");
        int numberToDelete = getMenuItem( getMenuInput( MClient.photoData.getCustomerOrders().size() ) );

        MClient.photoData.getCustomerOrders().remove(numberToDelete);

        printMenuPhotoData();

        break;
      case 5: printMenuPhotoData(); break;
      case 6: printMenuMain(); break;
      case 7: MClient.exit(); break;
    }
  }

  // ----------

  private int[] getMenuInput(int muneLength) {
    int[] menu = new int[muneLength];
    for(int i=0;i<menu.length;i++) {
      menu[i] = i+1;
    }
    return menu;
  }
}
