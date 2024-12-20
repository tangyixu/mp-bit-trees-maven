package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Tiffany Tang
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  String value;
  int num;
  BitTreeNode root;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * builds a tree that will store mappings from strings
   * of n bits to strings.
   */
  public BitTree(int n) {
    this.num = n;
    this.value = "";
    this.root = new BitTreeNode();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Help to dump tree values.
   *
   * @param pen  the one to output result
   * @param node the node to start with recursively
   */
  public void preDump(PrintWriter pen, BitTreeNode node) {
    pen.print(node.val);
    preDump(pen, this.root.getLeft());
    preDump(pen, this.root.getRight());
    pen.flush();
  } // preDump(PrintWriter, BigTreeNode)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set the value leading by different bits to be another value.
   *
   * @param bits
   * @param value
   * @throws IndexOutOfBoundsException if bits is invalid length.
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException {
    if (bits == null || bits.length() != this.num) {
      throw new IndexOutOfBoundsException();
    } // if
    for (int n = 0; n < bits.length() - 1; n++) {
      if (!bits.substring(n, n + 1).equals("0")
          && !bits.substring(n, n + 1).equals("1")) {
        throw new IndexOutOfBoundsException();
      } // if
    } // for

    int n = 0;
    String valString = bits.substring(n, n + 1);
    while (n < bits.length()) {
      if (valString.equals("0")) {
        this.root = this.root.getLeft();
      } else {
        this.root = this.root.getRight();
      } // if-else
      n++;
    } // while
    this.root.val = value;
  } // set(String, String)

  /**
   * Follows the path through the tree given by bits,
   * returning the value at the end.
   *
   * @param bits the path to be followed.
   * @return a string representing the value at the end.
   */
  public String get(String bits) {
    int n = 0;
    String result = "";
    String valString = bits.substring(n, n + 1);
    while (n < bits.length()) {
      if (valString.equals("0")) {
        this.root = this.root.getLeft();
        result += this.root.val;
      } else {
        this.root = this.root.getRight();
        result += this.root.val;
      } // if-else
      n++;
    } // while
    return result;
  } // get(String, String)

  /**
   * Prints out the contents of the tree in CSV format.
   *
   * @param pen the pen to output results
   */
  public void dump(PrintWriter pen) {
    if (this.num == 0) {
      pen.println("");
    } else {
      preDump(pen, root);
    } // if-else
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTree
