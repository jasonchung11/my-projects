import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long distSquared(Point p1, Point p2, Point p3) {
        long dx1 = p1.x - p2.x;
        long dy1 = p1.y - p2.y;
        long dx2 = p1.x - p3.x;
        long dy2 = p1.y - p3.y;
        long dx3 = p2.x - p3.x;
        long dy3 = p2.y - p3.y;
        return dx1 * dx1 + dy1 * dy1 + dx2 * dx2 + dy2 * dy2 + dx3 * dx3 + dy3 * dy3;
    }

    static long[][] minCostTriangulation(Point[] vertices) {
        int n = vertices.length;
        long[][] dp = new long[n][n];
        long[][] nextTri = new long[n][n];

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    long cost = dp[i][k] + dp[k][j] + distSquared(vertices[i], vertices[k], vertices[j]);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        nextTri[i][j] = k;
                    }
                }
            }
        }

        List<long[]> triangles = new ArrayList<>();
        reconstructTriangulation(0, n - 1, nextTri, triangles);

        return new long[][]{dp[0], nextTri[0], triangles.stream().flatMapToLong(Arrays::stream).toArray()};
    }

    static void reconstructTriangulation(long i, long j, long[][] nextTri, List<long[]> triangles) {
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
        Point[] vertices = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            vertices[i] = new Point(x, y);
        }
        long[][] result = minCostTriangulation(vertices);
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