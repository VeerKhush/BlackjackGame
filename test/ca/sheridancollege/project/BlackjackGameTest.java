package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;

public class BlackjackGameTest {
    
    private BlackjackGame game;
    private BlackjackPlayer player;
    private Dealer dealer;

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        game = new BlackjackGame("Blackjack Test");
        player = new BlackjackPlayer("Test Player");
        dealer = new Dealer("Dealer");
        game.setPlayers(new ArrayList<>(Collections.singletonList(player)));
        game.initializeDeck();
        game.deck.shuffle();
        game.dealInitialCards();
    }
    
    @AfterEach
    public void tearDown() {
        game = null;
        player = null;
        dealer = null;
    }

    @Test
    public void testPlay() {
        System.out.println("play");
        game.play();
        assertNotNull(game.getPlayers());
        assertFalse(game.getPlayers().isEmpty());
    }

    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        game.declareWinner();
    }

    @Test
    public void testInitialCardDealing() {
        System.out.println("testInitialCardDealing");
        assertEquals(2, player.getHand().getCards().size());
        assertEquals(2, dealer.getHand().getCards().size());
    }

    @Test
    public void testPlayerHit() {
        System.out.println("testPlayerHit");
        player.getHand().addCard((BlackjackCard) BlackjackGame.deck.deal());
        assertEquals(3, player.getHand().getCards().size());
    }

    @Test
    public void testDealerBehavior() {
        System.out.println("testDealerBehavior");
        while (player.getHand().getTotalValue() <= 21) {
            player.getHand().addCard((BlackjackCard) BlackjackGame.deck.deal());
        }
        dealer.play();
        int dealerHandValue = dealer.getHand().getTotalValue();
        assertTrue(dealerHandValue >= 17);
    }

    @Test
    public void testPlayerBust() {
        System.out.println("testPlayerBust");
        player.getHand().addCard(new BlackjackCard("Hearts", "King", 10));
        player.getHand().addCard(new BlackjackCard("Diamonds", "Queen", 10));
        player.getHand().addCard(new BlackjackCard("Clubs", "2", 2));
        assertTrue(player.getHand().getTotalValue() > 21);
    }
}