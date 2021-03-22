package comp1110.homework.O02;

public enum Element {

    H(1,1,1),
    He(2,18,1),
    Li(3,1,2),
    Be(4,2,2),
    B(5,13,2);

    private int weight;
    private int group;
    private int period;
    private int[] facts ;

    Element(int weight, int group, int period) {
        this.group = group;
        this.weight = weight;
        this.period = period;
        facts = new int[]{weight,group,period};
    }



    public int[] getFacts() {
        return new int[]{weight,group,period};
    }
}
