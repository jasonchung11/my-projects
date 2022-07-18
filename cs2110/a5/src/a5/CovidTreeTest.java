package a5;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/** @author david gries */
public class CovidTreeTest {
    /* DISCUSSION OF TESTING
     * Testing with trees is HARDER than testing in A1, A2, or even A3, with circular linked lists.
     *
     * We have provided some methods to help you test your methods that manipulate trees.
     *
     *1. TESTING METHOD SIZE. To do test size adequately, you have to create a
     * tree with lots of nodes and see whether size() returns the right value.
     *
     * METHOD makeTree1 CREATES A "LARGE" TREE!  USE IT TO TEST METHOD size()!
     *
     *
     * 2. TESTING METHOD CONTAINS.
     * Look directly below at the static fields. There is an array of type Human
     * and individual variables HumanA, ..., HumanL. Look below those declarations
     * at method setup. It has the annotation  @BeforeClass, which means that
     * it will be called before methods that have @Test before them are called.
     * Method setup initializes the fields just mentioned. Note this:
     *
     *     HumanA has name "A"
     *     HumanB has name "B"
     *     ...
     *     HumanL has name "L"
     *
     * Further, array humans contains the values (HumanA, HumanB, ..., HumanL).
     * You can use these in testing. For example, look at method makeTree1.
     * Its specification shows you the tree it constructs. For example, after
     * executing
     *
     *      CovidTree ct= makeTree1();
     *
     * you can test whether HumanA and HumanL are in it using
     *
     *      assertEquals(true, ct.contains(HumanA));
     *      assertEquals(false, ct.contains(HumanC));
     * */

    private static Network n;
    private static Human[] humans;
    private static Human humanA;
    private static Human humanB;
    private static Human humanC;
    private static Human humanD;
    private static Human humanE;
    private static Human humanF;
    private static Human humanG;
    private static Human humanH;
    private static Human humanI;
    private static Human humanJ;
    private static Human humanK;
    private static Human humanL;

    /** */
    @BeforeClass
    public static void setup() {
        n= new Network();
        humans= new Human[] { new Human("A", 0, n), new Human("B", 0, n),
                new Human("C", 0, n), new Human("D", 0, n),
                new Human("E", 0, n), new Human("F", 0, n),
                new Human("G", 0, n), new Human("H", 0, n),
                new Human("I", 0, n), new Human("J", 0, n),
                new Human("K", 0, n), new Human("L", 0, n)
        };
        humanA= humans[0];
        humanB= humans[1];
        humanC= humans[2];
        humanD= humans[3];
        humanE= humans[4];
        humanF= humans[5];
        humanG= humans[6];
        humanH= humans[7];
        humanI= humans[8];
        humanJ= humans[9];
        humanK= humans[10];
        humanL= humans[11];
    }

    /* TESTING METHOD DEPTH.
     * Take a look at the tree produced by method make1. We have:
     *    humanA is at depth 0
     *    humanB is at depth 1
     *    humanC is at depth 1
     *    humanD is at depth 2  and so on.
     *
     * Array people already contains humanA, humanB, humanC, ..., humanL
     * What if you constructed an array
     *
     *    var depths= new int[]{0, 1, 1, 2, ...}
     *
     * that contained the depth of each human in array people (including those
     * that are not in it)? You could then write a loop in method testContains
     * to test ALL of those people:
     *
     *    for (int k= 0; k < people.length; k= k+1) {
     *        assertEquals(depths[k], a suitable call on depth, for you to do);
     *    }
     *
     * This is the work that has to go on to do adequate testing
     */

    /** * */
    @Test
    public void testBuiltInGetters() {
        var st= new CovidTree(humanB);
        assertEquals("B", toStringBrief(st));
    }

    /** Create a CovidTree with structure A[B[D E F[G[H[I] J]]] C] <br>
     * This is the tree
     *
     * <pre>
     *            A
     *          /   \
     *         B     C
     *       / | \
     *      D  E  F
     *            |
     *            G
     *            | \
     *            H  J
     *            |
     *            I
     * </pre>
     */
    private CovidTree makeTree1() {
        var dt= new CovidTree(humanA); // A
        dt.insert(humanA, humanB); // A, B
        dt.insert(humanA, humanC); // A, C
        dt.insert(humanB, humanD); // B, D
        dt.insert(humanB, humanE); // B, E
        dt.insert(humanB, humanF); // B, F
        dt.insert(humanF, humanG); // F, G
        dt.insert(humanG, humanH); // G, H
        dt.insert(humanH, humanI); // H, I
        dt.insert(humanG, humanJ); // G, J
        return new CovidTree(dt);
    }

