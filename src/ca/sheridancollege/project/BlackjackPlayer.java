package ca.sheridancollege.project;

import java.util.Scanner;

public class BlackjackPlayer extends Player {
    private Hand hand;

    public BlackjackPlayer(String name) {
        super(name);
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println(getName() + "'s turn:");
            System.out.println("Current hand: " + hand);
            System.out.print("Do you want to hit or stand? ");
            String decision = scanner.nextLine();

            if (decision.equalsIgnoreCase("hit")) {
                hand.addCard((BlackjackCard) BlackjackGame.deck.deal());
                System.out.println("New card: " + hand);
                if (hand.getTotalValue() > 21) {
                    System.out.println(getName() + " busts!");
                    isPlaying = false;
                }
            } else if (decision.equalsIgnoreCase("stand")) {
                isPlaying = false;
            } else {
                System.out.println("Invalid input. Please type 'hit' or 'stand'.");
            }
        }
    }
}