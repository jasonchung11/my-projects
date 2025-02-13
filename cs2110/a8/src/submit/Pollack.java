package submit;

import java.util.HashSet;
import java.util.List;

import graph.FindState;
import graph.Finder;
import graph.FleeState;
import graph.Node;
import graph.NodeStatus;

/** A solution with find-the-Orb optimized and flee getting out as fast as possible. */
public class Pollack extends Finder {

    private long startTime= 0; // start time in milliseconds

    /** Return the time from start time till when this method is called, in milliseconds */
    public long elapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    /** Get to the orb in as few steps as possible. <br>
     * Once you get there, you must return from the function in order to pick it up. <br>
     * If you continue to move after finding the orb rather than returning, it will not count.<br>
     * If you return from this function while not standing on top of the orb, it will count as <br>
     * a failure.
     *
     * There is no limit to how many steps you can take, but you will receive<br>
     * a score bonus multiplier for finding the orb in fewer steps.
     *
     * At every step, you know only your current tile's ID and the ID of all<br>
     * open neighbor tiles, as well as the distance to the orb at each of <br>
     * these tiles (ignoring walls and obstacles).
     *
     * In order to get information about the current state, use functions<br>
     * currentLoc(), neighbors(), and distanceToOrb() in FindState.<br>
     * You know you are standing on the orb when distanceToOrb() is 0.
     *
     * Use function moveTo(long id) in FindState to move to a neighboring<br>
     * tile by its ID. Doing this will change state to reflect your new position.
     *
     * A suggested first implementation that will always find the orb, but <br>
     * likely won't receive a large bonus multiplier, is a depth-first search. <br>
     * Some modification is necessary to make the search better, in general. */
    @Override
    public void find(FindState state) {
        // TODO 1: Walk to the orb

        HashSet<Long> visitedHS= new HashSet<>();
        dfsWalk(state, visitedHS);
    }

    public int dfsWalk(FindState s, HashSet<Long> visitedHS) {
        Heap<NodeStatus> neighborsHeap= new Heap<>(true);

        if (s.distanceToOrb() == 0) return 1;
        long prev= s.currentLoc();
        visitedHS.add(prev);

        // Add all neighbors to the min-heap
        for (NodeStatus n : s.neighbors()) {
            if (!visitedHS.contains(n.getId())) {
                neighborsHeap.insert(n, n.getDistanceToTarget());
            }
        }

        while (neighborsHeap.size() != 0) {
            s.moveTo(neighborsHeap.poll().getId());
            if (dfsWalk(s, visitedHS) == 1) return 1;
            s.moveTo(prev);
        }
        return 0;
    }

    /** Get out the cavern before the ceiling collapses, trying to collect as <br>
     * much gold as possible along the way. Your solution must ALWAYS get out <br>
     * before steps runs out, and this should be prioritized above collecting gold.
     *
     * You now have access to the entire underlying graph, which can be accessed <br>
     * through FleeState state. <br>
     * currentNode() and exit() will return Node objects of interest, and <br>
     * allsNodes() will return a collection of all nodes on the graph.
     *
     * Note that the cavern will collapse in the number of steps given by <br>
     * stepsLeft(), and for each step this number is decremented by the <br>
     * weight of the edge taken. <br>
     * Use stepsLeft() to get the steps still remaining, and <br>
     * moveTo() to move to a destination node adjacent to your current node.
     *
     * You must return from this function while standing at the exit. <br>
     * Failing to do so before steps runs out or returning from the wrong <br>
     * location will be considered a failed run.
     *
     * You will always have enough steps to flee using the shortest path from the <br>
     * starting position to the exit, although this will not collect much gold. <br>
     * For this reason, using Dijkstra's to plot the shortest path to the exit <br>
     * is a good starting solution
     *
     * Here's another hint. Whatever you do you will need to traverse a given path. It makes sense
     * to write a method to do this, perhaps with this specification:
     *
     * // Traverse the nodes in moveOut sequentially, starting at the node<br>
     * // pertaining to state <br>
     * // public void moveAlong(FleeState state, List<Node> moveOut) */
    @Override
    public void flee(FleeState state) {
        // TODO 2. Get out of the cavern in time, picking up as much gold as possible.

        // startTime= System.currentTimeMillis();

        dfsGold(state);

        // System.out.println("Elapsed time: " + elapsedTime() / 1000.00 + " seconds");
    }

    public void dfsGold(FleeState state) {
        List<Node> shortestPath= Path.shortestPath(state.currentNode(), state.exit());
        int lengthShortestPath= Path.pathSum(shortestPath);
        shortestPath.remove(0);
        List<Node> toNextGold= Path.findShortestPathToGold(state);
        int lengthNextGold= 2 * Path.pathSum(toNextGold);
        toNextGold.remove(0);

        while (lengthNextGold + lengthShortestPath < state.stepsLeft()) {
            for (Node n : toNextGold) {
                state.moveTo(n);
            }
            if (state.currentNode() == state.exit()) return;
            shortestPath= Path.shortestPath(state.currentNode(), state.exit());
            lengthShortestPath= Path.pathSum(shortestPath);
            shortestPath.remove(0);
            toNextGold= Path.findShortestPathToGold(state);
            lengthNextGold= 2 * Path.pathSum(toNextGold);
            if (toNextGold.size() == 0) break;
            toNextGold.remove(0);
        }
        for (Node n : shortestPath) {
            if (state.currentNode() == state.exit()) return;
            state.moveTo(n);
            shortestPath= Path.shortestPath(state.currentNode(), state.exit());
            lengthShortestPath= Path.pathSum(shortestPath);
            toNextGold= Path.findShortestPathToGold(state);
            lengthNextGold= 2 * Path.pathSum(toNextGold);
            if (toNextGold.size() != 0) {
                if (lengthNextGold + lengthShortestPath < state.stepsLeft()) {
                    dfsGold(state);
                }
            }
        }

    }

    // takes martha to exit
    public void toExit(FleeState state) {
        List<Node> path= Path.shortestPath(state.currentNode(), state.exit());
        path.remove(0);
        for (Node n : path) {
            state.moveTo(n);
        }
    }

}
