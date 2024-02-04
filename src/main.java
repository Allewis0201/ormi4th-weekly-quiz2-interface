import java.math.BigDecimal;

public class main {
    public static void main(String[] args) {


        Grocery grocery1 = new Grocery("돼지 목살", new BigDecimal(79900), 6.0);
        Beauty beauty = new Beauty("클라우드 딥 클렌징폼", new BigDecimal(9900), 1.0);
        LargeAppliance largeAppliance = new LargeAppliance("LG 트롬 오브제컬렉션", new BigDecimal(1320000), 24.0);

        System.out.println(grocery1+"\n");
        System.out.println(beauty+"\n");
        System.out.println(largeAppliance+"\n");
    }
}
