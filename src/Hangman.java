////////////////////////////////////////////////////
// Hangman by Xandra Russell
// Start: 1 May 2015
// Last Modified: 6 May 2015
// Eventually, I want to have a dictionary (or multiple dictionaries) that users can modify
// and the option for 2 players, where they take turn choosing and guessing
// I also want to define the word at the end if the user loses (would only work if the word was in the dictionary)
// So far this game can only be played with two players
//
// Known bugs: will allow player to choose a secret word that contains characters
// the other player is not allowed to guess
//
// Nex steps:
//          -choose single or two player;
//          for single player have default dictionary & allow to choose alternate
//          that it reads in
//          -figure out how to print backslashes to edit hangman image for symmetry (remove *)
////////////////////////////////////////////////////

import java.util.*;

public class Hangman {

    public static void main(String[] arg){

        Scanner scan = new Scanner(System.in);

        //Scanning in secret word
        System.out.print("Enter a word for the other player to guess: ");
        String secretword = scan.next();        //never modify String secretword!!

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");     //scrolls secret word input off screan

        //fill in the array secret. this array should never be altered.
        String[] secret = new String[secretword.length()];
        for(int i =0; i<secretword.length(); i++){
            secret[i] = String.valueOf(secretword.charAt(i));   //converts char at i to string and adds it to secret array
        }

        //create the display of underscores based on the secret word. as correct guesses are made, display will be updated
        String[] display = new String[secretword.length()];
        for(int i =0; i<secretword.length(); i++){
            display[i] = " _";   //display starts as underscores, as many as letters in secretword
        }

        //print game start
        System.out.println(hangstand);
        System.out.println(stringdisplay(display));

        //declare variables needed for guessing
        String guess;
        String guesses ="";
        int numwrong=0;
        boolean gameover=false;

        //start guessing
        System.out.print("Guess a letter: ");

        while(!gameover){
            guess = scan.next();

            //before determining whether their guess was correct, check that it is valid:
            while(guesses.contains(guess)){
                System.out.print("You've already guessed " + guess + "; guess another letter: ");
                guess = scan.next();
            }
            while (guess.length() != 1) {
                System.out.print("Guess only one letter: ");
                guess = scan.next();
            }
            while (nonchar(guess)){
                System.out.print("Invalid guess; guess a letter: ");
                guess=scan.next();
            }

            //once we've checked that it's valid, we can add it to the list of guesses
            guesses = guesses  + " " + guess;


            if(secretword.contains(guess)){
                for(int i =0; i<secretword.length(); i++){
                    if(secret[i].equals(guess)) display[i] = guess;
                }
                if(stringdisplay(display).equals(secretword)){  //if they've got the whole word (win)
                    System.out.println(free);
                    System.out.println(stringdisplay(display));
                    System.out.println("You win!");
                    gameover = true;
                }
                else{   //if they got part of the word
                    System.out.println(stringdisplay(display));
                    System.out.print("You got it! Guess another letter: ");
                }
            }   //this brace ends the if their guess was right statements

            else{   //if their guess was wrong
                numwrong++;
                if(numwrong <7){    //if they didn't lose yet
                    if (numwrong == 1) System.out.print(head);
                    if (numwrong == 2) System.out.print(torso);
                    if (numwrong == 3) System.out.print(leg1);
                    if (numwrong == 4) System.out.print(leg2);
                    if (numwrong == 5) System.out.print(arm1);
                    if (numwrong == 6) System.out.print(arm2);

                    System.out.println(stringdisplay(display));
                    System.out.println("            Previous guesses: " + guesses);
                    System.out.print("Nope! Guess another letter: ");

                }
                else{   //if they lost
                    System.out.println(noose);
                    System.out.println("\nYou lose! The word was " + secretword + ".");
                    gameover = true;
                }
            }   //this brace ends the if their guess was wrong statements
        }   //this brace closes the while !gameover loop
    }   //this brace closes main


