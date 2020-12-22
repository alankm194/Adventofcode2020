package com.alan.adventofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
You board your plane only to discover a new problem: you dropped your boarding pass! You aren't sure which seat is yours, and all of the flight attendants are busy with the flood of people that suddenly made it through passport control.

You write a quick program to use your phone's camera to scan all of the nearby boarding passes (your puzzle input); perhaps you can find your seat through process of elimination.

Instead of zones or groups, this airline uses binary space partitioning to seat people. A seat might be specified like FBFBBFFRLR, where F means "front", B means "back", L means "left", and R means "right".

The first 7 characters will either be F or B; these specify exactly one of the 128 rows on the plane (numbered 0 through 127). Each letter tells you which half of a region the given seat is in. Start with the whole list of rows; the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). The next letter indicates which half of that region the seat is in, and so on until you're left with exactly one row.

For example, consider just the first seven characters of FBFBBFFRLR:

    Start by considering the whole range, rows 0 through 127.
    F means to take the lower half, keeping rows 0 through 63.
    B means to take the upper half, keeping rows 32 through 63.
    F means to take the lower half, keeping rows 32 through 47.
    B means to take the upper half, keeping rows 40 through 47.
    B keeps rows 44 through 47.
    F keeps rows 44 through 45.
    The final F keeps the lower of the two, row 44.

The last three characters will be either L or R; these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). The same process as above proceeds again, this time with only three steps. L means to keep the lower half, while R means to keep the upper half.

For example, consider just the last 3 characters of FBFBBFFRLR:

    Start by considering the whole range, columns 0 through 7.
    R means to take the upper half, keeping columns 4 through 7.
    L means to take the lower half, keeping columns 4 through 5.
    The final R keeps the upper of the two, column 5.

So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.

Every seat also has a unique seat ID: multiply the row by 8, then add the column. In this example, the seat has ID 44 * 8 + 5 = 357.

Here are some other boarding passes:

    BFFFBBFRRR: row 70, column 7, seat ID 567.
    FFFBBBFRRR: row 14, column 7, seat ID 119.
    BBFFBBFRLL: row 102, column 4, seat ID 820.

As a sanity check, look through your list of boarding passes. What is the highest seat ID on a boarding pass?

Your puzzle answer was 955.
--- Part Two ---

Ding! The "fasten seat belt" signs have turned on. Time to find your seat.

It's a completely full flight, so your seat should be the only missing boarding pass in your list. However, there's a catch: some of the seats at the very front and back of the plane don't exist on this aircraft, so they'll be missing from your list as well.

Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.

What is the ID of your seat?

 */
public class Day5 {


    private int BOARDINGPASS_ROW = 7;
    private int BOARDINGPASS_SEAT = 10;

    private int TOTAL_ROWS = 128;
    private int TOTAL_SEAT = 8;

    public int findPuzzleAnswer1(List<String> boardingPasses) {
        int maxSeatId = 0;
        List<Integer> list = new ArrayList<>();
        for (String pass: boardingPasses) {
            int seatId = findSeatRow(pass) * 8 + findSeat(pass);
            maxSeatId = seatId > maxSeatId ? seatId : maxSeatId;
            list.add(seatId);
        }
        return maxSeatId;
    }

    public int findPuzzleAnswer2(List<String> boardingPasses) {
        List<Integer> listOfSeatIds = new ArrayList<>();
        for (String pass: boardingPasses) {
            int seatId = findSeatRow(pass) * 8 + findSeat(pass);
            listOfSeatIds.add(seatId);
        }
        Collections.sort(listOfSeatIds);
        int current = -1;
        for (int i=1; i < listOfSeatIds.size()-1; i++) {
            current = listOfSeatIds.get(i);
            boolean neighbourAhead = listOfSeatIds.get(i+1) - current == 1;
            boolean neighbourBehind = current -  listOfSeatIds.get(i-1) == 1;

            if (!neighbourAhead ) {
                current += 1;
                break;
            } else if (!neighbourBehind) {
                current -= 1;
                break;
            }
        }
        return current;
    }


    private int findSeat(String boardingPass) {
        int maxPossibleSeat = TOTAL_SEAT - 1;
        int minPossibleSeat = 0;
        for (int i = BOARDINGPASS_ROW; i < BOARDINGPASS_SEAT; i++) {
            if (boardingPass.charAt(i) == 'L') {
                maxPossibleSeat = (maxPossibleSeat + minPossibleSeat) / 2;
            } else if (boardingPass.charAt(i) == 'R') {
                minPossibleSeat = ((maxPossibleSeat + minPossibleSeat) / 2) + 1;
            }
        }
        return maxPossibleSeat;
    }

    private int findSeatRow(String boardingPass) {
        int maxPossibleRow = TOTAL_ROWS - 1;
        int minPossibleRow = 0;
        int row = 0;
        for (int i = 0; i < BOARDINGPASS_ROW; i++) {
            if (boardingPass.charAt(i) == 'F') {
                maxPossibleRow = (maxPossibleRow + minPossibleRow) / 2;
            } else if (boardingPass.charAt(i) == 'B') {
                minPossibleRow = ((maxPossibleRow + minPossibleRow) / 2) + 1;
            }

        }
        return maxPossibleRow;
    }

}
