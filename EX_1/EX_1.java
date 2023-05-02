package EX_1;

import java.io.*;
import java.util.HashMap;
import java.util.*;

/**
 * EX_1
 */
public class EX_1 {

    private static HashMap<String, String> Book = new HashMap<String, String>();

    private static void add(String phone, String name) {
        Book.put(phone, name);
    }

    private static void delete(String phone) {
        Book.remove(phone);
    }

    private static void save() throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(new File("Book.txt")));
        for (Map.Entry<String, String> p : Book.entrySet()) {
            wr.write(p.getKey() + " " + p.getValue() + System.lineSeparator());
        }
        wr.close();
    }

    public static void read() throws IOException {
        File file = new File("Book.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(new File("Book.txt")));
            String choice;
            while ((choice = reader.readLine()) != null) {
                String[] dat = choice.split(" ");
                Book.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    public static void PrintBook() {
        System.out.println("Cправочник: ");
        for (Map.Entry<String, String> p : Book.entrySet()) {
            System.out.println(p.getValue() + ": " + p.getKey());
        }
    }

    public static String findnumder(String numder) {
        String res = Book.get(numder);
        if (res == null) {
            return "not number";
        }
        return res;
    }

    public static void main(String[] args)throws IOException {
        
        read();
        PrintBook();
        System.out.println();
        Menu();
    }

    public static void Menu()throws IOException {
        Scanner iScanner = new Scanner(System.in);
        String phone, name;

        System.out.println("Choice: ");
        System.out.println("1. Записать");
        System.out.println("2. Удалить");
        System.out.println("3. Поиск по номеру");
        System.out.println("4. Exit");
        int choice = iScanner.nextInt();
        iScanner.nextLine();
        switch (choice) {

            case 1:
                System.out.println("Введите фамилию: ");
                name = iScanner.nextLine();
                System.out.println("Введите телефон: ");
                phone = iScanner.nextLine();
                add(phone, name);
                save();
                break;

            case 2:
                System.out.println("Введите телефон: ");
                phone = iScanner.nextLine();
                delete(phone);
                break;

            case 3:
                System.out.println("Введите номер:");
                phone = iScanner.nextLine();
                System.out.println(findnumder(phone));
                break;

        

            default:
                System.out.println("Exit");
                break;

            
        }
        iScanner.close();
    }
}