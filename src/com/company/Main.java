
package com.company;

import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person() {{
            Age = 20;
            Birthday = new Date().getTime();
            Firstname = "Tester";
            Lastname = "Testowy";
        }};

        Person p2;

        try {

            long size1 = Serialization(p1);
            long size2 = Externalization(p1);

            System.out.println("Seriazliation size: " + size1);
            System.out.println("Externalization size: " + size2);


        } catch (Exception ex) {

        }
    }

    private static long Externalization(Person p1) throws IOException {
        FileOutputStream fos1 = new FileOutputStream("tempdata.ext");
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        System.out.println("Before externalization: \n" + p1.toString());
        System.out.println("externaliziing");
        p1.writeExternal(oos1);
        oos1.close();

        System.out.println("dextrenralizing");

        FileInputStream fis1 = new FileInputStream("tempdata.ext");
        ObjectInputStream ois1 = new ObjectInputStream(fis1);

        p1.readExternal(ois1);

        System.out.println("after dexternalizing");

        System.out.println(p1.toString());
        File file = new File("tempdata.ext");
        long lenght = file.length();
        new File("tempdata.ext").delete();
        return lenght;
    }

    private static long Serialization(Person p1) throws IOException, ClassNotFoundException {
        Person p2;
        System.out.println("Before serialization: \n" + p1.toString());

        FileOutputStream fos = new FileOutputStream("tempdata.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.println("serializing");
        oos.writeObject(p1);
        oos.close();

        System.out.println("deserializing");

        FileInputStream fis = new FileInputStream("tempdata.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        p2 = (Person) ois.readObject();
        ois.close();

        System.out.println("after deserialization");

        System.out.println(p2.toString());
        File file = new File("tempdata.ser");
        long lenght = file.length();
        new File("tempdata.ser").delete();
        return lenght;

    }
}
