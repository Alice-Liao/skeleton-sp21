package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> alst = new AListNoResizing<>();
        alst.addLast(4);
        alst.addLast(5);
        alst.addLast(6);

        BuggyAList<Integer> blst = new BuggyAList<>();
        blst.addLast(4);
        blst.addLast(5);
        blst.addLast(6);


        assertEquals(alst.removeLast(), blst.removeLast());
        assertEquals(alst.removeLast(), blst.removeLast());
        assertEquals(alst.removeLast(), blst.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for(int i = 0; i < N; i++){
            int operationNumber = StdRandom.uniform(0, 4);
            if(operationNumber == 0) {
                //add Last
                int randVal = StdRandom.uniform(1, 100);
                L.addLast(randVal);
                B.addLast(randVal);

            }else if ((operationNumber == 1) && (L.size() > 0)) {
                //get last
                int lastNum = L.getLast();
                int lastNumB = L.getLast();
                assertEquals(lastNum, lastNumB);

            }else if ((operationNumber ==2) &&(L.size() > 0)){
                //remove last
                int removeNum = L.removeLast();
                int removeNumB = B.removeLast();
                assertEquals(removeNum, removeNumB);

            }else if (operationNumber == 3){
                //size
                int size = L.size();
                int sizeB = B.size();
                assertEquals(size, sizeB);
                assertEquals(size, sizeB);

            }
        }
    }
}
