# Lightsaber Lost (Iterative Searching & Sorting Assignment)

## Overview
This project is a searching-and-sorting-based assignment developed for CS121: Introduction to Computer Science.

Students are asked to implement a series of methods to help Jedi Padawan Ahsoka Tano rebuild a corrupted Jedi Archive and use it to identify the owner of a lost lightsaber, inspired by the Star Wars universe:
* **Rebuild the Archive**: parse scattered records from a CSV file back into a structured list of Jedi.
* **Sort by Color**: use insertion sort to alphabetically group Jedi by their lightsaber color.
* **Search by Color**: use binary search to isolate the range of Jedi matching a given lightsaber color.
* **Sort by Hilt**: debug a broken selection sort algorithm to correctly sort a narrowed-down group by hilt material.
* **Find the Owner**: use binary search on the sorted group to identify the exact Jedi matching both color and hilt clues.

Students must implement iterative searching and sorting algorithms, debug an intentionally flawed sort using breakpoints, and apply these techniques to a real-world-style lookup problem.

I created this assignment as part of an undergraduate course-development program, where students help build assignments for introductory computer science courses.

**Note**: This repository intentionally contains starter code only (with // write your code here placeholders) to comply with academic integrity policies. The solution to the assignment is not posted in order to avoid academic integrity violations from students taking this course. However, descriptions and examples of the assignment are provided in this documentation.

## Technologies
* Java
* Java Swing (GUI)
* Iterative Searching (Binary Search)
* Iterative Sorting (Insertion Sort, Selection Sort)
* ArrayLists & Arrays
* Debugging with Breakpoints
* File Input Handling (CSV parsing)

## Features
* Reads Jedi records from a CSV file into an `ArrayList<Jedi>`
* Sorts the archive alphabetically by lightsaber color using insertion sort
* Uses binary search to locate the start and end indices of a matching color group
* Provides an intentionally buggy selection sort (`sortByHilt`) for students to debug and fix
* Uses binary search again to pinpoint the exact owner by hilt material
* Full **Java Swing GUI driver** (`Driver.java`) that visualizes each step of the assignment:
  * NetID-seeded random clue generation (unique color + hilt combination per student)
  * Sequential, gated buttons for each method (`rebuildArchive` → `sortByColor` → `extractColor` → `sortByHilt` → `findOwner`), with warning dialogs if a step is skipped out of order
  * Dropdown menus for selecting input files, lightsaber colors, and hilt materials
  * Dynamic image grid rendering each Jedi's lightsaber icon and hilt label
  * Final "owner found" panel displaying the matched Jedi's portrait, name, age, and homeworld
  * Built-in instructions dialog explaining how to use the driver
 
## Archive Record Format
Each line in the CSV archive files is formatted as:
```
name, age, homeworld, lightsaberColor, lightsaberHilt, imageFilename
```
 
**Lightsaber Colors:** blue, green, purple, white, yellow (sorted in this order)

## Academic Integrity
This repository is intended for professional reference only. Students are expected to complete the implementation based on the description from the official course materials.
