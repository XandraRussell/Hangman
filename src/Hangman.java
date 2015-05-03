////////////////////////////////////////////////////
// Hangman by Xandra Russell
// Start: 1 May 2015
// Last Modified: 1 May 2015
// Eventually, I want to have a dictionary (or multiple dictionaries) that users can modify
// and the option for 2 players, where they take turn chosing and guessing
//
// To start, I will have the user enter the word the make guesses
// Each incorect guess will add a body part to the man
// The last incorrect guess will add a noose and say you lose/failed to stop the hangman and will show
// the previous picture but with a noose around his neck attached to the pole
// then it will show the correct word and define it
////////////////////////////////////////////////////

//Steps:
// ask for word
// print hangstand and the number of underscores equal to the length of the word
// ask to guess letter
// if correct, fill in letter as many times as it occurs &show pic, ask for another letter
// if incorrect, say sorry, add body part, ask for another letter

import java.util.*;

public class Hangman {

    public static void main(String[] arg){
        String hangstand = "        -------------------\n" +
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
        String head = "        -------------------\n" +
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
        String torso = "        -------------------\n" +
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
        String leg1 = "        -------------------\n" +
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
        String leg2 = "        -------------------\n" +
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
        String arm1 = "        -------------------\n" +
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
        String arm2 = "        -------------------\n" +
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
        String noose = "        -------------------\n" +
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
        String free = "        -------------------\n" +
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


        //System.out.println(hangstand + head + torso + leg1 + leg2 + arm1 + arm2 + noose);   //test line

        //Declaring stuff
        String secretword;
        Scanner scan = new Scanner(System.in);

        //Scanning in secret word
        System.out.print("Enter a word for the other player to guess: ");
        secretword = scan.next();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");     //scrolls secret word input off screan

        //declare the variables we'll need to fill the String array secret
        int length = secretword.length();
        String[] secret = new String[length];
        String temp;
        //fill the string array secret with the chars from secretword
        for(int i=0; i<length; i++){
            temp = String.valueOf(secretword.charAt(i));
            secret[i] = temp;
        }

        //System.out.println("Secretword is: " + secretword);     //this is a test line

        //creating the display of underscores and filled in letters
        String[] display = new String[length];
        for(int i=0; i<length; i++){
            display[i] = " _";
        }

        //display game start
        System.out.println(hangstand);
        System.out.print("          ");
        for(int i=0; i<length;i++){
            System.out.print(display[i]);
        }
        System.out.println("\n");

        //start guessing
        String guess;
        String guesses ="";
        int numwrong=0;

        System.out.print("Guess a letter: ");
        while(numwrong<8 && !secretword.equals(stringdisplay(display))) {
            guess = scan.next();
            guesses = guesses  + " " + guess;
            while (guess.length() != 1) {
                System.out.print("Guess only one letter: ");
                guess = scan.next();
                guesses = guesses + " " + guess;
            }
            if (secretword.contains(guess)) {
                for (int i = 0; i < length; i++) {
                    if (secret[i].equals(guess)) {
                        display[i] = guess;     //why doesn't this line work?
                    }
                }
                for (int j = 0; j < length; j++) {
                    System.out.print(display[j]);
                }
                System.out.print("\n");
                if(!secretword.equals(stringdisplay(display))) {
                    System.out.print("You guessed it! Guess another letter: ");
                }
            } else {
                numwrong++;
                if(numwrong<7) {
                    if (numwrong == 1) System.out.print(head);
                    if (numwrong == 2) System.out.print(torso);
                    if (numwrong == 3) System.out.print(leg1);
                    if (numwrong == 4) System.out.print(leg2);
                    if (numwrong == 5) System.out.print(arm1);
                    if (numwrong == 6) System.out.print(arm2);

                    for (int j = 0; j < length; j++) {
                        System.out.print(display[j]);
                    }
                    System.out.print("\n");
                    System.out.println("            Previous guesses: " + guesses);
                    System.out.print("Nope! Guess another letter: ");
                }
                else{
                    System.out.print(noose);
                    System.out.println("\nSorry, you lose.");
                }
            }
        }

        if(secretword.equals(stringdisplay(display))){
            System.out.println("You win!");
            System.out.println(free);
        }


    }

    public static String stringdisplay(String[] display){
        String displaystring = "";
        for(int i=0; i<display.length; i++){
            displaystring = displaystring + display[i];
        }
        return displaystring;
    }



}
