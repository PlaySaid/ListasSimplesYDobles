import java.util.LinkedList;

public class HistorialSimple {
    private LinkedList<String> lista = new LinkedList<>();

    public void addFirst(String valor) { lista.addFirst(valor); }
    public void addLast(String valor) { lista.addLast(valor); }
    public String removeFirst() { return lista.removeFirst(); }
    public String removeLast() { return lista.removeLast(); }
    public String get(int index) { return lista.get(index); }
    public boolean isEmpty() { return lista.isEmpty(); }
    public int size() { return lista.size(); }
    public void clear() { lista.clear(); }

    public void printList() {
        for (String s : lista) System.out.print(s + " -> ");
        System.out.println("null");
    }
}
