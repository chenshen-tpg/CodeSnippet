package PlatformQA.HashMapCollision;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollisionDemo {
    public static void main(String[] args) {
        Map<Point, String> map = new HashMap<>();
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(1, 2);
        map.put(p1, "A");
        map.put(p2, "B");
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // true
        System.out.println("map.get(p1): " + map.get(p1)); // A
        System.out.println("map.get(p3): " + map.get(p3)); // A, because equals() returns true
        System.out.println("map.get(p2): " + map.get(p2)); // B
        System.out.println("Hash codes: p1=" + p1.hashCode() + ", p2=" + p2.hashCode() + ", p3=" + p3.hashCode());
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            // Deliberately cause collisions for demonstration
            return 42; // All points have the same hash code
        }
    }
}

