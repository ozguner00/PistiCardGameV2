public class Computer extends Player{
    private int score = 0;
    private String name = "Computer";
    private Deck deck = new Deck();
    private Hand hand = new Hand();

   /* private List<Integer> probabilityList = new ArrayList<Integer>();
    private HashMap<Integer,Double> probabilityMap= new HashMap<Integer,Double>();
    private Deck wiewDeck = new Deck(); //probability
    private List<Integer> playedCardCounter = new ArrayList<>(13); // probability
    private int wiewDeckIt = 0; // probability?*/


    public Computer() {
        super();
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

    public int computerSelectCardIndex(){

        return 0;
    }
}
