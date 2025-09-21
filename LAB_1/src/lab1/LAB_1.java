package lab1;
import java.io.*;
import java.util.*;

/**
 * Клас lab1 реалізує приклад програми до лабораторної роботи №1
 */
public class LAB_1 {

    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine(); // очистка буфера після числа

        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows - i];
        }

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        if (filler.length() != 1) {
            if (filler.length() == 0)
                System.out.println("Не введено символ-заповнювач");
            else
                System.out.println("Забагато символів-заповнювачів");
            fout.close();
            return;
        }

        char symbol = filler.charAt(0);

        for (int i = 0; i < nRows; i++) {
            StringBuilder row = new StringBuilder();

            // відступи
            for (int s = 0; s < i; s++) {
                row.append("  "); // два пробіли
            }

            // символи
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = symbol;
                row.append(symbol).append(" ");
            }

            // готовий рядок — і в консоль, і у файл
            System.out.println(row.toString());
            fout.println(row.toString());
        }

        fout.close();
        in.close();
    }
}