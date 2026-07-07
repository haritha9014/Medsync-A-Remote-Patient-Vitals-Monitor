"""
transmitter.py

Sends patient vitals to Java Spring Boot server.
"""

import requests
from config import SERVER_URL


def send_vitals(vitals):
    """
    Send vitals to Java REST API.
    """

    try:

        response = requests.post(
            SERVER_URL,
            json=vitals,
            timeout=5
        )

        if response.status_code == 200:
            print("Data Sent Successfully")
        else:
            print("Failed :", response.status_code)

    except requests.exceptions.ConnectionError:
        print("Java Server is not running.")

    except Exception as e:
        print("Error :", e)