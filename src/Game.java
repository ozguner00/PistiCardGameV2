public class Game {
    private int level;
    private int scoreLimit;
    private Player player;
    private Table gameTable;
    private Computer computer;
    private Deck gameDeck ;
    private boolean playerLastWin = true; // yerdeki son kağıdı kim aldı.
    private int dealerCounter; // round bitişi ve kart dağıtımında kullanılabilir.
    private int playerPistiPoint ;
    private int computerPistiPoint ;
    private boolean dealerPlayer = true;
    private boolean isStart = false; // Rounda ilk başlangıç yerdeki kağıtların hesabı için ilk kart atıldığında yere true döner.
    //ilk 3 kart table hand 4. kart table deck. pisti check table deck size == 2 and isStart == true kontrolü. ilk kart pişti olmaz kapalı kağıtlardan dolayı.P

    public Game(int scoreLimit, String name) {
        this.scoreLimit = scoreLimit;
        this.gameTable = new Table();
        this.player = new Player(name,scoreLimit);
        this.computer = new Computer();
        this.gameDeck = new Deck("GameDeck");
        System.out.println("Oyun Başarıyla Oluşturuldu.Game Limit:" + scoreLimit);
        player.printNameScore();
        computer.printNameScore();
        run();
    }

    public void run(){
        while(GameHelper.checkWinner(player.getScore(), computer.getScore(),this.scoreLimit)){
            gameDeck.printDeck();
            gameDeck.shuffleDeck();
            dealerTableHand();
            gameTable.getHand().printHand();
            raund(dealerPlayer);
            dealerPlayer = !dealerPlayer;
        }
    }

    public void raund(boolean dealerPlayer){
        if(dealerPlayer){
            raundPlayer();
        }else{
            raundComputer();
        }
        player.setScore(player.getScore()+20);
    }

    public void raundComputer(){

    }



    public void raundPlayer(){

    }

    public void dealerTableHand(){
        while (gameTable.getHand().handSize() < 4){
            gameTable.getHand().addCard(gameDeck.getDeck().get(dealerCounter));
            dealerCounter++;
        }

    }
}
