------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Tool Hire Shop & Reservation System

PURPOSE OF PROJECT: A Java application modelling a shop that hires out tools and equipment to registered customers. The system manages a catalogue of shop items (tools, accessories, and their subtypes such as electric tools and hand tools), a customer database with uniquely generated customer IDs, and a reservation system that lets a customer hire an item for a specified number of days, with date handling and diary/booking management built in.

The project was built up incrementally across four stages, progressively introducing:

Core Tool and Shop classes, with data read from text files
Inheritance and polymorphism via ElectricTool and HandTool subclasses
A Customer class with unique ID generation and persistent storage
A ShopItemReservation system with date utilities and a Diary class

VERSION or DATE: February 2026

HOW TO START THIS PROJECT: This project was developed in BlueJ. To run it:

Clone or download this repository.
Open the folder as a BlueJ project (or import the .java files into your preferred Java IDE).
Compile all classes.
Run the Test class (or your preferred entry point) to see sample usage and test cases.
When prompted, use the file dialog to select the relevant data file (e.g. tool_data.txt or customer_data.txt).

AUTHORS: Maha Zeb

USER INSTRUCTIONS:

Data files (tool and customer data) are read in via a file dialog box at runtime — no file paths are hard-coded.
Shop items and customers are stored using unique identifiers (itemCode / customerID) to allow reliable lookup and reservation.
Reservations can be made by specifying a customer, an item, a start date, and a number of days; reservation numbers are generated automatically.
See the Test class for examples of how each part of the system is exercised.