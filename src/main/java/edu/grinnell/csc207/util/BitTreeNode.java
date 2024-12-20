
package edu.grinnell.csc207.util;

/**
 * A class that represeng the node of the tree.
 *
 * @author Tiffany Tang
 */
public class BitTreeNode {
    /** Fields. */
    String val;
    BitTreeNode left;
    BitTreeNode right;

    /**
     * Construct a BitTreeNode setting fields to null at first.
     */
    public BitTreeNode() {
        this.val = "";
        this.right = null;
        this.left = null;
    } // BitTreeNode()

    /**
     * Return the right child.
     *
     * @return BitTreeNode
     */
    public BitTreeNode getRight() {
        return this.right;
    } // getRight()

    /**
     * Return the left child.
     *
     * @return BitTreeNode
     */
    public BitTreeNode getLeft() {
        return this.left;
    } // getLeft()
} // BitTreeNode
