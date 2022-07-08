package ue9.task2;

public class TestClass {
    public static void main(String[] args) {
        WSchlange queue1 = new WSchlange(1,"a",3.0,2,3);
        queue1.add("text");
        queue1.add(1234);
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll().toString());
        }

        System.out.println("---------");

        Schlange<Double> queue2 = new Schlange<Double>(1.0,2.0,3.0);
        queue2.enqueue(3.14);
        queue2.enqueue(10.0);
        while (!queue2.isEmpty()) {
            System.out.println(queue2.dequeue().toString());
        }

        System.out.println("---------");

        Schlange<String> queue3 = new Schlange<String>("j","en","a");
        queue3.enqueue("f");
        queue3.enqueue("su");
        while (!queue3.isEmpty()) {
            System.out.println(queue3.dequeue().toString());
        }
    }
}
