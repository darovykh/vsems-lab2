import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SocialSittingPlace implements ITotalCost {
    private static final Map<String , Integer> ADDS_PRICES = new HashMap() {{
        put("Tea",    30);
        put("Coffee", 50);
        put("Breakfast", 100);
        put("Lunch", 175);
        put("Dinner", 135);
        put("Linens", 45);
        put("Water", 20);
    }};

    private int id;
    private static int costByKm;
    private List<String> addsNames;

    public SocialSittingPlace() {
    }

    public SocialSittingPlace(int id, int costByKm, List<String> addsNames) {
        this.id = id;
        this.costByKm = costByKm;
        this.addsNames = addsNames;
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

    public List<String> getAddsNames() {
        return addsNames;
    }

    public void setAddNames(List<String> addsNames) {
        this.addsNames = addsNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialSittingPlace that = (SocialSittingPlace) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SocialSittingPlace{" +
                "id=" + id +
                ", costByKm=" + costByKm +
                ", adds=" + addsNames +
                '}';
    }

    @Override
    public int getTotalCost(int distance) {
        int addsCost = 0;
        for(String i: addsNames) {
            addsCost += ADDS_PRICES.get(i);
        }
        return distance * costByKm + addsCost;
    }
}
