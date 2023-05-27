public class Game {
    private Warrior warrior;
    private Wizard wizard;

    public Game() {
        warrior = new Warrior();
        wizard = new Wizard();
    }

    public void play() {
        try {

            System.out.println("Kezdőélet: H: " + warrior.getHealth() + ", V: " + wizard.getHealth());

            while (warrior.getHealth() > 0 && wizard.getHealth() > 0) {
                warrior.move();
                wizard.move();
                String positions = "";

                for (int i = 0; i < 3; i++) {
                    if (warrior.getPosition() == i && wizard.getPosition() == i) {
                        positions += "X";  // mindkettő ugyan ott van és harcol
                    } else if (warrior.getPosition() == i) {
                        positions += "H";
                    } else if (wizard.getPosition() == i) {
                        positions += "V";
                    } else {
                        positions += "_";
                    }
                }
                if (warrior.getPosition() == wizard.getPosition()) {
                    warrior.fight(wizard);
                    System.out.println(positions + " --> harc: H:" + warrior.getHealth() + ", V:" + wizard.getHealth());
                } else {
                    System.out.println(positions + " --> H:" + warrior.getHealth() + ", V:" + wizard.getHealth());
                }

                if (warrior.getHealth() <= 0 && wizard.getHealth() <= 0) {
                    throw new GameOverException("Döntetlen! Dühükben elpusztították egymást!");
                } else if (warrior.getHealth() <= 0) {
                    throw new GameOverException("A bölcs varázsló nyert!");
                } else if (wizard.getHealth() <= 0) {
                    throw new GameOverException("A hatalmas harcos nyert!");
                }
            }
        } catch (GameOverException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
