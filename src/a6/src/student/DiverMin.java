package student;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import student.GraphAlgorithms;
import game.Edge;
import game.FindState;
import game.FleeState;
import game.GameState;
import game.NodeStatus;
import game.SewerDiver;
import game.Node;

import common.NotImplementedError;

public class DiverMin implements SewerDiver {

	/** Get to the ring in as few steps as possible. Once you get there, <br>
	 * you must return from this function in order to pick<br>
	 * it up. If you continue to move after finding the ring rather <br>
	 * than returning, it will not count.<br>
	 * If you return from this function while not standing on top of the ring, <br>
	 * it will count as a failure.
	 *
	 * There is no limit to how many steps you can take, but you will receive<br>
	 * a score bonus multiplier for finding the ring in fewer steps.
	 *
	 * At every step, you know only your current tile's ID and the ID of all<br>
	 * open neighbor tiles, as well as the distance to the ring at each of <br>
	 * these tiles (ignoring walls and obstacles).
	 *
	 * In order to get information about the current state, use functions<br>
	 * currentLocation(), neighbors(), and distanceToRing() in state.<br>
	 * You know you are standing on the ring when distanceToRing() is 0.
	 *
	 * Use function moveTo(long id) in state to move to a neighboring<br>
	 * tile by its ID. Doing this will change state to reflect your new position.
	 *
	 * A suggested first implementation that will always find the ring, but <br>
	 * likely won't receive a large bonus multiplier, is a depth-first walk. <br>
	 * Some modification is necessary to make the search better, in general. */
	@Override
	public void find(FindState state) {
		optimizedFind(state);
	}
	
	private void optimizedFind(FindState state) {
		HashMap<Long, Long> visited = new HashMap<Long, Long>();
		visited.put(state.currentLocation(), null);
			
		while(state.distanceToRing()!=0) {
			Comparator<Integer> cmp = Comparator.naturalOrder();
			Heap<NodeStatus, Integer> neighbor_dist = new Heap<NodeStatus, Integer>(cmp); 
			
			for(NodeStatus ns: state.neighbors()) {
				if(!visited.containsKey(ns.getId())) {
					neighbor_dist.add(ns, -ns.getDistanceToTarget());
				}
			}
			try {
				Long temp = state.currentLocation();
				state.moveTo(neighbor_dist.poll().getId());
				visited.put(state.currentLocation(), temp);
			}
			catch(NoSuchElementException e) {
				state.moveTo(visited.get(state.currentLocation()));
			}
		}
		return;
	}
	
	/** Flee the sewer system before the steps are all used, trying to <br>
	 * collect as many coins as possible along the way. Your solution must ALWAYS <br>
	 * get out before the steps are all used, and this should be prioritized above<br>
	 * collecting coins.
	 *
	 * You now have access to the entire underlying graph, which can be accessed<br>
	 * through FleeState. currentNode() and getExit() will return Node objects<br>
	 * of interest, and getNodes() will return a collection of all nodes on the graph.
	 *
	 * You have to get out of the sewer system in the number of steps given by<br>
	 * getStepsRemaining(); for each move along an edge, this number is <br>
	 * decremented by the weight of the edge taken.
	 *
	 * Use moveTo(n) to move to a node n that is adjacent to the current node.<br>
	 * When n is moved-to, coins on node n are automatically picked up.
	 *
	 * You must return from this function while standing at the exit. Failing <br>
	 * to do so before steps run out or returning from the wrong node will be<br>
	 * considered a failed run.
	 *
	 * Initially, there are enough steps to get from the starting point to the<br>
	 * exit using the shortest path, although this will not collect many coins.<br>
	 * For this reason, a good starting solution is to use the shortest path to<br>
	 * the exit. */
	@Override
	public void flee(FleeState state) {
		greedyFlee(state);
	}
	public void greedyFlee(FleeState state) {
		while(state.currentNode()!=state.getExit()) {
			Comparator<Integer> cmp = Comparator.naturalOrder();
			Heap<Node, Integer> coinHeap = new Heap<Node, Integer>(cmp);
			
			for(Edge e: state.currentNode().getExits()) {
				Node neighbor = e.getOther(state.currentNode());
				
				if(e.length+pathWeight(GraphAlgorithms.shortestPath(neighbor, state.getExit()))
						<= state.stepsLeft()){
							coinHeap.add(neighbor, -neighbor.getTile().coins());
						}
				Node next = coinHeap.poll();
				if(state.currentNode().getTile().coins()>0) state.moveTo(next);
				else {
					Node flee = feasibleFlee(state);
					if(flee == null) {
						fleeShortestPath(state, state.getExit());
					}
					else {
						fleeShortestPath(state, flee);
					}
				}			
			}
		}	
	}	
	
	public void fleeShortestPath(FleeState state, Node last) {
		List<Node> path = null;
		path = GraphAlgorithms.shortestPath(state.currentNode(), last);
		
		path.remove(0);
		for(Node n:path) {
			state.moveTo(n);
		}
	}
	public Node feasibleFlee(FleeState state) {
		Collection<Node> nodes = state.allNodes();
		Comparator<Double> cmp = Comparator.naturalOrder();
		Heap<Node, Double> coinHeap = new Heap<Node, Double>(cmp);
		HashMap<Node,Double> nodeData = new HashMap<Node, Double>(); 
		
		for (Node n: nodes){
			if(n.getTile().coins()>0) {
				double dist = pathWeight(GraphAlgorithms.shortestPath(state.currentNode(), n));
				nodeData.put(n, dist);
				coinHeap.add(n, dist/n.getTile().coins());
			}
		}
		
		double currentToExit=0;
		int startToExit = Integer.MAX_VALUE;
		Node maxCoin = null;
		boolean isFeasible =false;
		while(!isFeasible) {
			if(coinHeap.size() == 0) return null;
			maxCoin = coinHeap.poll();
			if(maxCoin == state.currentNode()) maxCoin = coinHeap.poll();
			currentToExit = nodeData.get(maxCoin);
			startToExit = pathWeight(GraphAlgorithms.shortestPath(maxCoin, state.getExit()));
			isFeasible = (currentToExit + startToExit)<=state.stepsLeft();
		}
		return maxCoin;
	}
	
	public static int pathWeight(List<Node> path) {
		if(path.size()==0) return 0;
		synchronized(path) {
			Iterator<Node> iter = path.iterator();
			Node p = iter.next();
			int s = 0;
			while(iter.hasNext()) {
				Node q = iter.next();
				s = s+p.getEdge(q).length;
				p = q;
			}
			return s;
		}
	}

}
