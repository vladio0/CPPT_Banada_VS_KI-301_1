package lab2.test;

import java.io.FileNotFoundException;

/**
 * Клас Athlete розширює Human і реалізує інтерфейс Powered.
 * Демонструє рух, витрату енергії та визначення дистанції до відпочинку.
 */
public class Athlete extends Human implements Powered {

    private String name;
    private double stamina;      // запас енергії
    private double speed;        // швидкість руху
    private double distance;     // пройдена дистанція

    /**
     * Конструктор із параметрами.
     */
    public Athlete(String name, double stamina, double speed) throws FileNotFoundException {
        super(); // виклик конструктора Human
        this.name = name;
        this.stamina = stamina;
        this.speed = speed;
        this.distance = 100.0;//початкова дистанція
        log("Створено атлета " + name + " із витривалістю " + stamina + " і швидкістю " + speed);
    }

    /**
     * Реалізація методу move() з інтерфейсу Moveable.
     */
    @Override
    public void move(double x) {
        distance -= x;
        stamina -= x / 10;//умовна витрата енергії
        if (stamina < 0) stamina = 0;
        log(name + " пройшов " + x + " км. Загальна дистанція: " + distance + " км. Витривалість: " + stamina);
    }

    /**
     * Реалізація методу kilometersToRest() з інтерфейсу Powered.
     */
    public double kilometersToRest() {
        double kmLeft = stamina / 2.0; // скільки може пройти до відпочинку
        distance -= kmLeft; // зменшуємо пройдену дистанцію
        if (distance < 0) distance = 0;
        log(name + " може пробігти ще " + kmLeft + " км до відпочинку. " +
                "Після відпочинку загальна дистанція: " + distance + " км.");
        return kmLeft;
    }
    /**
     * Метод для отримання загальної дистанції.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Допоміжний метод для виводу повідомлень у файл і консоль.
     */
    private void log(String text) {
        System.out.println(text);
        fout.println(text);
        fout.flush();
    }

}
