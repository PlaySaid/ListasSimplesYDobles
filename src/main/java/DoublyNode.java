public class DoublyNode<T> {
    T value;
    DoublyNode<T> next;
    DoublyNode<T> prev;

    DoublyNode(T value) {
        this.value = value;
    }
}
