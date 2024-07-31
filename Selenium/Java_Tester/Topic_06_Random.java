package Java_Tester;

import java.util.Random;

public class Topic_06_Random {
    //Java Bullitin (Cung cap san-lay ra su dung
    //Java Libraries (Do 1 ca nhan/to chuc ho tu viet)
    public static void main (String[] args){
        Random rand = new Random();
        System.out.println(rand.nextInt());
        System.out.println(rand.nextInt());

        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextBoolean());

        System.out.println("automation" + rand.nextInt(99999)+ "gmail.net");
        System.out.println("automation" + rand.nextInt(99999)+ "gmail.net");
        System.out.println("automation" + rand.nextInt(99999)+ "gmail.net");
        System.out.println("automation" + rand.nextInt(99999)+ "gmail.net");
    }
}
