public class Game {
    private Warrior warrior;
    private Wizard wizard;

    public Game() {
        warrior = new Warrior();
        wizard = new Wizard();
    }

    public void play() {
        while (warrior.getHealth() > 0 && wizard.getHealth() > 0) {
            warrior.move();
            wizard.move();
            if (warrior.getPosition() == wizard.getPosition()) {
                warrior.fight(wizard);
                System.out.println("X__ --> harc: H:" + warrior.getHealth() + ", V:" + wizard.getHealth());
            } else {
                String positions = "";
                for (int i = 0; i < 3; i++) {
                    if (warrior.getPosition() == i) {
                        positions += "H";
                    } else if (wizard.getPosition() == i) {
                        positions += "V";
                    } else {
                        positions += "_";
                    }
                }
                System.out.println(positions + " --> H:" + warrior.getHealth() + ", V:" + wizard.getHealth());
            }
        }
    }



    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
