package com.alan.adventofcode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
As your flight approaches the regional airport where you'll switch to a much larger plane, customs declaration forms are distributed to the passengers.

The form asks a series of 26 yes-or-no questions marked a through z. All you need to do is identify the questions for which anyone in your group answers "yes". Since your group is just you, this doesn't take very long.

However, the person sitting next to you seems to be experiencing a language barrier and asks if you can help. For each of the people in their group, you write down the questions for which they answer "yes", one per line. For example:

abcx
abcy
abcz

In this group, there are 6 questions to which anyone answered "yes": a, b, c, x, y, and z. (Duplicate answers to the same question don't count extra; each question counts at most once.)

Another group asks for your help, then another, and eventually you've collected answers from every group on the plane (your puzzle input). Each group's answers are separated by a blank line, and within each group, each person's answers are on a single line. For example:

abc

a
b
c

ab
ac

a
a
a
a

b

This list represents answers from five groups:

    The first group contains one person who answered "yes" to 3 questions: a, b, and c.
    The second group contains three people; combined, they answered "yes" to 3 questions: a, b, and c.
    The third group contains two people; combined, they answered "yes" to 3 questions: a, b, and c.
    The fourth group contains four people; combined, they answered "yes" to only 1 question, a.
    The last group contains one person who answered "yes" to only 1 question, b.

In this example, the sum of these counts is 3 + 3 + 3 + 1 + 1 = 11.

For each group, count the number of questions to which anyone answered "yes". What is the sum of those counts?

Your puzzle answer was 6297.
--- Part Two ---

As you finish the last group's customs declaration, you notice that you misread one word in the instructions:

You don't need to identify the questions to which anyone answered "yes"; you need to identify the questions to which everyone answered "yes"!

Using the same example as above:

abc

a
b
c

ab
ac

a
a
a
a

b

This list represents answers from five groups:

    In the first group, everyone (all 1 person) answered "yes" to 3 questions: a, b, and c.
    In the second group, there is no question to which everyone answered "yes".
    In the third group, everyone answered yes to only 1 question, a. Since some people did not answer "yes" to b or c, they don't count.
    In the fourth group, everyone answered yes to only 1 question, a.
    In the fifth group, everyone (all 1 person) answered "yes" to 1 question, b.

In this example, the sum of these counts is 3 + 0 + 1 + 1 + 1 = 6.

For each group, count the number of questions to which everyone answered "yes". What is the sum of those counts?

 */
public class Day6 {

    public int findPuzzleAnswer2(String fileName) {
        int total = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = in.readLine()) != null) {
                if (!str.equals("")) {
                    sb.append(str + " ");
                } else if (sb.length() > 0) {
                    total = total += parseAnswerForEveryoneInGroupThatSaidYes(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                total = total += parseAnswerForEveryoneInGroupThatSaidYes(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;

    }

    public int findPuzzleAnswer1(String fileName) {
        int total = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = in.readLine()) != null) {
                if (!str.equals("")) {
                    sb.append(str + " ");
                } else if (sb.length() > 0) {
                    total = total += parseAnswersForAllUniqueQuestions(sb.toString());
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                total = total += parseAnswersForAllUniqueQuestions(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total;

    }

    private long parseAnswerForEveryoneInGroupThatSaidYes(String answers) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        String[] answersArray = answers.split(" ");
        for (String answerLine : answersArray) {
            for (int i=0; i < answerLine.length(); i++) {
                charCountMap.computeIfPresent(answerLine.charAt(i), (key, val) -> val+=1);
                charCountMap.computeIfAbsent(answerLine.charAt(i), (key) -> (1));
            }
        }

        long total = charCountMap.values()
                .stream()
                .filter(integer -> integer == answersArray.length)
                .count();

        return total;
    }


    private int parseAnswersForAllUniqueQuestions(String answers) {
        Set<Character> charSet = new HashSet<>();
        char[] charArray = answers.replace(" ", "").toCharArray();
        for (char ch: charArray) {
            charSet.add(ch);
        }
        return charSet.size();
    }
}
