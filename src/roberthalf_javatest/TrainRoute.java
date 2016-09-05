/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberthalf_javatest;

import java.util.Scanner;

/**
 *
 * @author Abhijith
 */
public class TrainRoute {

    //entering all the train stations and travel times
    //entered in the format of (source,destination,time)
    private static final Graph.Edge[] GRAPH = {
      new Graph.Edge("a", "b", 3), 
      new Graph.Edge("b", "a", 3),
      new Graph.Edge("a", "d", 6),
      new Graph.Edge("b", "c", 7),
      new Graph.Edge("c", "d", 8),
      new Graph.Edge("d", "e", 9),
      new Graph.Edge("e", "d", 9),
      new Graph.Edge("d", "c", 9),
      new Graph.Edge("d", "b", 5),
      new Graph.Edge("c", "e", 3),
   };
 
   public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter the Source Point");
      String START = reader.next();
      System.out.println("Enter the Destination point");
      String END = reader.next();
       
      Graph g = new Graph(GRAPH);
      g.TrainRoute(START);
      g.printPath(END);
   }
    
}
