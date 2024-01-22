package photo.client;

import java.io.IOException;
import java.util.List;

public class Menu {
  public static final String OUT_SEPARATOR = " | ";

  public static boolean getBooleanInput() {
    boolean userInput = false;
    Console.out.println("1 - да");
    Console.out.println("2 - нет");
    int[] menuItems = new int[] {1,2};
    int menuItem = Menu.getMenuItem(menuItems);
    userInput = menuItem == 1;
    return userInput;
  }

  public static String getUserInput() {
    String userInput = null;
    boolean isInputed = false;
    while(!isInputed) {
      try {
        userInput = Console.in.readLine();
        isInputed = !userInput.trim().equals("");
        if(!isInputed) {
          Console.out.println("Повторите ввод. Пустые данные недопустимы");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return userInput;
  }

  public static int getIntInput() {
    boolean isSelected = false;
    int digitIntInput = -1;
    while (!isSelected) {
      try {
        String userInput = Console.in.readLine();
        digitIntInput = Integer.parseInt(userInput);
        isSelected = true;
      } catch (IOException e) {
        e.printStackTrace();
      } catch (NumberFormatException e) {
        System.out.println("Неверный формат ввода.");
      }
    }

    return digitIntInput;
  }

  public static float getFloatInput() {
    boolean isSelected = false;
    float digitFloatInput = -1;
    while (!isSelected) {
      try {
        String userInput = Console.in.readLine();
        digitFloatInput = Float.parseFloat(userInput);
        isSelected = true;
      } catch (IOException e) {
        e.printStackTrace();
      } catch (NumberFormatException e) {
        System.out.println("Неверный формат ввода.");
      }
    }

    return digitFloatInput;
  }

  public static int getMenuItem(int[] menuItems) {
    boolean isItemSelected = false;
    int selectedItem = -1;
    while(!isItemSelected) {
      selectedItem = getIntInput();
      isItemSelected = isInArray(selectedItem, menuItems);
    }
    return selectedItem;
  }

  public static boolean isInArray(int choice, int[] array) {
    boolean isIn = false;
    for(int arrayValue : array) {
      if(arrayValue == choice) {
        isIn = true;
        break;
      }
    }
    return isIn;
  }

  public static void lineNoRecordsInfo() {
    Console.out.println("Данных нет");
  }

  public static void lineIDRequest() {
    Console.out.println("Введите ID записи");
  }

  public static void lineNewDataRequest() {
    Console.out.println("Введите новые данные");
  }

  public static void lineCaptions(List<String> captions) {
    StringBuffer captionInfo = new StringBuffer();
    int numberOfCaptions = captions.size();
    for(int i=0; i<numberOfCaptions; i++) {
      captionInfo.append(captions.get(i));
      if(i<numberOfCaptions-1) {
        captionInfo.append(OUT_SEPARATOR);
      }
    }
    Console.out.println(captionInfo);
  }

  public void println(String str) {
    System.out.println(str);
  }
}