    /** test a call on makeTree1(). */
    @Test
    public void testMakeTree1() {
        var dt= makeTree1();
        assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
    }

    /** */
    @Test
    public void test1Insert() {
        var st= new CovidTree(humanB);

        // Test insert in the root
        var dtC= st.insert(humanB, humanC);
        assertEquals("B[C]", toStringBrief(st)); // test tree
        assertEquals(humanC, dtC.human());  // test return value

        // YOU SHOULD WRITE MORE TEST CASES HERE. We supply only one test case.

    }

    /** */
    @Test
    public void test2size() {
        /* We provide ONE test case. YOU WRITE MORE.
         * At this point, look at line 13 (about) for a discussion of making
         * a tree with which to test size. */

        var st= new CovidTree(humanC);
        assertEquals(1, st.size());

        st.insert(humanC, humanD);
        assertEquals(2, st.size());

        st.insert(humanD, humanE);
        assertEquals(3, st.size());

        st.insert(humanC, humanF);
        assertEquals(4, st.size());

    }

    /** */
    @Test
    public void test3contains() {
        /* We give you ONE test case. You have to put more in. Look at
         * about line 24 for a discussion of how to do this. You will learn
         * a lot about how to prepare for testing complicated data structures.
         */
        var st= new CovidTree(humanC);
        assertEquals(true, st.contains(humanC));

        st.insert(humanC, humanD);
        assertEquals(true, st.contains(humanD));

        st.insert(humanD, humanE);
        assertEquals(true, st.contains(humanD));
        assertEquals(true, st.contains(humanE));
        assertEquals(true, st.contains(humanC));

        st.insert(humanC, humanF);
        assertEquals(true, st.contains(humanC));
        assertEquals(true, st.contains(humanD));
        assertEquals(true, st.contains(humanE));
        assertEquals(true, st.contains(humanF));
        assertEquals(false, st.contains(humanG));
        assertEquals(false, st.contains(humanH));

    }

    /** */
    @Test
    public void test4depth() {
        /* We give you ONE test case. You have to put more in. Look at
         * about line 90 for a discussion of how to do this. You will learn
         * a lot about how to prepare for testing complicated data structures.
         */
        var st= new CovidTree(humanB);
        st.insert(humanB, humanC);
        st.insert(humanC, humanD);
        st.insert(humanD, humanF);
        assertEquals(0, st.depth(humanB));
        assertEquals(1, st.depth(humanC));
        assertEquals(2, st.depth(humanD));
        assertEquals(3, st.depth(humanF));

        st.insert(humanB, humanE);
        assertEquals(1, st.depth(humanE));

    }

    /** */
    @Test
    public void test5WidthAtDepth() {
        // We give you ONE test case. You write more.
        var st= new CovidTree(humanB);
        assertEquals(1, st.widthAtDepth(0));
        st.insert(humanB, humanC);
        assertEquals(1, st.widthAtDepth(1));
        st.insert(humanB, humanD);
        assertEquals(2, st.widthAtDepth(1));
        st.insert(humanC, humanE);
        assertEquals(1, st.widthAtDepth(2));
        st.insert(humanE, humanF);
        st.insert(humanE, humanG);
        st.insert(humanE, humanH);
        assertEquals(3, st.widthAtDepth(3));

    }

    @SuppressWarnings("javadoc")
    @Test
    public void test6CovidRouteTo() {
        /* The one testcase we give shows you how method getNames() is
         * used to make testing a bit easier.
         * Use it in developing more testcases. Using method makeTree1 can help.*/
        var st= new CovidTree(humanB);
        var route= st.CovidRouteTo(humanB);
        assertEquals("[B]", getNames(route));
        st.insert(humanB, humanC);
        st.insert(humanB, humanD);
        st.insert(humanC, humanE);
        st.insert(humanC, humanF);
        st.insert(humanE, humanG);
        st.insert(humanF, humanH);
        var rt= st.CovidRouteTo(humanH);
        assertEquals("[B, C, F, H]", getNames(rt));

    }

    /** Return the names of Humans in sp, separated by ", " and delimited by [ ]. <br>
     * Precondition: No name is the empty string. */
    private String getNames(List<Human> sp) {
        var res= "[";
        for (Human p : sp) {
            if (res.length() > 1) res= res + ", ";
            res= res + p.name();
        }
        return res + "]";
    }

