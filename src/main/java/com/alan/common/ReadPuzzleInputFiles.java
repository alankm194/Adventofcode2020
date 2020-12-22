package com.alan.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadPuzzleInputFiles {

    public static List<Integer> getListOfIntsFromFile(String file) {
        List<Integer> puzzleInput = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = in.readLine()) != null) {
                puzzleInput.add(Integer.parseInt(str));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return puzzleInput;
    }

    public static List<String> getListOfStringFromFile(String file) {
        List<String> puzzleInput = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String str;
            while ((str = in.readLine()) != null) {
                puzzleInput.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return puzzleInput;
    }

    public static List<char[]> getListOfCharArrayFromFile(String file) {
        List<char[]> puzzleInput = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))){
            String str;
            while ((str = in.readLine()) != null) {
                puzzleInput.add(str.toCharArray());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puzzleInput;
    }

}
