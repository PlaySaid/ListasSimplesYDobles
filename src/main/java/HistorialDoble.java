import java.util.LinkedList;
import java.util.ListIterator;

public class HistorialDoble {
    private LinkedList<String> lista = new LinkedList<>();

    public void addFirst(String valor) { lista.addFirst(valor); }
    public void addLast(String valor) { lista.addLast(valor); }
    public String removeFirst() { return lista.removeFirst(); }
    public String removeLast() { return lista.removeLast(); }
    public boolean isEmpty() { return lista.isEmpty(); }
    public int size() { return lista.size(); }
    public void clear() { lista.clear(); }

    public void printListForward() {
        for (String s : lista) System.out.print(s + " <-> ");
        System.out.println("null");
    }

    public void printListBackward() {
        ListIterator<String> it = lista.listIterator(lista.size());
        while (it.hasPrevious()) System.out.print(it.previous() + " <-> ");
        System.out.println("null");
    }
}
