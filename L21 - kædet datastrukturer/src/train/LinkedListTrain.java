package train;

import org.w3c.dom.Node;

import java.util.NoSuchElementException;

public class LinkedListTrain {
    private WagonNode firstWagon;

    /**
     * Constructs an empty linked list train.
     */
    public LinkedListTrain() {
        this.firstWagon = null;
    }

    /**
     * Returns the first wagon node in the linked list train.
     *
     * @return the first wagon node
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode getFirst() {
        if (this.firstWagon == null) {
            throw new NoSuchElementException();
        }
        return this.firstWagon;
    }

    /**
     * Adds a wagon node to the front of the linked list train.
     *
     * @param wagon the wagon node to add
     */
    public void addFirst(WagonNode wagon) {
        //  Assignment 1
        wagon.setNextWagon(firstWagon);
        firstWagon = wagon;
    }

    /**
     * Removes the first wagon node in the linked list train.
     *
     * @return the removed wagon node
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode removeFirst() {
        // Assignment 2
        if (firstWagon == null) {
            throw new NoSuchElementException();
        }
        WagonNode wagon = firstWagon;
        firstWagon = firstWagon.getNextWagon();
        //connection between temp wagon to the next wagon in line is removed by setting wagons
        //new next wagon to null, hereby deleting the connection.
        //this makes it less heavy on bigger systems and makes the garbagecollector collect
        //redundant data
        wagon.setNextWagon(null);
        return wagon;

    }

    /**
     * Counts the total number of wagon nodes in the linked list train.
     *
     * @return the number of wagon nodes
     */
    public int count() {
        // TODO: Assignment 3: Implement this count method...
        int count = 0;
        WagonNode temp = firstWagon;

        while (temp != null) {
            count++;
            temp = temp.getNextWagon();
        }

        return count;

    }

    /**
     * Removes the first wagon node in the linked list train.
     *
     * @param wagon the wagon node to remove
     * @return <code>true</code> if the wagon node was found and removed;
     * <code>false</code> otherwise
     */
    public boolean remove(WagonNode wagon) {
        boolean found = false;
        // TODO: Assignment 4: Implement this remove method...
        WagonNode temp = firstWagon;
        WagonNode temp1 = firstWagon.getNextWagon();
        while (!found && temp != null) {


            if (temp == wagon) {
                System.out.println(temp.getWagonName());
                System.out.println(temp1.getWagonName());



                found = true;
            } else
                temp = temp.getNextWagon();
        }


//        while (!found&&firstWagon!=null){
//            WagonNode temp = firstWagon.getNextWagon();
//            if (wagon==firstWagon||temp == wagon){
//                firstWagon.setPreviousWagon(firstWagon.getNextWagon());
//                found = true;
//            }
//
//        }
        return found;
    }

    /**
     * Inserts a wagon node at a given position in the linked list train.
     *
     * @param wagon    the wagon node to add
     * @param position the position where to add the wagon node
     */
    public void insertAt(WagonNode wagon, int position) {
        // TODO: Assignment 5: Implement this insert method...

        throw new UnsupportedOperationException("Not implemented");
    }
}
