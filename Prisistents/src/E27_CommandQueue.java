import java.util.LinkedList;
import java.util.Queue;

import static ms.util.Println.*;

public class E27_CommandQueue {
    public static void main(String[] args){
        Queue<Command> cmds = new LinkedList<>();
        Producer.produce(cmds);
        Consumer.consume(cmds);
    }
}

class Command{
    private final String cmd;
    Command(String cmd){this.cmd = cmd;}
    public void operation(){
        print(cmd);
    }
}

class Producer{
    public static void produce(Queue<Command> q){
        q.offer(new Command("load"));
        q.offer(new Command("delete"));
        q.offer(new Command("save"));
        q.offer(new Command("exit"));
    }
}

class Consumer{
    public static void consume(Queue<Command> q){
        while (q.peek() != null)
            q.remove().operation();
    }
}
