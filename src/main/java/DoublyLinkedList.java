public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size;

    public void addFirst(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        DoublyNode<T> newNode = new DoublyNode<>(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("Lista vacía");
        T val = head.value;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return val;
    }

    public T removeLast() {
        if (tail == null) throw new RuntimeException("Lista vacía");
        T val = tail.value;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return val;
    }

    public void addBefore(DoublyNode<T> node, T value) {
        if (node == null) throw new IllegalArgumentException("Nodo inválido");
        DoublyNode<T> newNode = new DoublyNode<>(value);
        newNode.next = node;
        newNode.prev = node.prev;
        if (node.prev != null) node.prev.next = newNode;
        else head = newNode;
        node.prev = newNode;
        size++;
    }

    public void addAfter(DoublyNode<T> node, T value) {
        if (node == null) throw new IllegalArgumentException("Nodo inválido");
        DoublyNode<T> newNode = new DoublyNode<>(value);
        newNode.prev = node;
        newNode.next = node.next;
        if (node.next != null) node.next.prev = newNode;
        else tail = newNode;
        node.next = newNode;
        size++;
    }

    public T remove(DoublyNode<T> node) {
        if (node == null) throw new IllegalArgumentException("Nodo inválido");
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;
        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
        size--;
        return node.value;
    }

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void printListForward() {
        DoublyNode<T> current = head;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printListBackward() {
        DoublyNode<T> current = tail;
        while (current != null) {
            System.out.print(current.value + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
