package containers;

import net.mindview.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBehavior {
    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (var i = 0; i < count; i++)
            queue.offer(gen.next());
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four fix six seven " + "eight night ten").split(" ");
        int i;

        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args){
        test(new LinkedList<>(),new Gen());
        test(new PriorityQueue<>(),new Gen());
        test(new ArrayBlockingQueue<>(count),new Gen());
        test(new ConcurrentLinkedDeque<>(),new Gen());
        test(new LinkedBlockingQueue<>(),new Gen());
        test(new PriorityBlockingQueue<>(),new Gen());
    }
}
