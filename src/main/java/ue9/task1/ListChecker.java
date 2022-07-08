package ue9.task1;

/**
 * Helper object running Action Objects,
 * so that it can be non-static and
 * not part of the List class
 */
public class ListChecker {
    /**
     * Prints out whether a list contains an integer-element 0
     * @param list list on which a zero-element is searched
     */
    public void showContainsZero(List list) {
        ContainsZeroAction containsZeroAction = new ContainsZeroAction();
        list.traverseAndApply(containsZeroAction);
        System.out.println(containsZeroAction.getContainsZero());
    }

    /**
     * Prints out the sum of all positive integers in the list
     * @param list list on which the sum of positive ints is calculated
     */
    public void showPosSum(List list) {
        PosSumAction posSumAction = new PosSumAction();
        list.traverseAndApply(posSumAction);
        System.out.println(posSumAction.getSumOfPositiveInts());
    }
}
