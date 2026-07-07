"""
simulator.py

Main program.
Generates patient vitals every 5 seconds,
stores them in SQLite,
and sends them to the Java backend.
"""

import time

from config import TRANSMISSION_INTERVAL
from database import create_table
from generator import generate_vitals
from transmitter import send_vitals
from vitalsrepository import save_vitals


def main():

    print("===================================")
    print(" MedSync Patient Simulator Started ")
    print("===================================")

    # Create database table
    create_table()

    while True:

        # Generate patient vitals
        vitals = generate_vitals()

        print("\nGenerated Vitals")
        print(vitals)

        # Save into SQLite
        save_vitals(vitals)

        print("Saved into SQLite Database")

        # Send to Java
        send_vitals(vitals)

        print("-----------------------------------")

        # Wait 5 seconds
        time.sleep(TRANSMISSION_INTERVAL)


if __name__ == "__main__":
    main()