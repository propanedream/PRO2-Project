package opgave2;

import java.util.Scanner;

/**
 * This program demonstrates a decision tree for an animal guessing game.
 */
public class DecisionTreeDemo {
    public static void main(String[] args) {

        BinaryTree<String> eightyeight = new BinaryTree<>("88");
        BinaryTree<String> ninety = new BinaryTree<>("90", eightyeight, null);

        BinaryTree<String> fifteen = new BinaryTree<>("15");
        BinaryTree<String> twentyfive = new BinaryTree<>("25");

        BinaryTree<String> thirty = new BinaryTree<>("30", twentyfive, null);
        BinaryTree<String> eleven = new BinaryTree<>("11", fifteen, null);


        BinaryTree<String> seventyseven = new BinaryTree<>("77", ninety, null);
        BinaryTree<String> twentytwo = new BinaryTree<>("22", thirty, eleven);
        BinaryTree<String> questionTree = new BinaryTree<>("45", seventyseven, twentytwo);

        System.out.println(questionTree.size());
        // questionTree.inorder();
        boolean done = false;
        Scanner in = new Scanner(System.in);
        while (!done) {
            BinaryTree<String> left = questionTree.left();
            BinaryTree<String> right = questionTree.right();
            if (left.isEmpty() && right.isEmpty()) {
                System.out.println(questionTree.data());
                done = true;
            } else {
                String response;
                do {
                    System.out.print(questionTree.data() + " (Y/N) ");
                    response = in.next().toUpperCase();
                } while (!response.equals("Y") && !response.equals("N"));

                if (response.equals("Y")) {
                    questionTree = left;
                } else {
                    questionTree = right;
                }
            }
        }
        in.close();
    }
}
