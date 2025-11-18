package domain.entity;

public class DoublyNode<T> {
    public T value;
    public DoublyNode<T> next;
    public DoublyNode<T> prev;

    public DoublyNode(T value) {
        this.value = value;
    }
}
