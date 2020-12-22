package com.alan.adventofcode;

import com.alan.common.ReadPuzzleInputFiles;

import java.util.List;

public class main {

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        String fileName = day1.getClass().getClassLoader().getResource("day1input.txt").getFile();
        List<Integer> puzzleInput = ReadPuzzleInputFiles.getListOfIntsFromFile(fileName);
        System.out.println("Day 1 part 1 answer: " + day1.findPuzzleAnswer1(puzzleInput));
        System.out.println("Day 1 part 2 answer: "  + day1.findPuzzleAnswer2(puzzleInput));

        Day2 day2 = new Day2();
        String fileName2 = day2.getClass().getClassLoader().getResource("day2input.txt").getFile();
        List<String> puzzleInput2 = ReadPuzzleInputFiles.getListOfStringFromFile(fileName2);
        System.out.println("Day 2 part 1 answer: " +day2.puzzle1(puzzleInput2));
        System.out.println("Day 2 part 2 answer: " +day2.puzzle2(puzzleInput2));

        Day3 day3= new Day3();
        String fileName3 = day3.getClass().getClassLoader().getResource("day3input.txt").getFile();
        List<char[]> puzzleInput3 = ReadPuzzleInputFiles.getListOfCharArrayFromFile(fileName3);
        System.out.println("Day 3 part 1 answer: " +day3.findPuzzleAnswer1(puzzleInput3));
        System.out.println("Day 3 part 2 answer: " +day3.findPuzzleAnswer2(puzzleInput3));


    }
}
