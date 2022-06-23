package ue6.figure;

public interface MobileObjekt {

    /**
     * helper class for returning compare states
     * Instantiating an object of this class prints the assigned state to console.
     */
    class compareState {
        /**
         * possible outcomes of compare operations defined here
         */
        public static final char UNDEFINED = 0;
        public static final char DISJOINT = 1;
        public static final char SAME = 2;
        public static final char CONTAINED = 3;
        public static final char ALIGNED = 4;
        private final char state;
        compareState(char state) {
            this.state = state;
            System.out.println(this);
        }
        public int getState() {
            return state;
        }

        @Override
        public String toString() {
            return switch (state) {
                case DISJOINT -> "DISJOINT";
                case SAME -> "SAME";
                case CONTAINED -> "CONTAINED";
                case ALIGNED -> "ALIGNED";
                default -> "UNDEFINED";
            };
        }
    }

    /**
     * Task Sentence 1.
     * Moves an object absolute to the coordinate system.
     * @param x the top left x-Coordinate of object
     * @param y the top left y-Coordinate of object
     * @return whether the operation succeeded
     */
    Boolean move(Float x, Float y);

    /**
     * Task Sentence 2.
     * Stretch the object's current size by the given factor
     * @param factor stretch factor
     * @return whether the operation succeeded
     */
    Boolean increase(Float factor);

    /**
     * Task Sentence 2.
     * Squeeze the object's current size by the given factor
     * @param factor squeeze factor
     * @return whether the operation succeeded
     */
    Boolean decrease(Float factor);
}
