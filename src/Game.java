import java.util.Scanner;

public class Game {
    private int level;
    private static int scoreLimit;
    private Player player;
    private Table gameTable;
    private Computer computer;
    private Deck gameDeck ;
    private boolean playerLastWin = true; // yerdeki son kağıdı kim aldı.
    private static int dealerCounter; // round bitişi ve kart dağıtımında kullanılabilir.
    private boolean dealerPlayer = true;
    private int selectCardComputer;
    private int selectCardPlayer;
    private Scanner sc = new Scanner(System.in);


    public Game(int scoreLimit, String name) {

        this.scoreLimit = scoreLimit;
        this.gameTable = new Table();
        this.player = new Player(name,scoreLimit);
        this.computer = new Computer();
        this.gameDeck = new Deck("GameDeck");
        System.out.println("Oyun Başarıyla Oluşturuldu.Game Limit:" + scoreLimit);
        run();
    }

    public void run(){
        while(GameHelper.checkWinner(player.getScore(), computer.getScore(),this.scoreLimit)){
            dealerCounter = 0;
            gameDeck.shuffleDeck();
            System.out.println("OYUN KARIŞTIRILMIŞ DECK");
            gameDeck.printDeck(); // control
            raund(dealerPlayer);
            //dealerPlayer = !dealerPlayer; // dealer computer sonra yazılacak.
        }
    }

    public void raund(boolean dealerPlayer){
        System.out.println("*****************ROUND BAŞLADI*******************");
        dealerHand(gameTable.getHand());
        System.out.println("Yerdeki Card :"+gameTable.getHand().getCard(3) + " Kart sayısı :" + 4);
        computer.addWiewDeck(gameTable.getHand().getCard(3)); // yerdeki 4. kartı ekledik.
        gameTable.getHand().printHand();
        System.out.println("---------------------------------------");
        if(dealerPlayer){
            raundPlayer();
        }else{
            raundComputer();
        }
        if(playerLastWin){
            GameHelper.winDeckFillandClear(gameTable.getDeck(),player.getDeck());
        }else{
            GameHelper.winDeckFillandClear(gameTable.getDeck(),computer.getDeck());
        }
        player.setScore(player.getScore()+GameHelper.scoreCal(player.getDeck()));
        computer.setScore(computer.getScore()+GameHelper.scoreCal(computer.getDeck()));
        player.getDeck().getDeck().clear();
        computer.getDeck().getDeck().clear();
        System.out.println("--------------ROUND SONU PUAN DURUMU-----------");
        player.printNameScore();
        computer.printNameScore();
    }

    public void raundComputer(){ // dealer computer sonra yazılacak.

    }


    public void raundPlayer(){
        while (dealerCounter < 52){
            dealerHand(player.getHand());
            dealerHand(computer.getHand());

            // computer kendi elini, yerdeki 4. kartı ve playerın oynadığı kartları görüp ihtimal hesaplar
            for(int card: computer.getHand().getHand()){
                computer.addWiewDeck(card);
            }
            // computer kendi elini, yerdeki 4. kartı ve playerın oynadığı kartları görüp ihtimal hesaplar

            System.out.println("Dealer Counter : " + dealerCounter);
            while(true){
                if(player.getHand().handSize() != 0 ||computer.getHand().handSize() != 0){
                    player.getHand().printHand();
                    computer.getHand().printHand();
                    while (true){
                        System.out.println("Oynamak istediğiniz kartın sırasını giriniz:0-1-2-3");
                        selectCardPlayer = sc.nextInt();
                        try{
                            //System.out.println("Seçilen kart : " + player.getHand().getCard(selectCardPlayer));
                            gameTable.getDeck().addCard(player.getHand().getCard(selectCardPlayer));
                            if(GameHelper.winCheck(gameTable.getDeck(),player.getHand().getCard(selectCardPlayer), gameTable.getHand(),player)){
                                playerLastWin = true;
                            }
                            computer.addWiewDeck(player.getHand().getCard(selectCardPlayer));
                            player.getHand().removeCard(selectCardPlayer);
                            gameTable.getDeck().printLastCard(gameTable.getHand());
                            break;
                        }catch (Exception e){
                            System.out.println("Hatalı kart seçtiniz lütfen tekrar deneyiniz.");
                        }
                    }
                    selectCardComputer = computer.computerSelectCardIndex(gameTable.getDeck().getLastCard(),scoreLimit,dealerCounter,player.getScore());
                    //System.out.println("Seçilen kart : " + computer.getHand().getCard(selectCardComputer));
                    gameTable.getDeck().addCard(computer.getHand().getCard(selectCardComputer));
                    if(GameHelper.winCheck(gameTable.getDeck(),computer.getHand().getCard(selectCardComputer), gameTable.getHand(),computer)){
                        playerLastWin = false;
                    }
                    computer.getHand().removeCard(selectCardComputer);
                    gameTable.getDeck().printLastCard(gameTable.getHand());

                }
                else{
                    break;
                }

            }

        }
    }


    public void dealerHand(Hand hand){
        while (hand.handSize() < 4){
            hand.addCard(gameDeck.getDeck().get(dealerCounter));
            dealerCounter++;
        }
    }
}
