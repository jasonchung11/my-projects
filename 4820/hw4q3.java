sadimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

class Main {
    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long calc_dist(Point p1, Point p2, Point p3) {
        long x1 = p1.x - p2.x;
        long x2 = p1.x - p3.x;
        long x3 = p2.x - p3.x;
        long y1 = p1.y - p2.y;
        long y2 = p1.y - p3.y;
        long y3 = p2.y - p3.y;
        return Math.pow(x1) + Math.pow(x2) + Math.pow(x3) + Math.pow(y1) + Math.sqrt(y2) + Math.sqrt(y3);
    }

    static long[][] triangulation(Point[] verts) {
        int len = verts.length;
        long[][] dptable = new long[len][len];
        long[][] next = new long[len][len];
        for (int dist = 2; dist < len; dist++) {
            for (int i = 0; i < len - dist; i++) {
                dp[i][j] = Long.MAX_VALUE;
                int j = i + dist;
                for (int k = i + 1; k < j; k++) {
                    long cost_temp = sqDist(verts[i], verts[j], verts[k]) + dptable[i][k] + dptable[k][j];
                    if (cost_temp < dptable[i][j]) {
                    dptable[i][j] = cost_temp;
                    next[i][j] = k;
                    } 
                }
            }
        }

        List<long[]> triangles = new ArrayList<>();
        reconstruct(0, len - 1, next, triangles);

        return new long[][]{dp[0], next[0], triangles.stream().flatMapToLong(Arrays::stream).toArray()};
    }

    static void reconstruct(long i, long j, long[][] nextTriangulation, List<long[]> triangles) {
        Stack<long[]> stack = new Stack<>();
        stack.push(new long[]{i, j});

        while (!stack.isEmpty()) {
            long[] current = stack.pop();
            i = current[0];
            j = current[1];

            if (j - i <= 1) {
                continue;
            }

            long k = nextTri[(int) i][(int) j];
            triangles.add(new long[]{i, k, j});

            if (i < k && k < j) {
                stack.push(new long[]{i, k});
                stack.push(new long[]{k, j});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] verts = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            vertices[i] = new Point(x, y);
        }
        long[][] result = minCostTriangulation(verts);
        long cost = result[0][n - 1];
        List<long[]> triangles = new ArrayList<>();
        for (int i = 2; i < result[2].length; i += 3) {
            triangles.add(new long[]{result[2][i - 2], result[2][i - 1], result[2][i]});
        }

        System.out.println(cost);
        for (long[] triangle : triangles) {
            for (long vertex : triangle) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}