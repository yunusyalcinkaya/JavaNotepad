import java.util.*;

public class QueueDriver {

    public static void linkedList(){
        Queue<Integer> queue = new LinkedList<>();

        // add() metodu ile de ekleme yapılabilir
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(30);
        queue.offer(null);

        System.out.println("size: " + queue.size());
        System.out.println("peek: " + queue.peek());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove(30));
        System.out.println("kalan queue: " + queue.toString());

        while (!queue.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + queue.poll());
        }

        /*
        ? Kuyruğa eleman eklemek için kullanılan "add()" ve "offer()" metodları arasındaki fark:
        ?   ekleme işlemi başarısız olursa(add(index,item) -> index doesn't exist) add() metodu
        ?   exception fırlatırken offer() metodu false değer döner.

        ? Kuyruktan eleman çıkarmak için kullanılan "poll()" ve "remove()" metodları arasındaki fark da aynıdır.
        ?   Kuyrukta eleman yoksa remmove metodu exception fırlatır, poll() metodu null değer döner.
         */
    }

    public static void arrayDequeue(){
        Queue<Integer> queue = new ArrayDeque<>();

        // Elemanları ekleyelim
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(30);

        System.out.println(System.lineSeparator());
        System.out.println("size: " + queue.size());
        System.out.println("peek: " + queue.peek());
        System.out.println("remove: " + queue.remove());
        System.out.println("remove: " + queue.remove(30));
        System.out.println("kalan queue: " + queue.toString());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(10);
        deque.addFirst(20);
        deque.addLast(30);
        deque.add(40);

        System.out.println(System.lineSeparator());
        System.out.println("deque: " + deque.toString());

        deque.remove();
        System.out.println("kalan deque: " + deque.toString());
        deque.remove(30);
        deque.removeFirst();
        deque.removeLast();

        /*
        ? Queue yapısı doğrudan ArrayDeque referansı ile oluşturulursa, çift yönlü bir queue gibi davranır,
        ?   baştan ve sondan eleman eklenebilir ve çıkarılabilir.
         */
    }

    public static void priorityQueueMinHeap(){
        // Min-Heap oluşturma
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Elemanları ekleyelim
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        minHeap.add(5);

        // En yüksek öncelikli elemanı alalım (minHeap olduğu için en küçüğü alır)
        int highestPriority = minHeap.poll();
        System.out.println("En yüksek öncelikli eleman: " + highestPriority);

        // Kuyruğun mevcut hali
        System.out.println("Kuyruk: " + minHeap);
    }

    public static void PriorityQueueMaxHeap(){
        // Max-Heap oluşturma (Büyükten küçüğe sıralama)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Elemanları ekleyelim
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(5);

        // En yüksek öncelikli elemanı alalım (maxHeap olduğu için en büyüğü alır)
        int highestPriority = maxHeap.poll();
        System.out.println("En yüksek öncelikli eleman: " + highestPriority);

        // Kuyruğun mevcut hali
        System.out.println("Kuyruk: " + maxHeap);
    }

    public static void priorityQueueCustomOrder(){
        // Öğrencileri notlarına göre öncelikli olarak sıralayan PriorityQueue
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(Comparator.comparingInt(s -> s.grade));
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> list = map.get(110);

        list.add(12);

        // Öğrencileri ekleyelim
        studentQueue.add(new Student("Ahmet", 90));
        studentQueue.add(new Student("Mehmet", 80));
        studentQueue.add(new Student("Ayşe", 95));

        // En yüksek öncelikli öğrenciyi alalım
        Student highestPriorityStudent = studentQueue.poll();
        System.out.println("En yüksek öncelikli öğrenci: " + highestPriorityStudent.name);

        // Kuyruğun mevcut hali
        System.out.println("Kuyruk: " + studentQueue);
    }



    public static void main(String[] args) {
        linkedList();
        arrayDequeue();
    }
}

class Student {
    String name;
    int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}