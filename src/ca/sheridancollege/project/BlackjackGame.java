package ca.sheridancollege.project;

import java.util.ArrayList;

public class BlackjackGame extends Game {
    public static GroupOfCards deck;
    private Dealer dealer;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        dealer = new Dealer("Dealer");
    }

    @Override
    public void play() {
        initializeDeck();
        deck.shuffle();
        dealInitialCards();

        for (Player player : getPlayers()) {
            player.play();
        }

        dealer.play();
        declareWinner();
    }

    @Override
    public void declareWinner() {
        for (Player player : getPlayers()) {
            int playerScore = ((BlackjackPlayer) player).getHand().getTotalValue();
            int dealerScore = dealer.getHand().getTotalValue();
            if (playerScore > 21) {
                System.out.println(player.getName() + " busts! Dealer wins.");
            } else if (dealerScore > 21) {
                System.out.println(dealer.getName() + " busts! " + player.getName() + " wins.");
            } else if (playerScore > dealerScore) {
                System.out.println(player.getName() + " wins with " + playerScore + " points.");
            } else if (playerScore < dealerScore) {
                System.out.println(dealer.getName() + " wins with " + dealerScore + " points.");
            } else {
                System.out.println("It's a tie between " + player.getName() + " and Dealer.");
            }
        }
    }

    public void initializeDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new BlackjackCard(suit, ranks[i], values[i]));
            }
        }
        deck.setCards(cards);
    }

    public void dealInitialCards() {
        for (Player player : getPlayers()) {
            ((BlackjackPlayer) player).getHand().addCard((BlackjackCard) deck.deal());
            ((BlackjackPlayer) player).getHand().addCard((BlackjackCard) deck.deal());
        }
        dealer.getHand().addCard((BlackjackCard) deck.deal());
        dealer.getHand().addCard((BlackjackCard) deck.deal());
    }

    public Dealer getDealer() {
        return dealer;
    }
}