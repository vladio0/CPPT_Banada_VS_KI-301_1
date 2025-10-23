package lab2.test;

import java.io.*;
import java.util.*;


/**
 * Class <code>Human</code> models a human being with heart, brain and leg.
 */
public class Human {
    private Heart heart;
    private Brain brain;
    private Leg leg;
    private int energyLevel;
    protected PrintWriter fout;  // лог-файл

    /**
     * Default constructor – creates a human with default organs.
     *
     * @throws FileNotFoundException
     */
    public Human() throws FileNotFoundException {
        heart = new Heart();
        brain = new Brain();
        leg = new Leg();
        energyLevel = 100;
        fout = new PrintWriter(new File("HumanLog.txt"));
    }

    /**
     * Constructor with parameters
     */
    public Human(int heartHealth, int memoryCapacity, int legStrength) throws FileNotFoundException {
        heart = new Heart(heartHealth);
        brain = new Brain(memoryCapacity);
        leg = new Leg(legStrength);
        energyLevel = 100;
        fout = new PrintWriter(new File("HumanLog.txt"));
        fout.println("Human created with custom parameters");
        fout.flush();
    }

    public void eat(String food) {
        energyLevel = Math.min(100, energyLevel + 10);
        fout.println("Human ate: " + food);
        fout.flush();
    }

    public void sleep(int hours) {
        brain.increaseConcentration(hours * 10);
        energyLevel = Math.min(100, energyLevel + hours * 5);
        fout.println("Human slept " + hours + " hours");
        fout.flush();
    }

    public void walk(int steps) {
        leg.walk(steps);
        heart.increaseBPM(steps / 2);
        energyLevel = Math.max(0, energyLevel - steps / 5);
        fout.println("Human walked " + steps + " steps");
        fout.flush();
    }

    public void run(int steps) {
        leg.run(steps);
        heart.increaseBPM(steps);
        energyLevel = Math.max(0, energyLevel - steps / 3);
        fout.println("Human ran " + steps + " steps");
        fout.flush();
    }

    public void think(String idea) {
        brain.remember(idea);
        fout.println("Human thought about: " + idea);
        fout.flush();
    }

    public void forget() {
        brain.forget();
        fout.println("Human forgot last idea.");
        fout.flush();
    }

    public void heartbeat() {
        fout.println("Heart beat: " + heart.getBeatsPerMinute() + " BPM");
        fout.flush();
    }

    public String getHealthStatus() {
        return heart.checkHealth();
    }


    public int getEnergyLevel() {
        return energyLevel;
    }


    public String getLastIdea() {
        return brain.getLastIdea();
    }


    public int getSteps() {
        return leg.getSteps();
    }


    public void dispose() {
        fout.println("Human disposed");
        fout.flush();
        fout.close();
    }


}
/**
 * Class <code>Heart</code> models human heart.
 */
class Heart {
    private int beatsPerMinute;
    private int healthLevel;

    public Heart() {
        beatsPerMinute = 72;
        healthLevel = 100;
    }

    public Heart(int health) {
        beatsPerMinute = 72;
        healthLevel = health;
    }

    public void increaseBPM(int value) {
        beatsPerMinute += value;
    }

    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    public String checkHealth() {
        if (healthLevel > 100) return "Good";
        else if (healthLevel > 40) return "Average";
        else return "Bad";
    }
}
    /**
     * Class <code>Brain</code> models human brain.
     */
    class Brain {
        private int memoryCapacity;
        private int concentrationLevel;
        private List<String> ideas;

        public Brain() {
            memoryCapacity = 10;
            concentrationLevel = 50;
            ideas = new ArrayList<>();
        }

        public Brain(int memoryCapacity) {
            this.memoryCapacity = memoryCapacity;
            concentrationLevel = 50;
            ideas = new ArrayList<>();
        }

        public void remember(String info) {
            if (ideas.size() < memoryCapacity) {
                ideas.add(info);
            }
        }

        public void forget() {
            if (!ideas.isEmpty()) {
                ideas.remove(ideas.size() - 1);
            }
        }

        public String getLastIdea() {
            if (ideas.isEmpty()) return "No ideas";
            return ideas.get(ideas.size() - 1);
        }

        public void increaseConcentration(int value) {
            concentrationLevel = Math.min(100, concentrationLevel + value);
        }

        public int getConcentrationLevel() {
            return concentrationLevel;
        }
    }

/**
* Class <code>Leg</code> models human leg.
*/
class Leg {

        private int steps;
        private int strength;

        public Leg() {
            steps = 0;
            strength = 100;
        }

        public Leg(int strength) {
            this.strength = strength;
            steps = 0;
        }

        public void walk(int steps) {
            this.steps += steps;
        }

        public void run(int steps) {
            this.steps += steps;
            strength -= steps / 10;
        }

        public int getSteps() {
            return steps;
        }

        public int getStrength() {
            return strength;
        }
    }