class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new RuntimeException("Lista vacía");
        T val = head.value;
        head = head.next;
        size--;
        return val;
    }

    public T removeLast() {
        if (head == null) throw new RuntimeException("Lista vacía");
        if (head.next == null) {
            T val = head.value;
            head = null;
            size--;
            return val;
        }
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T val = current.next.value;
        current.next = null;
        size--;
        return val;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) return true;
            current = current.next;
        }
        return false;
    }

    public void insertAt(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) return removeFirst();
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T val = current.next.value;
        current.next = current.next.next;
        size--;
        return val;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
