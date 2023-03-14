# La tondeuse
This repository contains a Java program that implements an automatic lawn mower, designed for rectangular surfaces. The lawn mower can be programmed to traverse the entire surface. The position of the lawn mower is represented by a combination of coordinates (x, y) and a letter indicating the orientation according to the English cardinal notation (N, E, W, S). The lawn is divided into a grid to simplify navigation.

# How to Use
To use the program, you need to provide an input file with the following format:

The first line corresponds to the coordinates of the top right corner of the lawn, and the bottom left corner is assumed to be (0,0).
The rest of the file is used to control all the lawn mowers that have been deployed. Each lawn mower has two lines:
The first line gives the initial position and orientation of the lawn mower. The position and orientation are provided in the form of 2 digits and a letter, separated by a space.
The second line is a series of instructions ordering the lawn mower to explore the lawn. The instructions are a sequence of characters without spaces.
Each lawn mower moves sequentially, which means that the second lawn mower only moves when the first has fully executed its set of instructions. When a lawn mower completes a set of instructions, it communicates its position and orientation.

# Input File Example
5 5

1 2 N

GAGAGAGAA

3 3 E

AADAADADDA

# Expected Output
Running the program with the above input file should result in the following output:

1 3 N

5 1 E

# Requirements
To run the program, you need to have Java installed on your computer. You can compile and run the program using the following command:

javac LaTondeuse.java
java LaTondeuse input.txt

Where input.txt is the name of the input file you want to use.
