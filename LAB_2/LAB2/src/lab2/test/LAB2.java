package lab2.test;

import static java.lang.System.out;

/**
 * Driver class for testing Human.
 */
public class LAB2 {
    public static void main(String[] args) throws Exception {
        Human person = new Human();

        person.eat("Apple");
        person.walk(10);
        person.think("Java is fun");
        person.run(20);
        person.sleep(2);

        out.println("Health status: " + person.getHealthStatus());
        out.println("Total steps: " + person.getSteps());
        out.println("Last idea: " + person.getLastIdea());
        out.println("Energy level: " + person.getEnergyLevel());

        person.dispose();
    }
}