    public static String stringdisplay(String[] display){
        String displaystring = "";
        for(int i=0; i<display.length; i++){
            displaystring = displaystring + display[i];
        }
        return displaystring;
    }
    public static boolean nonchar(String guess){
        if(guess.equals("0")) return true;
        if(guess.equals("1")) return true;
        if(guess.equals("2")) return true;
        if(guess.equals("3")) return true;
        if(guess.equals("4")) return true;
        if(guess.equals("5")) return true;
        if(guess.equals("6")) return true;
        if(guess.equals("7")) return true;
        if(guess.equals("8")) return true;
        if(guess.equals("9")) return true;
        if(guess.equals("!")) return true;
        if(guess.equals("@")) return true;
        if(guess.equals("#")) return true;
        if(guess.equals("$")) return true;
        if(guess.equals("%")) return true;
        if(guess.equals("^")) return true;
        if(guess.equals("&")) return true;
        if(guess.equals("*")) return true;
        if(guess.equals("(")) return true;
        if(guess.equals(")")) return true;
        if(guess.equals("_")) return true;
        if(guess.equals("+")) return true;
        if(guess.equals("=")) return true;
        if(guess.equals("{")) return true;
        if(guess.equals("}")) return true;
        if(guess.equals("/")) return true;
        if(guess.equals("?")) return true;
        if(guess.equals("|")) return true;
        if(guess.equals("~")) return true;
        if(guess.equals("`")) return true;
        if(guess.equals(".")) return true;
        if(guess.equals(",")) return true;
        if(guess.equals(":")) return true;
        if(guess.equals(";")) return true;

        else return false;
    }


    // class variables to draw the person being hung
    static String hangstand = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "    -----------\n";
    static String head = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "    -----------\n";
    static String torso = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |\n" +
            "        |\n" +
            "        |\n" +
            "    -----------\n";
    static String leg1 = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 /\n" +
            "        |                /\n" +
            "        |               /\n" +
            "    -----------\n";
    static String leg2 = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 / *\n" +
            "        |                /   *\n" +
            "        |               /     *\n" +
            "    -----------\n";
    static String arm1 = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |                  |\n" +
            "        |                 /|\n" +
            "        |                / |\n" +
            "        |               /  |\n" +
            "        |                 / *\n" +
            "        |                /   *\n" +
            "        |               /     *\n" +
            "    -----------";
    static String arm2 = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                 ____\n" +
            "        |               /     *\n" +
            "        |              |       |\n" +
            "        |               *      /\n" +
            "        |                 ---\n" +
            "        |                  |\n" +
            "        |                 /|*\n" +
            "        |                / | *\n" +
            "        |               /  |  *\n" +
            "        |                 / *\n" +
            "        |                /   *\n" +
            "        |               /     *\n" +
            "    -----------";
    static String noose = "        -------------------\n" +
            "        |                  |\n" +
            "        |               ___|\n" +
            "        |              /   ____\n" +
            "        |             / /     *\n" +
            "        |            | |       |\n" +
            "        |            *  *      /\n" +
            "        |              *  ---\n" +
            "        |                --|--\n" +
            "        |                 /|*\n" +
            "        |                / | *\n" +
            "        |               /  |  *\n" +
            "        |                 / *\n" +
            "        |                /   *\n" +
            "        |               /     *\n" +
            "    -----------";
    static String free = "        -------------------\n" +
            "        |                  |\n" +
            "        |                  |\n" +
            "        |                             ____\n" +
            "        |                           /     *\n" +
            "        |                          |       |\n" +
            "        |                          *      /\n" +
            "        |                             ---\n" +
            "        |                              |\n" +
            "        |                          *  /|*  /\n" +
            "        |                           */ | *\n" +
            "        |                              |   \n" +
            "        |                             / *\n" +
            "        |                            /   *\n" +
            "        |                           /     *\n" +
            "    -----------";
}