package photo.client;

import photo.ws.stub.PhotoData;
import photo.ws.WSCaller;

public class MClient {
  public static PhotoData photoData;

  private MenuPhoto menuPhoto = new MenuPhoto();

  public static void main(String[] args) {
    MClient mClient = new MClient();
    Console.out.println("���� ������� �� ������ ����������");
    mClient.run();
  }

  private void run() {
    menuPhoto.printMenuMain();
  }

  public static void exit() {
    if(photoData != null) {
      Console.out.println("");
      Console.out.println("��������� ������");
      Console.out.println("1 - ��");
      Console.out.println("2 - ���");
      int[] menuItems = new int[] {1,2};
      int menuItem = Menu.getMenuItem(menuItems);
      switch(menuItem) {
        case 1: WSCaller.getCaller().saveModel(photoData); break;
      }
    }
    System.exit(0);
  }
  
}
