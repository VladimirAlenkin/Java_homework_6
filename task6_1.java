/* Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру.
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class task6_1 {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "Windows", "4", "1000", "grey");
        Notebook notebook2 = new Notebook("Asus", "Linux", "8", "1000", "black");
        Notebook notebook3 = new Notebook("Xiaomi", "Windows", "4", "2000", "black");
        Notebook notebook4 = new Notebook("Lenovo", "Windows", "16", "1000", "grey");
        Notebook notebook5 = new Notebook("Huawei", "Windows", "8", "1000", "black");
        Notebook notebook6 = new Notebook("Acer", "Linux", "16", "2000", "black");
        
        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
              notebook3, notebook4, notebook5, notebook6));
  
        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);
     }
  
     public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
     }
       
     public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        while (true) {
           System.out.println("Выбираем характеристики? (y/n)");
           String question = scanner();
           if (question.equals("n")) {
              break;
           } else {
              System.out.println(
                    "Введите цифру: \n 1 - Название (Asus, Acer, Lenovo, Huawei, Xiaomi) \n 2 - ОЗУ(ram) (4/8/16) \n 3 - Объем ЖД(hardDisk) (1000/2000) \n 4 - Операционная система (Linux, Windows) \n 5 - Цвет (black/grey)");
              String key = scanner();
              System.out.println("Введите желаемое значение характеристики: ");
              String value = scanner();  
              resultCriterias.put(key, value);
           }
        }
        System.out.println(resultCriterias);
        return resultCriterias; 
     }
  
     public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) {  
        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {  
           for (Object pair : criterias.keySet()) { 
              if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                 temp.remove(notebook);
              }
              for (Object pair1 : criterias.keySet()) { 
                 if (pair1.equals("2") && !notebook.getRam().equals(criterias.get(pair1))) {
                    temp.remove(notebook); 
                 }
                 for (Object pair2 : criterias.keySet()) { 
                    if (pair2.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair2))) {
                       temp.remove(notebook); 
                    }
                    for (Object pair3 : criterias.keySet()) {  
                       if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair3))) {
                          temp.remove(notebook); 
                       }
                       for (Object pair4 : criterias.keySet()) {  
                          if (pair4.equals("5") && !notebook.getColour().equals(criterias.get(pair4))) {
                             temp.remove(notebook);  
                          }
                       }
                    }
                 }
              }
           }  
        }
        if (temp.isEmpty()) {
           System.out.println("К сожалению, ничего не найдено. Попробуйте изменить характеристики поиска. ");
        } else {
           System.out.println("В наличие есть: \n" + temp.toString());
        } 
     }   
}
