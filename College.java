package src;

public class College {

    private String name;
    private String city;
    private String state;
    private double tuition;
    private int sat;
    private int act;

    public College(String name, String city, String state, double tuition, int sat, int act) {

        this.name = name;
        this.city = city;
        this.state = state;
        this.tuition = tuition;
        this.sat = sat;
        this.act = act;
    }

    public String getName() {

        return name;
    }

    public String getCity() {

        return city;
    }

    public String getState() {

        return state;
    }

    public double getTuition() {

        return tuition;
    }

    public int getSAT() {

        return sat;
    }

    public int getACT() {

        return act;
    }
}