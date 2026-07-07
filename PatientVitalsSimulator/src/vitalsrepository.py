"""
vitalsrepository.py

Saves patient vitals into SQLite database.
"""

from database import get_connection


def save_vitals(vitals):
    """
    Save patient vitals into database.
    """

    conn = get_connection()

    cursor = conn.cursor()

    cursor.execute("""

                   INSERT INTO patient_vitals
                   (
                       patient_id,
                       heart_rate,
                       spo2,
                       temperature,
                       timestamp
                   )

                   VALUES (?, ?, ?, ?, ?)

                   """,

                   (

                       vitals["patient_id"],
                       vitals["heart_rate"],
                       vitals["spo2"],
                       vitals["temperature"],
                       vitals["timestamp"]

                   ))

    conn.commit()

    conn.close()