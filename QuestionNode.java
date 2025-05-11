/** 
* Each QuestionNode class resembles one node.
*
* @author Anita Tan
* @version 06/9/2022
*/

public class QuestionNode {
   /** Pointer to the Yes node */
   public QuestionNode yes;
   /** Pointer to the No node */
   public QuestionNode no;
   /** node data */
   private String data;
   
   /**
   * Constructor that initializes an answer node.
   *
   * @param data Answer issues to user
   */
   public QuestionNode(String data){
      this(null, null, data);
   }
   
   /**
   * Constructor, initializes a Question Node
   *
   * @param yes Yes Node answer
   * @param no No Node answer
   * @param data Question 
   */
   public QuestionNode(QuestionNode yes, QuestionNode no, String data){
      this.data = data;
      this.yes = yes;
      this.no = no;
   }
   
   /**
   * String representation of the data of the node. Will be a question or answer.
   *
   * @return node data 
   */
   public String toString(){
      return data;
   }
   
   /**
   * Finds out if node has children.
   *
   * @return true if the node doesn't have any children, otherwise, returns false.
   */
   public boolean isAnswer(){
      if (yes == null && no == null) return true;
      else return false;
   }
   
}

