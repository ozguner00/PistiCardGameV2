public class Player {
    private int score = 0;
    private String name;
    private Deck deck = new Deck();
    private Hand hand = new Hand();
    private int scoreLimit;

    public Player(String name, int scoreLimit) {
        this.name = name;
        this.scoreLimit = scoreLimit;
    }

    public Player() {
    }

    public void printNameScore(){
        System.out.println("Name:" + this.name + " Score:" + this.score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

}
