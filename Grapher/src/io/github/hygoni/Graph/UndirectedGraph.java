package io.github.hygoni.Graph;

public class UndirectedGraph<T> extends DirectedGraph<T> {
	public void addEdge(T from, T to, int weight) {
		super.addEdge(from, to, weight);
		super.addEdge(to, from, weight);
	}
}
