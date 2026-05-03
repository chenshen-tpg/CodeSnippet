package main.SystemDesign.SimpleGenerator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/***
 *
 *
 *

 x-coordinate, Character, y-coordinate
 87, '', 0
 **, '', **
 *
 *
 */

public class PlatFormTest {

        static class Point {
            int x, y;
            Point(int x, int y) { this.x = x; this.y = y; }


            // equals based on the x,y,
            @Override
            public boolean equals(Object o) {
                //if it's same then it's indetical
                if (this == o) return true;
                // not sure if this is necessary in the case, but it means that this ensures that you only compare Point objects to other Point objects.
                if (!(o instanceof Point)) return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }
            //Values are based on the x,y, in stead of memory address.
            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
        //logics to locate the certain picture that
        public static void printSecretMessage(String url) {
            try {
                Document doc = Jsoup.connect(url).get();
                Element table = doc.select("table").first();
                if (table == null) return;
                Elements rows = table.select("tr");
                Map<Point, Character> gridData = new HashMap<>();
                int maxX = 0;
                int maxY = 0;
                for (int i = 1; i < rows.size(); i++) {
                    Elements cols = rows.get(i).select("td");
                    if (cols.size() < 3) continue;
                        int x = Integer.parseInt(cols.get(0).text().trim());
                        char c = cols.get(1).text().trim().charAt(0);
                        int y = Integer.parseInt(cols.get(2).text().trim());
                        gridData.put(new Point(x, y), c);
                        if (x > maxX) maxX = x;
                        if (y > maxY) maxY = y;

                }
                for (int y = maxY; y >= 0; y--) {
                    StringBuilder rowString = new StringBuilder();
                    for (int x = 0; x <= maxX; x++) {
                        rowString.append(gridData.getOrDefault(new Point(x, y), ' '));
                    }
                    System.out.println(rowString.toString());
                }

            } catch (IOException e) {
                System.err.println("Error fetching the document: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            String docUrl = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub";
            printSecretMessage(docUrl);
        }
}
