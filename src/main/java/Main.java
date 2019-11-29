import utils.LinkedList;

/**
 * Main class.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(3);
        System.out.println("Should be 2, result is : " + list.at(1));
        System.out.println("Should be 2, result is : " + list.getFirstElementPosition(3));
        System.out.println("Should be 4, result is : " + list.getLastElementPosition(3));
        System.out.println("Should be 1, result is : " + list.remove(0));
        System.out.println("Should be 2, result is : " + list.at(0));
        System.out.println("Should be 4, result is : " + list.size());
        list.insert(42, 3);
        System.out.println("Should be 42, result is : " + list.at(3));
    }
}
