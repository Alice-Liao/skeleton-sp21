package timingtest;
import com.sun.xml.internal.rngom.nc.NsNameClass;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> onCounts = new AList<>();
        SLList<Integer> afterAdd = new SLList<>();
        int i;

        int ops = 10000;
        int getLast;
        int n = 1000;
        for(i = 0; i < 8; i++){
            afterAdd = addItems(n);
            Ns.addLast(n);
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < ops;j++) {
                afterAdd.getLast();
            }
            times.addLast(sw.elapsedTime());
            onCounts.addLast(ops);
            n *= 2;
        }
        printTimingTable(Ns, times, onCounts);
    }
    public static SLList<Integer> addItems(int n){
        SLList<Integer> afterAdd = new SLList<>();
        int i;
        for(i = 0; i <= n; i++){
            afterAdd.addLast(i);
        }
        return afterAdd;
    }

}
