package ue9.task1;

class PosSumAction implements ActionObject {

    private int sumOfPositiveInts = 0;

    public void action(Node n) {
        if (n.data instanceof Integer) {
            @SuppressWarnings("WrapperTypeMayBePrimitive") Integer number = (Integer)n.data;
            if (number > 0){
                sumOfPositiveInts += number;
            }
        }
    }

    public int getSumOfPositiveInts() {
        return sumOfPositiveInts;
    }
}