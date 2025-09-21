package lab1;
import java.io.*;
import java.util.*;

/**
 * ���� lab1 ������ ������� �������� �� ����������� ������ �1
 */
public class LAB_1 {

    /**
     * ��������� ����� main � ������ ����� � ��������
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

        System.out.print("������ ����� ��������� �������: ");
        nRows = in.nextInt();
        in.nextLine(); // ������� ������ ���� �����

        arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[nRows - i];
        }

        System.out.print("\n������ ������-����������: ");
        filler = in.nextLine();

        if (filler.length() != 1) {
            if (filler.length() == 0)
                System.out.println("�� ������� ������-����������");
            else
                System.out.println("�������� �������-������������");
            fout.close();
            return;
        }

        char symbol = filler.charAt(0);

        for (int i = 0; i < nRows; i++) {
            StringBuilder row = new StringBuilder();

            // �������
            for (int s = 0; s < i; s++) {
                row.append("  "); // ��� ������
            }

            // �������
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = symbol;
                row.append(symbol).append(" ");
            }

            // ������� ����� � � � �������, � � ����
            System.out.println(row.toString());
            fout.println(row.toString());
        }

        fout.close();
        in.close();
    }
}