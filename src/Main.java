import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ITotalCost ssp1 = new SocialSittingPlace(1, 3, Arrays.asList("Tea", "Linens"));
        ITotalCost ssp2 = new SocialSittingPlace(2, 3, Arrays.asList("Coffee", "Lunch"));
        ITotalCost ssp3 = new SocialSittingPlace(3, 3, Arrays.asList("Water", "Breakfast"));
        ITotalCost ssp4 = new SocialSittingPlace(4, 3, Arrays.asList("Tea"));
        ITotalCost ssp5 = new SocialSittingPlace(5, 3, Arrays.asList("Linens", "Tea"));

        ITotalCost bc1 = new BusinessClass(6, 7);
        ITotalCost bc2 = new BusinessClass(7, 7);
        ITotalCost bc3 = new BusinessClass(8, 7);
        ITotalCost bc4 = new BusinessClass(9, 7);
        ITotalCost bc5 = new BusinessClass(10, 7);

        List<ITotalCost> places = Arrays.asList(ssp1, ssp2, ssp3, ssp4, ssp5, bc1, bc2, bc3, bc4, bc5);

        int sum = places.stream().mapToInt(pl -> pl.getTotalCost(100)).sum();
        int min = places.stream().mapToInt(pl -> pl.getTotalCost(100)).min().orElse(0);
        int max = places.stream().mapToInt(pl -> pl.getTotalCost(100)).max().orElse(0);
        double avg = places.stream().mapToInt(pl -> pl.getTotalCost(100)).average().orElse(0);
        int sumSsp = places.stream()
                .filter(pl -> pl instanceof SocialSittingPlace)
                .mapToInt(pl -> pl.getTotalCost(100)).sum();
        int sumBc = places.stream()
                .filter(pl -> pl instanceof BusinessClass)
                .mapToInt(pl -> pl.getTotalCost(100)).sum();

        System.out.println("Total profit: " + sum);
        System.out.println("Minimal profit: " + min);
        System.out.println("Maximal profit: " + max);
        System.out.println("Average profit: " + avg);
        System.out.println("Total profit from social sitting places: " + sumSsp);
        System.out.println("Total profit from business-class places: " + sumBc);
        if(sumSsp > sumBc) {
            System.out.println("Profit from social sitting places more that profit from business-class");
        } else if (sumSsp == sumBc) {
            System.out.println("Profit from social sitting places equals to profit from business-class");
        } else {
            System.out.println("Profit from business-class more that profit from social sitting places");
        }
    }
}
