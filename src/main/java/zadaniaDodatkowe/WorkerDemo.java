package zadaniaDodatkowe;

import java.util.ArrayList;
import java.util.List;

public class WorkerDemo {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        Worker worker1 = new Worker("Anna", "Tkaczyk", 25, Post.ANALITYK, 2500, 5, 150);
        Worker worker2 = new Worker("Jacek", "Kowalczyk", 26, Post.ADMINISTRATOR, 3500, 4, 500);
        Worker worker3 = new Worker("Pawel", "Kowalski", 24, Post.MANADZER, 3000, 5, 250);
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.stream().filter(worker -> worker.getAge() < 45 && worker.getMark() > 4 && worker.getEnd_bonus() < 1500).forEach(System.out::println);
    }
}
