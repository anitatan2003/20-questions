# 20-questions
Yes/no guessing game called "20 Questions." Each round of the game begins by
you (the human player) thinking of an object. The computer will try to guess your object by asking you a series of yes or
no questions. Eventually the computer will have asked enough questions that it thinks it knows what object you are
thinking of. It will make a guess about what your object is. If this guess is correct, the computer wins; if not, you win.
The computer keeps track of a binary tree whose nodes represent questions and answers. (Every node's data is a string
representing the text of the question or answer.) A "question" node contains a left "yes" subtree and a right "no" subtree.
An "answer" node is a leaf. The idea is that this tree can be traversed to ask the human player a series of questions.
(Through the game is called “20 Questions,” out game will not limit the tree to a height of 20. Any height is allowed.)
For example, in the tree below, the computer would begin the game by asking the player, "Is it an animal?" If the player
says "yes," the computer goes left to the "yes" subtree and then asks the user, "Can it fly?" If the user had instead said
"no," the computer would go right to the "no" subtree and then ask the user, "Does it have wheels?"
This pattern continues until the game reaches a leaf "answer" node. Upon reaching an answer node, the computer asks
whether that answer is the correct answer. If so, the computer wins.

<img width="848" alt="Screenshot 2025-05-10 at 10 48 47 PM" src="https://github.com/user-attachments/assets/fb1affc7-162a-4d44-b779-f860778fbf8e" />

Initially the computer is not very intelligent, but it grows more intelligent each time it loses a game. If the computer's
answer guess is incorrect, you must give it a new question it can ask to help it in future games. For example, suppose in
the preceding log that the player was not thinking of a mouse, but of a cat. The game log might look like this:
<img width="752" alt="Screenshot 2025-05-10 at 10 49 36 PM" src="https://github.com/user-attachments/assets/ab6ac656-ce60-4ec8-93ac-02fe5eec6bbd" />

The computer takes the new information from a lost game and uses it to replace the old incorrect answer node with a new
question node that has the old incorrect answer and new correct answer as its children. For example, after the game
represented by the preceding log, the computer's overall game tree would be the following:
<img width="601" alt="Screenshot 2025-05-10 at 10 55 22 PM" src="https://github.com/user-attachments/assets/7dc82d5f-7a4c-41f3-a2ae-ff95dc07525e" />

Example execution: 
<break/>
<img width="300" alt="Screenshot 2025-05-10 at 10 55 51 PM" src="https://github.com/user-attachments/assets/487f0f84-1fb5-4ade-ab21-69a192f25326" />



