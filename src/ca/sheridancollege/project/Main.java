/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args){
        //Creating the instance of game :
        BlackjackGame game= new BlackjackGame ("BlackjackGame");
        
        // Creating the players 
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter number of Players :");
        int numPlayers = scanner .nextInt();
        scanner.nextLine(); // Using  newline 
        
        ArrayList<Player> players = new ArrayList<>();
        for (int i=1 ; i<=numPlayers; i++){
            System.out.print("Enter name for player" + i +":");
            String name =scanner.nextLine();
            players.add(new BlackjackPlayer(name));
        }
        game.setPlayers(players);
        
        //Playing the game
        game.play();
    }
}