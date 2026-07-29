/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa_6;
import java.util.Scanner;
/**
 *
 * @author renuj
 */

    
  

class Node {

    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {

    Node root;

    public Node insert(Node root, int key) {

        if (root == null)
            return new Node(key);

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    public boolean search(Node root, int key) {

        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    public void inorder(Node root) {

        if (root != null) {

            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BinarySearchTree tree = new BinarySearchTree();

        System.out.print("How many nodes? ");
        int n = sc.nextInt();

        System.out.println("Enter values:");

        for (int i = 0; i < n; i++)
            tree.root = tree.insert(tree.root, sc.nextInt());

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.print("\n\nSearch value: ");
        int value = sc.nextInt();

        if (tree.search(tree.root, value))
            System.out.println("Value Found.");
        else
            System.out.println("Value Not Found.");

        sc.close();
    }
}
    

