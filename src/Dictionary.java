////////////////////////////////////////////////////
// Dictionary for Hangman by Xandra Russell
// Start: 5 May 2015
// Last Modified: 15 May 2015
//
// Not complete
//
// Next steps:
//      -export and save dictionary as text file at end of program
//      -scan entire line for definition (not just next word)
//      -make it possible to modify existing dictionaries?
//
////////////////////////////////////////////////////

import java.util.*;

public class Dictionary {

    int size = 0;

    class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    Node H = null;  //head node



    public void add(String key, String value){
        if(size==0){
            H = new Node(key, value);
            H.next = null;
        }

        if(size>0){
            Node A = H;
            while(A.next!=null){
                A=A.next;
            }
            Node B = new Node(key, value);
            A.next = B;
        }
        size++;
    }




    public void remove(String key){
        boolean removed = false;
        if(H.key.equals(key)){
            if(size==1){
                H = null;
            }
            else{
                H = H.next;
            }
            size--;
            removed = true;
        }

        else{
            Node A = H;
            Node B = A.next;
            while(B!=null){
                if(B.key.equals(key)){
                    A.next = B.next;
                    size--;
                }
                A=A.next;
                B=B.next;
                removed = true;
            }

        }

        if(!removed){
            System.out.println("Inputed word was not in the dictionary, so it could not be removed");
        }
    }


    public String printdict(){
        Node T = H;
        String printline = "";
        while(T!=null){
            printline = printline + T.key + ": " + T.value + "\n";
            T = T.next;
        }
        return printline;
    }


    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        System.out.print("Would you like to make a new dictionary? ");
        String makenew = scan.next();
        if(makenew.equals("y") || makenew.equals("yes"))  {
            Dictionary dictionary = new Dictionary();

            System.out.println("To leave dictionary editing, type xxx when asked to add or remove.");

            while (!quit) {
                System.out.print("Would you like to add or removed words? (xxx to finish): ");
                String whatdo = scan.next();
                if (whatdo.equals("add")) {
                    System.out.print("Type the word you would like to add: ");
                    String key = scan.next();
                    scan.nextLine();
                    System.out.print("Type the definition: ");
                    String value = scan.nextLine();
                    dictionary.add(key, value);
                }
                if (whatdo.equals("remove") || (whatdo.equals("delete"))) {
                    System.out.print("Type the word you would like to remove: ");
                    String key = scan.next();
                    dictionary.remove(key);
                }
                if (whatdo.equals("print")) {
                    System.out.println(dictionary.printdict());
                }
                if (whatdo.equals("xxx")) {
                    quit = true;
                }
            }

            System.out.println(dictionary.printdict());
        }

    }


}
