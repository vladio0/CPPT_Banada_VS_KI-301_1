package lab;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 * @author EOM Stuff
 * @version 1.0
 */
public class EquationsApp {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try
            {
                try
                {
                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                }
                finally
                {
// Цей блок виконається за будь-яких обставин
                    fout.flush();
                    fout.close();
                }
            }
            catch (CalcException ex)
            {
// Блок перехоплює помилки обчислень виразу
                out.print(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex)
        {
// Блок перехоплює помилки роботи з файлом навіть якщо вони виникли у блоці finally
            out.print("Exception reason: Perhaps wrong file path.");
        }
    }
}
/**
 * Class <code>CalcException</code> more precises ArithmeticException
 * @author EOM Stuff
 * @version 1.0
 */
class CalcException extends ArithmeticException
{
    public CalcException(){}
    public CalcException(String cause)
    {
        super(cause);
    }
}
/**
 * Class <code>Equations</code> implements method for ((2 / tg(x)) / x) expression
 * calculation
 * @author EOM Stuff
 * @version 1.0
 */
class Equations {
    public double calculate(int x) throws CalcException {
        double y = 0, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = Math.tan(rad);

// Якщо результат не є числом, то генеруємо виключення
            if (Double.isNaN(y) || Double.isInfinite(y) || Math.abs(x % 180) == 90)
                throw new ArithmeticException();
        }
        catch (ArithmeticException ex) {
// створимо виключення вищого рівня з поясненням причини виникнення помилки
            if (Math.abs(x % 180) == 90)
                throw new CalcException("Exception reason: X = 90 + 180n, tangent is undefined.");
            else if (Double.isNaN(y))
                throw new CalcException("Exception reason: Result is not a number (NaN).");
            else
                throw new CalcException("Unknown reason of the exception during tangent calculation.");
        }
            return y;
    }
}