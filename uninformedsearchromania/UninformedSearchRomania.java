package uninformedsearchromania;

/**
 *
 * @author Umar Mahmud XVI-III-MMXXI
 */
public class UninformedSearchRomania {

    private final Node Arad;              //start node
    private final Node Zerind;
    private final Node Oradea;
    private final Node Timisoara;
    private final Node Lugoj;
    private final Node Mehadia;
    private final Node Dobreta;
    private final Node Craiova;
    private final Node RimnicuVilcea;
    private final Node Pitesti;
    private final Node Sibiu;
    private final Node Fagaras;
    private final Node Bucharest;         //destination node

    public UninformedSearchRomania() {
        Arad = new Node("Arad");
        Zerind = new Node("Zerind");
        Oradea = new Node("Oradea");
        Timisoara = new Node("Timisoara");
        Lugoj = new Node("Lugoj");
        Mehadia = new Node("Mehadia");
        Dobreta = new Node("Dobreta");
        Craiova = new Node("Craiova");
        RimnicuVilcea = new Node("Rimni Vilcea");
        Pitesti = new Node("Pitesti");
        Sibiu = new Node("Sibiu");
        Fagaras = new Node("Fagaras");
        Bucharest = new Node("Bucharest");
        cosntructGraph();
        System.out.println(" Find DFS paths and try 10 times: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Path No: "+(i+1)+" is: ");
            dFS(Arad, Bucharest);
            System.out.println();
        }
    }

    private void dFS(Node st, Node dest) {
        //this function returns one path, this path may have the destination
        Node currentNode = st;
        int randomInt;
        while ((currentNode != null)) {
            if (!currentNode.name.equals(dest.name)) {
                System.out.print(currentNode.name + "\t");
                randomInt = getRandomInteger(0, 7);
                //System.out.println("Random no is: " + randomInt);
                switch (randomInt) {
                    case 0:
                        currentNode = currentNode.north;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 1:
                        currentNode = currentNode.northEast;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 2:
                        currentNode = currentNode.east;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 3:
                        currentNode = currentNode.southEast;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 4:
                        currentNode = currentNode.south;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 5:
                        currentNode = currentNode.southWest;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 6:
                        currentNode = currentNode.west;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    case 7:
                        currentNode = currentNode.northWest;
                        //System.out.println("Next Node is :" + currentNode.name);
                        break;
                    default:
                        System.err.println("Error in Random no");
                        break;
                }
            } else {
                currentNode = null;
                System.out.print(dest.name + "\t");
            }
        }
    }

    public int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    private void cosntructGraph() {
        Arad.north = Zerind;
        Arad.east = Sibiu;
        Arad.south = Timisoara;
        Timisoara.north = Arad;
        Timisoara.southEast = Lugoj;
        Lugoj.northWest = Timisoara;
        Lugoj.south = Mehadia;
        Mehadia.north = Lugoj;
        Mehadia.south = Dobreta;
        Dobreta.north = Mehadia;
        Dobreta.east = Craiova;
        Craiova.west = Dobreta;
        Craiova.north = RimnicuVilcea;
        Craiova.northWest = Pitesti;
        RimnicuVilcea.south = Craiova;
        RimnicuVilcea.southEast = Pitesti;
        RimnicuVilcea.northWest = Sibiu;
        Sibiu.southEast = RimnicuVilcea;
        Sibiu.west = Arad;
        Sibiu.east = Fagaras;
        Sibiu.northWest = Oradea;
        Oradea.southEast = Sibiu;
        Oradea.southWest = Zerind;
        Zerind.northEast = Oradea;
        Zerind.south = Arad;
        Fagaras.south = Bucharest;
        Fagaras.west = Sibiu;
        Pitesti.northWest = RimnicuVilcea;
        Pitesti.southWest = Craiova;
        Pitesti.southEast = Bucharest;
        Bucharest.northWest = Pitesti;
        Bucharest.north = Fagaras;
    }

    public static void main(String[] args) {
        UninformedSearchRomania uSR = new UninformedSearchRomania();
    }

}
