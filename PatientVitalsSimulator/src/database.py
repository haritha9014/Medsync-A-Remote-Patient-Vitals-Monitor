"""
Database Configuration
Creates SQLite database and patient_vitals table.
"""

import sqlite3
from config import DATABASE_NAME


def get_connection():
    """
    Returns SQLite database connection.
    """
    return sqlite3.connect(DATABASE_NAME)


def create_table():
    """
    Creates patient_vitals table if it doesn't exist.
    """

    conn = get_connection()
    cursor = conn.cursor()

    cursor.execute("""
                   CREATE TABLE IF NOT EXISTS patient_vitals (

                                                                 id INTEGER PRIMARY KEY AUTOINCREMENT,

                                                                 patient_id TEXT NOT NULL,

                                                                 heart_rate INTEGER,

                                                                 spo2 INTEGER,

                                                                 temperature REAL,

                                                                 timestamp TEXT

                   )
                   """)

    conn.commit()
    conn.close()