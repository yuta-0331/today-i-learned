package afternoonExam;

import java.util.*;

public class GhostLeg {
    private List<VerticalLine> verticalLines;

    public GhostLeg(int n) {
        verticalLines = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            verticalLines.add(new VerticalLine());
        }
    }

    public void addHorizontalLine(int x1, int x2, double y) {
        if (y <= 0.0 || y >= 1.0) {
            throw IllegalArgumentException();
        }
        VerticalLine v1 = verticalLines.get(x1);
        VerticalLine v2 = verticalLines.get(x2);
        if (x1 != x2 && !v1.hasHorizontalLineAt(y) && !v2.hasHorizontalLineAt(y)) {
            v1.putHorizontalLine(y, v2);
            v2.putHorizontalLine(y, v1);
        }
    }

    public int trace(int x) {
        double y = 1.0;
        VerticalLine v = verticalLines.get(x);
        while ((y = v.getNextY(y)) > 0.0) {
            v = v.getOpposite(y);
        }
        return verticalLines.indexOf(v);
    }

    private static class VerticalLine {
        SortedMap<Double, VerticalLine> horizontalLines = new TreeMap<>();

        VerticalLine() {
            horizontalLines.put(0.0, null);
        }

        boolean hasHorizontalLineAt(double y) {
            return horizontalLines.containsKey(y);
        }

        void putHorizontalLine(double y, VerticalLine opposite) {
            horizontalLines.put(y, opposite);
        }
        double getNextY(double y) {
            return horizontalLines.headMap(y).lastKey();
        }
        VerticalLine getOpposite(double y) {
            return horizontalLines.get(y);
        }
    }
}
