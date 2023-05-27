import java.util.Random;

abstract class Character {
    private int health;
    private int position;

    public Character() {
        Random r = new Random();
        this.health = r.nextInt(6) + 4;  // d6+3-nak felel meg, mert 0-tól dob a random szám nem 1 től, mint egy rendes kocka
        this.position = r.nextInt(3); // random kezdőhely
    }

    public void move() {
        Random r = new Random();
        this.position = r.nextInt(3);  // random kezdőhely
    }

    public void fight(Character opponent) {
        Random r = new Random();
        this.health -= r.nextInt(6) + 1;  // sebzés de itt is kell +1, mert 0-át nem lehet kockán dobni
        opponent.health -= r.nextInt(6) + 1;
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }
}
