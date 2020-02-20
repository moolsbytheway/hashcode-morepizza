package model;

public class Pizza implements Comparable {
    private Integer numberOfSlices;
    private Integer id;

    public Pizza(Integer numberOfSlices, Integer id) {
        this.numberOfSlices = numberOfSlices;
        this.id = id;
    }

    public Integer getNumberOfSlices() {
        return numberOfSlices;
    }

    public void setNumberOfSlices(Integer numberOfSlices) {
        this.numberOfSlices = numberOfSlices;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Pizza pizza = (Pizza) obj;
            return this.id.equals(pizza.getId());
        }
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass().equals(this.getClass())) {
            Pizza pizza = (Pizza) o;
            return pizza.getId() > this.getId() ? -1 : 1;
        }
        return 0;
    }
}
