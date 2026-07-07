"""
generator.py

Generates random patient vitals data.
"""

import random
from datetime import datetime
from config import PATIENT_IDS


def generate_vitals():
    """
    Generate mock patient vitals.
    """

    patient = random.choice(PATIENT_IDS)

    heart_rate = random.randint(55, 120)

    spo2 = random.randint(90, 100)

    temperature = round(random.uniform(36.0, 38.5), 1)

    timestamp = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    vitals = {
        "patient_id": patient,
        "heart_rate": heart_rate,
        "spo2": spo2,
        "temperature": temperature,
        "timestamp": timestamp
    }

    return vitals