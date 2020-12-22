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

        Day4 day4= new Day4();
        String fileName4 = day4.getClass().getClassLoader().getResource("day4input.txt").getFile();
        System.out.println("Day 4 part 1 answer: " + day4.findPuzzleAnswer1(fileName4));
        System.out.println("Day 4 part 2 answer: " + day4.findPuzzleAnswer2(fileName4));

        Day5 day5= new Day5();
        String fileName5 = day5.getClass().getClassLoader().getResource("day5input.txt").getFile();
        List<String> puzzleInput5 = ReadPuzzleInputFiles.getListOfStringFromFile(fileName5);
        System.out.println("Day 5 part 1 answer: " + day5.findPuzzleAnswer1(puzzleInput5));
        System.out.println("Day 5 part 2 answer: " + day5.findPuzzleAnswer2(puzzleInput5));


        Day6 day6= new Day6();
        String fileName6 = day6.getClass().getClassLoader().getResource("day6input.txt").getFile();
        System.out.println("Day 6 part 1 answer: " + day6.findPuzzleAnswer1(fileName6));
        System.out.println("Day 6 part 2 answer: " + day6.findPuzzleAnswer2(fileName6));
    }
}
