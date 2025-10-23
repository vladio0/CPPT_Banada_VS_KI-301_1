package lab2.test;

/**
 * Driver class for testing Human and Athlete.
 */
public class LAB2 {
    public static void main(String[] args) {
        try {
            Athlete athlete = new Athlete("Vladyslav", 50, 10);

            athlete.eat("Banana");
            athlete.move(20);
            athlete.move(15);
            athlete.sleep(2);

            // Виводимо, скільки км залишилось до відпочинку
            double kmLeft = athlete.kilometersToRest();
            System.out.println("Кілометрів залишилось до відпочинку: " + kmLeft + " км");

            athlete.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
