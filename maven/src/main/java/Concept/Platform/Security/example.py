from dbm import sqlite3


def get_user_age(user_id):
    conn = sqlite3.connect('users.db')
    cursor = conn.cursor()
    cursor.execute(f"SELECT age FROM users WHERE id = {user_id}")
    result = cursor.fetchone()
    conn.close()
    return result[0]


def process_file(filename):
    f = open(filename, 'r')
    data = f.read()
    # ... process data ...
    return data