    /** */
    @Test
    public void test7commonAncestor() {
        var st= new CovidTree(humanB);
        st.insert(humanB, humanC);
        var p= st.commonAncestor(humanC, humanC);
        assertEquals(humanC, p);

        st.insert(humanB, humanD);
        st.insert(humanB, humanE);
        st.insert(humanC, humanF);
        st.insert(humanC, humanG);
        st.insert(humanD, humanH);
        st.insert(humanD, humanI);
        st.insert(humanI, humanJ);
        st.insert(humanJ, humanK);

        var a= st.commonAncestor(humanC, humanK);
        assertEquals(humanB, a);
        var b= st.commonAncestor(humanK, humanH);
        assertEquals(humanD, b);
        var c= st.commonAncestor(humanK, humanB);
        assertEquals(humanB, c);
        var d= st.commonAncestor(humanD, humanJ);
        assertEquals(humanD, d);
        // Write more test cases. You can use the tree that makeTree(1) returns.

    }

    /** This is what makeTree1() produces
     *
     * <pre>
     *            A
     *          /   \
     *         B     C
     *       / | \
     *      D  E  F
     *            |
     *            G
     *            | \
     *            H  J
     *            |
     *            I
     * </pre>
     */

    /** */
    @Test
    public void test8equals() {
        // We give you one test case. You write more.
        // Using makeTree1() and makeTree2() can help.
        var treeB1= new CovidTree(humanB);
        var treeB2= new CovidTree(humanB);
        assertEquals(true, treeB1.equals(treeB1));
        assertEquals(true, treeB1.equals(treeB2));
        treeB1.insert(humanB, humanC);
        treeB2.insert(humanB, humanC);
        assertEquals(true, treeB1.equals(treeB2));
        assertEquals(true, treeB2.equals(treeB1));
        var treeB3= new CovidTree(humanE);
        assertEquals(false, treeB1.equals(treeB3));
        treeB3.insert(humanE, humanB);
        assertEquals(false, treeB1.equals(treeB3));
    }

    /* Make a tree like makeTree1 except that use humanK instead of humanH*/
    private CovidTree makeTree2() {
        var dt= new CovidTree(humanA); // A
        dt.insert(humanA, humanB); // A, B
        dt.insert(humanA, humanC); // A, C
        dt.insert(humanB, humanD); // B, D
        dt.insert(humanB, humanE); // B, E
        dt.insert(humanB, humanF); // B, F
        dt.insert(humanF, humanG); // F, G
        dt.insert(humanG, humanK); // G, K
        dt.insert(humanK, humanI); // K, I
        dt.insert(humanG, humanJ); // G, J
        return new CovidTree(dt);
    }

    // ===================================
    // ==================================

    /** Return a representation of this tree. This representation is: <br>
     * (1) the name of the Human at the root, followed by <br>
     * (2) the representations of the children <br>
     * . (in alphabetical order of the children's names). <br>
     * . There are two cases concerning the children.
     *
     * . No children? Their representation is the empty string. <br>
     * . Children? Their representation is the representation of each child, <br>
     * . with a blank between adjacent ones and delimited by "[" and "]". <br>
     * <br>
     * Examples: One-node tree: "A" <br>
     * root A with children B, C, D: "A[B C D]" <br>
     * root A with children B, C, D and B has a child F: "A[B[F] C D]" */
    public static String toStringBrief(CovidTree t) {
        var res= t.human().name();

        var childs= t.copyOfChildren().toArray();
        if (childs.length == 0) return res;
        res= res + "[";
        selectionSort1(childs);

        for (var k= 0; k < childs.length; k= k + 1) {
            if (k > 0) res= res + " ";
            res= res + toStringBrief((CovidTree) childs[k]);
        }
        return res + "]";
    }

    /** Sort b --put its elements in ascending order. <br>
     * Sort on the name of the Human at the root of each CovidTree.<br>
     * Throw a cast-class exception if b's elements are not CovidTree */
    public static void selectionSort1(Object[] b) {
        var j= 0;
        // {inv P: b[0..j-1] is sorted and b[0..j-1] <= b[j..]}
        // 0---------------j--------------- b.length
        // inv : b | sorted, <= | >= |
        // --------------------------------
        while (j != b.length) {
            // Put into p the index of smallest element in b[j..]
            var p= j;
            for (var i= j + 1; i != b.length; i++ ) {
                var bi= ((CovidTree) b[i]).human().name();
                var bp= ((CovidTree) b[p]).human().name();
                if (bi.compareTo(bp) < 0) {
                    p= i;

                }
            }
            // Swap b[j] and b[p]
            var t= b[j];
            b[j]= b[p];
            b[p]= t;
            j= j + 1;
        }
    }

}
