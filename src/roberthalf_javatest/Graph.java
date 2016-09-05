/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roberthalf_javatest;

import java.util.HashMap; 
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author Abhijith
 */
public class Graph {
    private final Map<String, Vertex> graph; 
    
    //to all the train stations and travel time across an edge.
    //An edge will have two vertices(source, destination) and a length (time)
    public static class Edge {
      public final String v1, v2;
      public final int time;
      public Edge(String v1, String v2, int time) {
         this.v1 = v1;
         this.v2 = v2;
         this.time = time;
      }
    }
    
   public static class Vertex implements Comparable<Vertex> {
      public final String name;
      //to setup initial value for all vertices except starting vertex to infinity
      public int time = Integer.MAX_VALUE; 
      public Vertex previous = null;
      
      //hashmap - no guarentee order
      public final Map<Vertex, Integer> neighbours = new HashMap<>();
 
      public Vertex(String name) {
         this.name = name;
      }
 
      private void printPath() {
         if (this == this.previous) {
            System.out.printf("%s", this.name);
         } else if (this.previous == null) {
            System.out.printf("%s(unreached)", this.name);
         } else {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.name, this.time);
         }
      }
 
      @Override
      public int compareTo(Vertex other) {
         return Integer.compare(time, other.time); 
      }
   }
 
   /** Builds a graph from a set of edges
     * @param edges */
   public Graph(Edge[] edges) {
      graph = new HashMap<>(edges.length);
 
      for (Edge e : edges) {
         if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
         if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
      }
 
      for (Edge e : edges) {
         graph.get(e.v1).neighbours.put(graph.get(e.v2), e.time);
      }
   }
 
   /** Runs TrainRoute using a specified source point
     * @param startName */ 
   public void TrainRoute(String startName) {
      if (!graph.containsKey(startName)) {
         System.err.printf("Graph doesn't contain source point \"%s\"\n", startName);
         return;
      }
      final Vertex source = graph.get(startName);
      NavigableSet<Vertex> q = new TreeSet<>(); //treeset- orders elements according to comparator or comparable
 
      // set-up vertices
      for (Vertex v : graph.values()) {
         v.previous = v == source ? source : null;
         v.time = v == source ? 0 : Integer.MAX_VALUE;
         q.add(v);
      }
 
      TrainRoute(q);
   }

   private void TrainRoute(final NavigableSet<Vertex> q) {      
      Vertex u, v;
      while (!q.isEmpty()) {
 
         u = q.pollFirst();
         if (u.time == Integer.MAX_VALUE) break;
 
         
         for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
            v = a.getKey(); 
 
            final int alternatetime = u.time + a.getValue();
            if (alternatetime < v.time) {
               q.remove(v);
               v.time = alternatetime;
               v.previous = u;
               q.add(v);
            } 
         }
      }
   }
 
   /** Prints a path from the source to the specified destination point
     * @param endName */
   public void printPath(String endName) {
      if (!graph.containsKey(endName)) {
         System.err.printf("Graph doesn't contain destination point \"%s\"\n", endName);
         return;
      }
      graph.get(endName).printPath();
      System.out.println();
   }
}
