package photo.client;

import photo.ws.stub.PhotoData;
import photo.ws.stub.CustomerOrder;
import photo.ws.WSCaller;

import java.util.Collections;
import java.util.List;

public class MenuPhoto extends Menu {
  public void printMenuMain() {
    println("");
    println("1 - начать новый набор заказов");
    println("2 - загрузить сохраненный набор заказов");
    println("3 - выход");
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
      println("Данные не загружены");
      return false;
    } else {
      println( MClient.photoData.getCustomerOrders().size()+" загружено записей");
      return true;
    }
  }

  private void printMenuPhotoData() {
    println("");
    println("1 - работать с заказами");
    println("2 - выход в главное меню");
    println("3 - выход");
    int menuItem = Menu.getMenuItem(getMenuInput(3));
    switch(menuItem) {
      case 1: printMenuData(); break;
      case 2: printMenuMain(); break;
      case 3: MClient.exit(); break;
    }
  }

  private void printMenuData() {
    println("");
    println("1 - вывести все заказы");
    println("2 - добавить заказ");
    println("3 - изменить заказ");
    println("4 - удалить заказ");
    println("5 - выход в меню работы с заказами");
    println("6 - выход в главное меню");
    println("7 - выход");

    int menuItem = Menu.getMenuItem(getMenuInput(7));
    switch(menuItem) {
      case 1:
        println("");
        println(MClient.photoData.getCustomerOrders().size()+" количество заказов");

        int index = 1;
        for(CustomerOrder customerOrder: MClient.photoData.getCustomerOrders()) {
          println("");
          println("#: "+index);
          println("Наименование заказа: "+customerOrder.getName());
          println("Дата: "+customerOrder.getDateOf());
          println("Формат печати: "+customerOrder.getFormat());
          println("Число: "+customerOrder.getNumber());
          println("Стоимоть: "+customerOrder.getCost());
          println("Выполнен: "+ ( customerOrder.isDone()?"Да":"Нет" ));
        }

        printMenuData();
        break;
      case 2:
        println("");
        println("Новый заказ");

        CustomerOrder newCustomerOrder = new CustomerOrder();

        println("Наименование заказа");
        newCustomerOrder.setName(getUserInput());
        println("Дата");
        newCustomerOrder.setDateOf(getUserInput());
        println("Формат печати");
        newCustomerOrder.setFormat(getUserInput());
        println("Число");
        newCustomerOrder.setNumber(getUserInput());
        println("Стоимоть");
        newCustomerOrder.setCost(getUserInput());
        println("Выполнен");
        newCustomerOrder.setDone(getBooleanInput());

        MClient.photoData.getCustomerOrders().add( newCustomerOrder );

        printMenuPhotoData();
        break;
      case 3:
        println("Введите порядковый номер заказа ("+MClient.photoData.getCustomerOrders().size()+")");
        int number = getMenuItem( getMenuInput( MClient.photoData.getCustomerOrders().size() ) );

        CustomerOrder editCustomerOrder = MClient.photoData.getCustomerOrders().get( number );

        println("Старые данные");
        println("Наименование заказа: "+editCustomerOrder.getName());
        println("Дата: "+editCustomerOrder.getDateOf());
        println("Формат печати: "+editCustomerOrder.getFormat());
        println("Число: "+editCustomerOrder.getNumber());
        println("Стоимоть: "+editCustomerOrder.getCost());
        println("Выполнен: "+ ( editCustomerOrder.isDone()?"Да":"Нет" ));

        println("Введите новые данные");
        println("Наименование заказа");
        editCustomerOrder.setName(getUserInput());
        println("Дата");
        editCustomerOrder.setDateOf(getUserInput());
        println("Формат печати");
        editCustomerOrder.setFormat(getUserInput());
        println("Число");
        editCustomerOrder.setNumber(getUserInput());
        println("Стоимоть");
        editCustomerOrder.setCost(getUserInput());
        println("Выполнен");
        editCustomerOrder.setDone(getBooleanInput());

        printMenuPhotoData();

        break;
      case 4:
        println("Введите порядковый номер заказа ("+MClient.photoData.getCustomerOrders().size()+")");
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
