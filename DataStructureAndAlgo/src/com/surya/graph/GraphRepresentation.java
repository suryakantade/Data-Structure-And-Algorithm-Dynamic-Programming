package com.surya.graph;

import java.util.LinkedList;

class Graph<E>{
	Integer noOfVertex ;
	LinkedList<E> [] adjacencyList;// = new LinkedList[noOfVertex];
	public Graph(int noOfVertex) {
		super();
		this.noOfVertex = noOfVertex;
		this.adjacencyList = new LinkedList[noOfVertex];
		for(int i = 0;i<this.noOfVertex;i++){
			this.adjacencyList[i] = new LinkedList<>();
		}
	}
	@SuppressWarnings("unchecked")
	public void addEdge(Integer vertexNo, Object dest){
		this.adjacencyList[vertexNo].add((E) dest);
		//this is a bi directional graph
		this.adjacencyList[(int)((E) dest)].add((E)vertexNo);
	}
	public void printGraph(){
		for(int i = 0 ;i<this.noOfVertex;i++){
			System.out.println("\n"+i + "- >");
			for(int j=0;j<this.adjacencyList[i].size();j++){
				System.out.print(this.adjacencyList[i].get(j) +"  ");
			}
		}
	}
}

public class GraphRepresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
	}

}
