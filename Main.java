import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a Binary tree, create a Linked Lists of all the nodes at each depth. If the tree has height k then create k linked lists.
 *
 * (Challenge definition seen in Cracking the coding interview book.)
 *
 * For this problem, we'll assume the following Tree Node:
 *
 * public class Node {
 *   public int value;
 *   public Node left;
 *   public Node right;
 *
 *   public Node(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Main {

  /**
   * The interesting part here is how to identify at which level the concrete node is located. Since we must aggregate all the nodes in a linked lists based
   * on their level, we have to traverse the whole tree. To do that, we can use any of the methods from: <link>BinaryTreeTraversal</link> or any iterative
   * method as well, like we'll do in the second solution.
   *
   * For the first solution (recursive one) we'll always start with the root node (level 0), the children of the root will be at (root level + 1 = 0 + 1 = 1) and
   * the children of the root children will be at (root children level + 1 = 1 + 1 = 2), etc..
   *
   * So.. we need to start from the root, increment the level for the children of each sub-tree and pass it accordingly in the recursive call.
   * To incorporate a traversal in such order we could use a Pre-order (root -> left -> right) and our solution is ready to be implemented.
   *
   * Time Complexity: O(n) where n is the amount of nodes
   * Space Complexity: O(log n)
   */
  public static List<LinkedList<Node>> buildDepthListV1(Node node) {
    List<LinkedList<Node>> levels = new ArrayList<>();

    buildDepthListV1(node, levels, 0);

    return levels;
  }

  private static void buildDepthListV1(Node node, List<LinkedList<Node>> levels, int depth) {
    if (node == null) {
      return;
    }

    // Expand, if not enough space
    // to hold the next level
    if (levels.size() <= depth) {
      levels.add(new LinkedList<>());
    }

    // put the node at the
    // level it belongs
    levels.get(depth).add(node);

    // repeat for the left sub-tree
    // with an incremented depth
    buildDepthListV1(node.left, levels, depth + 1);

    // repeat for the right sub-tree
    // with an incremented depth
    buildDepthListV1(node.right, levels, depth + 1);
  }

  /**
   * The second approach would be iterative and to incorporate such we can either add a new property (level) on the node itself or create a wrapper class
   * that will hold the Node as well as the <b>level</b> property, if we're allowed to do that (let's assume this is the case).
   *
   * The solution would be quite similar to the V1 with the differences that here we're using a Queue (<link>GraphTraversal#bfs</link>)
   * to hold the nodes we have to visit next and the level they're located at will be held as a Node's property, and be set before being added to the queue,
   * based on its parent level.
   *
   * Time Complexity: O(n)
   * Space Complexity: O(n) because the maximum number of nodes that can be present in the queue is equal to the maximum number of nodes at any level of the tree,
   * which is N/2 in the worst case for a balanced binary tree.
   */
  public static List<LinkedList<Node>> buildDepthListV2(Node node) {
    List<LinkedList<Node>> levels = new ArrayList<>();

    if (node == null) {
      return levels;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      Node current = queue.remove();

      // Expand, if not enough space
      // to hold the next level
      if (levels.size() <= current.level) {
        levels.add(new LinkedList<>());
      }

      // put the node at the
      // level it belongs
      levels.get(current.level).add(current);

      // if not null -> increment level with 1
      // based on parent's value, set, and
      // put in queue
      if (current.left != null) {
        current.left.level = current.level + 1;
        queue.add(current.left);
      }

      // if not null -> increment level with 1
      // based on parent's value, set, and
      // put in queue
      if (current.right != null) {
        current.right.level = current.level + 1;
        queue.add(current.right);
      }
    }

    return levels;
  }
}
