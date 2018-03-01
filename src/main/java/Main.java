import reversed_list.ReversedList;

public class Main {
    public static void main(String[] args) {
        ReversedList<Integer> reversedList = new ReversedList<Integer>();
        reversedList.add(1);
        reversedList.add(2);
        reversedList.add(3);
        reversedList.add(4);
        reversedList.removeAt(0);
        System.out.println();
    }
}
