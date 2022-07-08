package ue9.task1;

class ContainsZeroAction implements ActionObject {

    private Boolean containsZero = false;

    public void action (Node n) {
        if (n.data instanceof Integer) {
            if ((Integer) n.data == 0) {
                containsZero = true;
            }
        }
    }

    public Boolean getContainsZero() {
        return containsZero;
    }
}