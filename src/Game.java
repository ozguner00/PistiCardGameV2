import java.util.Scanner;

public class Game {
    private int level;
    private int scoreLimit;
    private Player player;
    private Table gameTable;
    private Computer computer;
    private Deck gameDeck ;
    private boolean playerLastWin = true; // yerdeki son kağıdı kim aldı.
    private int dealerCounter; // round bitişi ve kart dağıtımında kullanılabilir.
    private boolean dealerPlayer = true;
    private boolean isPisti = false; // Rounda ilk başlangıç yerdeki kağıtların hesabı için ilk kart atıldığında yere true döner.
    //ilk 3 kart table hand 4. kart table deck. pisti check table deck size == 2 and isStart == true kontrolü. ilk kart pişti olmaz kapalı kağıtlardan dolayı.P
    private int selectCardComputer = 0;
    private int selectCardPlayer;
    private Scanner sc = new Scanner(System.in);


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
            isPisti = false;
            dealerCounter = 0;
            gameDeck.shuffleDeck();
            gameDeck.printDeck(); // control
            raund(dealerPlayer);
            //dealerPlayer = !dealerPlayer; // dealer computer sonra yazılacak.
        }
    }

    public void raund(boolean dealerPlayer){
        System.out.println("*****************ROUND BAŞLADI*******************");
        System.out.println(player.getName() + " Score :" + player.getScore());
        System.out.println("Computer Score :" + computer.getScore());
        dealerHand(gameTable.getHand());
        gameTable.getHand().printHand();
        System.out.println("---------------------------------------");
        if(dealerPlayer){
            raundPlayer();
        }else{
            raundComputer();
        }
        System.out.println("El bitti puan hesaplanacak.");
        System.out.println(playerLastWin);
        if(playerLastWin){
            GameHelper.winDeckFillandClear(gameTable.getDeck(),player.getDeck());
        }else{
            GameHelper.winDeckFillandClear(gameTable.getDeck(),computer.getDeck());
        }
        player.setScore(player.getScore()+GameHelper.scoreCal(player.getDeck()));
        computer.setScore(computer.getScore()+GameHelper.scoreCal(computer.getDeck()));
        player.getDeck().getDeck().clear();
        computer.getDeck().getDeck().clear();

        System.out.println("ROUND BİTTİ GÜNCEL PUANLAR:" +player.getName() + player.getScore() + " Compıter :"+  computer.getScore());
    }

    public void raundComputer(){ // dealer computer sonra yazılacak.

    }


    public void raundPlayer(){
        while (dealerCounter < 52){
            dealerHand(player.getHand());
            dealerHand(computer.getHand());
            System.out.println("Dealer Counter : " + dealerCounter);
            while(true){
                if(player.getHand().handSize() != 0 ||computer.getHand().handSize() != 0){
                    player.getHand().printHand();
                    computer.getHand().printHand();
                    while (true){
                        System.out.println("Oynamak istediğiniz kartın sırasını giriniz:0-1-2-3");
                        selectCardPlayer = sc.nextInt();
                        try{
                            System.out.println("Seçilen kart : " + player.getHand().getCard(selectCardPlayer));
                            gameTable.getDeck().addCard(player.getHand().getCard(selectCardPlayer));
                            if(GameHelper.winCheck(gameTable.getDeck(),player.getHand().getCard(selectCardPlayer), gameTable.getHand(),player)){
                                playerLastWin = true;
                            }
                            player.getHand().removeCard(selectCardPlayer);
                            break;
                        }catch (Exception e){
                            System.out.println("Hatalı kart seçtiniz lütfen tekrar deneyiniz.");
                        }
                    }
                    System.out.println("Seçilen kart : " + computer.getHand().getCard(selectCardComputer));
                    gameTable.getDeck().addCard(computer.getHand().getCard(selectCardComputer));
                    if(GameHelper.winCheck(gameTable.getDeck(),computer.getHand().getCard(selectCardComputer), gameTable.getHand(),computer)){
                        playerLastWin = false;
                    }
                    computer.getHand().removeCard(selectCardComputer);

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
