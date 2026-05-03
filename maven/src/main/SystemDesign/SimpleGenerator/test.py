import requests
from bs4 import BeautifulSoup

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def __eq__(self, other):
        return isinstance(other, Point) and self.x == other.x and self.y == other.y
    def __hash__(self):
        return hash((self.x, self.y))

def print_secret_message(url):
    try:
        response = requests.get(url)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        table = soup.find('table')
        if not table:
            return
        rows = table.find_all('tr')
        grid_data = {}
        max_x = max_y = 0
        for row in rows[1:]:
            cols = row.find_all('td')
            if len(cols) < 3:
                continue
            x = int(cols[0].get_text(strip=True))
            c = cols[1].get_text(strip=True)[0]
            y = int(cols[2].get_text(strip=True))
            grid_data[Point(x, y)] = c
            max_x = max(max_x, x)
            max_y = max(max_y, y)
        for y in range(max_y, -1, -1):
            row_str = ''
            for x in range(max_x + 1):
                row_str += grid_data.get(Point(x, y), ' ')
            print(row_str)
    except Exception as e:
        print(f"Error fetching the document: {e}")

if __name__ == "__main__":
    doc_url = "https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub"
    print_secret_message(doc_url)