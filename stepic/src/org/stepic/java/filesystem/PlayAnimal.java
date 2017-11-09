package org.stepic.java.filesystem;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * Created by dimon on 28.08.17.
 */
public class PlayAnimal {
    private static final Logger LOGGER = Logger.getLogger(PlayAnimal.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(new ConsoleHandler());
        Animal[] animals = { new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
                new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
                new Animal("Tentecles"), new Animal("Worm")};

        Path path = Paths.get("/home/dimon/animals.txt");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {
            oos.writeInt(animals.length);
            LOGGER.info("written " + animals.length + " to file");
            for (Animal animal : animals) {
                oos.writeObject(animal);
            }
        }

        Animal[] deserializedAnimals = deserializeAnimalArray(byteArrayOutputStream.toByteArray());
        for(Animal animal : deserializedAnimals) {
            System.out.println(animal.getName());
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals;
        int n_animals = 0;

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(inputStream)) {
            LOGGER.info("try to read int");
            n_animals = ois.readInt();
            LOGGER.info(n_animals + " animal(s) will be read");
            animals = new Animal[n_animals];
            for(int i=0; i<n_animals; ++i) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return animals;
    }
}
