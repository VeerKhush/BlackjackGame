package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand {
    private ArrayList<BlackjackCard> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(BlackjackCard card) {
        cards.add(card);
    }

    public ArrayList<BlackjackCard> getCards() {
        return cards;
    }

    public int getTotalValue() {
        int total = 0;
        int aces = 0;

        for (BlackjackCard card : cards) {
            total += card.getValue();
            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder();
        for (BlackjackCard card : cards) {
            handString.append(card.toString()).append("\n");
        }
        return handString.toString();
    }
}