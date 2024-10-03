package timingtest;
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
        AList<Integer> opCounts = new AList<>();

        int textLength = 1000;
        for (int i = 0; i < 8; i++) {
            if (i > 0) {
                textLength *= 2;
            }

            Ns.addLast(textLength);
            SLList<Integer> Text = new SLList<>();
            for (int j = 0; j < textLength; j++) {
                Text.addLast(1);
            }

            int M = 1000;
            Stopwatch timer = new Stopwatch();
            for (int j = 0; j < M; j++) {
                Text.getLast();
            }
            times.addLast(timer.elapsedTime());
            opCounts.addLast(M);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
