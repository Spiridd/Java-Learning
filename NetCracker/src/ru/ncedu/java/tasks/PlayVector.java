package ru.ncedu.java.tasks;

/**
 * Created by dimon on 18.08.17.
 */
public class PlayVector {
    public static void main(String[] args) {
        ArrayVectorImpl arrayVector = new ArrayVectorImpl();
        arrayVector.set(10, 9, 8, 6, 7);

        for(int i=0; i<arrayVector.getSize(); ++i) {
            System.out.print(arrayVector.get(i) + " ");
        }
        System.out.println();

        arrayVector.sortAscending();

        for(int i=0; i<arrayVector.getSize(); ++i) {
            System.out.print(arrayVector.get(i) + " ");
        }
        System.out.println();

        System.out.println(arrayVector.getNorm());

        arrayVector.set(12, 100);
        for(int i=0; i<arrayVector.getSize(); ++i) {
            System.out.print(arrayVector.get(i) + " ");
        }
        System.out.println();
    }
}
