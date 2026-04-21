import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class test {

        static class Point {
            int x, y;
            Point(int x, int y) { this.x = x; this.y = y; }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Point)) return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

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
