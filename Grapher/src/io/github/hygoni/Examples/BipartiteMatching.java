package io.github.hygoni.Examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import io.github.hygoni.Graph.DirectedGraph;

public class BipartiteMatching {
	public static int worker(int n) {
		return n;
	}
	
	public static int work(int n) {
		return n + 1000;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int src = 2000+2;
		int sink = 2000+1;
		DirectedGraph<Integer> graph = new DirectedGraph<>(); 
		
		graph.addVertex(src);
		graph.addVertex(sink);
		for(int i = 1; i <= N; i++) {
			graph.addVertex(worker(i));
			//src - worker connection
			graph.addEdge(src, worker(i), 1);
			graph.addEdge(worker(i), src, 0);
			
		}
		
		for(int i = 1; i <= M; i++) {
			graph.addVertex(work(i));
			//work - sink connection
			graph.addEdge(work(i), sink, 1);
			graph.addEdge(sink, work(i), 0);
		}
		
		//worker - work connection
		for(int worker = 1; worker <= N; worker++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j = 0; j < count; j++) {
				int work = Integer.parseInt(st.nextToken());
				graph.addEdge(worker(worker), work(work), 1);
				graph.addEdge(work(work), worker(worker), 0);
			}
		}
		
		System.out.println(graph.getMaxFlow(src, sink));
		br.close();
	}
}
