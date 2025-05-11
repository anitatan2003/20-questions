import java.io.*;
import java.util.*;
/** 
* A QuestionTree class manages the game of twenty questions.
*
* @author Anita Tan
* @version 06/09/2022
*/ 

public class QuestionTree {
   /** Question Node */
   private QuestionNode root;
   /** User Interface */
   private UserInterface my;
   /** number of games total */
   private int games;
   /** total games won */
   private int wins;
   
   /**
   * Constructor that initializes the QuestionNode
   * and assigns the given User Interface
   * @param ui Given User Interface
   */
   public QuestionTree(UserInterface ui) { 
      root = new QuestionNode("computer");
      my = ui;
   }
   
   /**
   * This method gets and returns the total number of games that have been played.
   *
   * @return number of times the game has been played
   */
   public int totalGames(){
      return games;
   }
   
   /**
   * This method gets and returns the total number of games won by the computer.
   *
   * @return number of games the machine has won
   */
   public int gamesWon(){
      return wins;
   }
   
   /**
   * Orchestrates a game. 
   * Rebuilds the tree based off of right or wrong answers.
   */
   public void play() {
      root = played(root);
      games++;
   }
   
   private QuestionNode played(QuestionNode r){
      if (r.isAnswer()) { // Answer node
         my.print("Would your object happen to be " + r + "?");
         
         if (my.nextBoolean()) { // answer is correct
            wins++;
            my.println("I win!");
         } else { // add a new ans node
            r = learned(r);
         }
      
      } else { // Question node
         my.print(r.toString());
         
         // gets the node that the user wants
         if (my.nextBoolean()) {
            r.yes = played(r.yes);
         } else {
            r.no = played(r.no);
         }
   }
      return r;
   }
   
   private QuestionNode learned(QuestionNode n){
      my.print("I lose. What is your object? ");
      QuestionNode newNode = new QuestionNode (my.nextLine());
      my.print("Type a yes/no question to distinguish " + "your item from " + n + ":");
      
      // Get user question
      String query = my.nextLine();
      my.print("And what is the answer for your object?");
      
      // create new Question Node usinng user input
      return my.nextBoolean() ?
      new QuestionNode ( newNode, n, query ):
      new QuestionNode ( n, newNode, query );
   }
   
   /**
   * Stores current tree state to an output file represented
   * by given PrintStream.
   *
   * @param output Output object to Stream data
   */
   public void save (PrintStream output){
      save(output, root);
   }
      
   private void save(PrintStream outp, QuestionNode node){
      if (node.isAnswer()){
         outp.print("A:" + node);
      } else {
         outp.println("Q:" + node);
         save(outp, node.yes);
         outp.println();
         save(outp, node.no);
      }
   }
   
   /**
   * Replaces current tree with 
   * another tree from a file.
   * 
   * @param input Scans file for data
   */
   public void load (Scanner input){
      root = loadedNode (input);
   }
   
   private QuestionNode loadedNode (Scanner in){
      QuestionNode node = null; 
      
      if (in.hasNext()){
         String[] data = in.nextLine().split(":",2); 
      
         if (data[0].equals("A")){ // Create Answer node
            node = new QuestionNode(data[1]);
            
         } else { // create Question node
            node = new QuestionNode ( loadedNode(in), loadedNode(in), data[1]);
         }
      }
      return node;
   }

 }
   
