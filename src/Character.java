import java.util.Random;

abstract class Character implements Combatant {
    private int health;
    private int position;

    public Character() {
        Random r = new Random();
        this.health = r.nextInt(6) + 4;  // d6+3-nak felel meg, mert 0-tól dob a random szám nem 1 től, mint egy rendes kocka
        this.position = r.nextInt(3); // random kezdőhely
    }

    @Override
    public void move() {
        Random r = new Random();
        this.position = r.nextInt(3);  // random kezdőhely

    }

    @Override
    public void fight(Combatant opponent) {
        if (!(opponent instanceof Character)) {
            throw new IllegalArgumentException("Opponent must be a Character");

        }
        Random r = new Random();
        this.health -= r.nextInt(6) + 1;  // d6 damage
        ((Character) opponent).health -= r.nextInt(6) + 1; // d6 damage
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }
}
