package org.stepic.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dimon on 29.08.17.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = getInputArrayFromStdin();
        int pos = list.size();
        pos -= (pos % 2 == 0 ? 1 : 2);
        for(int i=pos; i>=0; i-=2) {
            System.out.print(list.get(i) + " ");
        }
    }


    public static List<Integer> getInputArrayFromStdin() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        return list;
    }
}
