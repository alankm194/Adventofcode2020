package com.alan.adventofcode;

/*
Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456

In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?

--- Part Two ---

The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?


*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    private static final int TARGET = 2020;

    public int findPuzzleAnswer1(List<Integer> input) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Integer puzzleAnswer = -1;
        for (Integer i : input) {
            if (numMap.containsKey(i)) {
                puzzleAnswer = numMap.get(i) * i;
                break;
            }
            numMap.put(TARGET - i, i);
        }
        return puzzleAnswer;
    }

    public int findPuzzleAnswer2(List<Integer> input) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> numMap2 = new HashMap<>();

        Integer puzzleAnswer = -1;
        for (Integer i : input) {
            numMap.put(TARGET - i, i);
        }

        outerloop:
        for (Integer j : numMap.keySet()) {
            for (Integer i : input) {
                if (numMap2.containsKey(i)) {
                    puzzleAnswer = numMap.get(j) * i * numMap2.get(i);
                    break outerloop;
                }
                numMap2.put(j - i, i);
            }
        }

        return puzzleAnswer;
    }


}
