import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MainTest {

  @Test
  public void testV1() {
    Assertions.assertTrue(Main.buildDepthListV1(null).isEmpty());

    Node a = new Node(1);

    List<LinkedList<Node>> levels = Main.buildDepthListV1(a);

    Assertions.assertEquals(1, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));

    Node b = new Node(2);
    Node c = new Node(3);

    a.left = b;
    a.right = c;

    levels = Main.buildDepthListV1(a);
    Assertions.assertEquals(2, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(b,c)), levels.get(1));

    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    Node j = new Node(10);
    Node k = new Node(11);
    Node l = new Node(12);
    Node m = new Node(13);

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    d.left = h;
    d.right = i;

    f.left = j;
    f.right = k;

    j.left = l;

    l.right = m;

    /**
     *                       1                    L0
     *             2                    3         L1
     *       4          5          6         7    L2
     *    8    9                10   11           L3
     *                       12                   L4
     *                    13                      L5
     */

    levels = Main.buildDepthListV1(a);

    Assertions.assertEquals(6, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(b, c)), levels.get(1));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(d, e, f, g)), levels.get(2));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(h, i, j, k)), levels.get(3));
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(l)), levels.get(4));
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(m)), levels.get(5));
  }

  @Test
  public void testV2() {
    Assertions.assertTrue(Main.buildDepthListV2(null).isEmpty());

    Node a = new Node(1);

    List<LinkedList<Node>> levels = Main.buildDepthListV2(a);

    Assertions.assertEquals(1, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));

    Node b = new Node(2);
    Node c = new Node(3);

    a.left = b;
    a.right = c;

    levels = Main.buildDepthListV2(a);
    Assertions.assertEquals(2, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(b,c)), levels.get(1));

    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);
    Node h = new Node(8);
    Node i = new Node(9);
    Node j = new Node(10);
    Node k = new Node(11);
    Node l = new Node(12);
    Node m = new Node(13);

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    d.left = h;
    d.right = i;

    f.left = j;
    f.right = k;

    j.left = l;

    l.right = m;

    /**
     *                       1                    L0
     *             2                    3         L1
     *       4          5          6         7    L2
     *    8    9                10   11           L3
     *                       12                   L4
     *                    13                      L5
     */

    levels = Main.buildDepthListV2(a);

    Assertions.assertEquals(6, levels.size());
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(a)), levels.get(0));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(b, c)), levels.get(1));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(d, e, f, g)), levels.get(2));
    Assertions.assertEquals(new LinkedList<>(Arrays.asList(h, i, j, k)), levels.get(3));
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(l)), levels.get(4));
    Assertions.assertEquals(new LinkedList<>(Collections.singletonList(m)), levels.get(5));
  }
}
