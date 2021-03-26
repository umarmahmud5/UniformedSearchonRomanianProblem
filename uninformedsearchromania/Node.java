package uninformedsearchromania;
//based on the Romania problem in AIMA, a node can have atmost 4 connections
//Assuming 8-ary trees
/**
 *
 * @author Umar Mahmud
 * XVI-III-MMXXI
 */
public class Node {

    String name;
    Node north;
    Node south;
    Node east;
    Node west;
    Node northWest;
    Node northEast;
    Node southWest;
    Node southEast;

    public Node(String val) {
        this.name = val; 
    }
}