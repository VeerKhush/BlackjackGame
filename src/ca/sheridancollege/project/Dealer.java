package ca.sheridancollege.project;

public class Dealer extends Player {
    private Hand hand;

    public Dealer(String name) {
        super(name);
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public void play() {
        System.out.println("Dealer's turn:");
        while (hand.getTotalValue() < 17) {
            hand.addCard((BlackjackCard) BlackjackGame.deck.deal());
            System.out.println("Dealer hits: " + hand);
        }
        System.out.println("Dealer stands with: " + hand.getTotalValue() + " points.");
    }
}