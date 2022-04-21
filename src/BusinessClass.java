import java.util.Objects;

public class BusinessClass implements ITotalCost {
    private int id;
    private static int costByKm;

    public BusinessClass() {
    }

    public BusinessClass(int id, int costByKm) {
        this.id = id;
        this.costByKm = costByKm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCostByKm() {
        return costByKm;
    }

    public void setCostByKm(int costByKm) {
        this.costByKm = costByKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessClass that = (BusinessClass) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BusinessClass{" +
                "id=" + id +
                ", costByKm=" + costByKm +
                '}';
    }

    @Override
    public int getTotalCost(int distance) {
        return distance * costByKm;
    }
}
