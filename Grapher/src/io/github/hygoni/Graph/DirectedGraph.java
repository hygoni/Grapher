package io.github.hygoni.Graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DirectedGraph<T> {
	private Map<T, Map<T, Integer>> graph;
	private Map<T, T> prev;
	public DirectedGraph() {
		this.graph = new HashMap<>();
	}
	
	public void addVertex(T v) {
		graph.put(v, new HashMap<>());
	}
	
	public void addEdge(T from, T to, int weight) {
		graph.get(from).put(to, weight);
	}
	
	public void addFlow(T from, T to, int amount) {
		int flow = graph.get(from).get(to);
		graph.get(from).put(to, flow + amount);
	}
	
	public int getWeight(T u, T v) {
		return graph.get(u).get(v);
	}
	
	public Iterator<T> getVertexIterator(T v){
		return graph.keySet().iterator();
	}
	
	public Iterator<T> getNeighborsIterator(T v){
		return graph.get(v).keySet().iterator();
	}
	
	/* Network Flow */
	public boolean bfs(T src, T dst) {
		Map<T, Boolean> visited = new HashMap<>();
		Queue<T> q = new LinkedList<T>();
		q.add(src);
		
		while(!q.isEmpty()) {
			T u = q.poll();
			Iterator<T> iter = this.getNeighborsIterator(u);
			while(iter.hasNext()) {
				T v = iter.next();
				if(!visited.getOrDefault(v, false) && this.getWeight(u, v) > 0) {
					visited.put(v, true);
					prev.put(v, u);
					q.add(v);
				}
			}
		}
		
		return visited.getOrDefault(dst, false);
	}
	
	/**
	 * Ford-Fulkerson method is used to get max flow
	 * */
	public int getMaxFlow(T src, T dst) {
		this.prev = new HashMap<>();
		int maxFlow = 0;
		
		while(bfs(src, dst)) {
			int pathFlow = Integer.MAX_VALUE;
			
			for(T v = dst; !v.equals(src); v = prev.get(v)) {
				T u = prev.get(v);
				pathFlow = Math.min(pathFlow, this.getWeight(u, v));
			}
			
			for(T v = dst; !v.equals(src); v = prev.get(v)) {
				T u = prev.get(v);
				this.addFlow(u, v, -pathFlow);
				this.addFlow(v, u, +pathFlow);
			}
			
			maxFlow += pathFlow;
		}
		
		return maxFlow;
	}
}
