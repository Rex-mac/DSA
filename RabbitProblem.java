public class RabbitProblem {

    public static long pairsAfterMonths(int months) {
        if (months <= 0) {
            return 0;
        }
        if (months == 1 || months == 2) {
            return 1;
        }
        long prev = 1;
        long curr = 1;
        for (int m = 3; m <= months; m++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static long pairsAfterMonthsRecursive(int months) {
        if (months <= 0) {
            return 0;
        }
        if (months == 1 || months == 2) {
            return 1;
        }
        return pairsAfterMonthsRecursive(months - 1)
             + pairsAfterMonthsRecursive(months - 2);
    }

    public static void main(String[] args) {
        int totalMonths = 12;
        System.out.println("Rabbit pairs month by month:");
        for (int month = 1; month <= totalMonths; month++) {
            System.out.println("  Month " + month + ": "
                    + pairsAfterMonths(month) + " pair(s)");
        }

        int check = 10;
        System.out.println("Iterative (month " + check + "): "
                + pairsAfterMonths(check));
        System.out.println("Recursive (month " + check + "): "
                + pairsAfterMonthsRecursive(check));
    }
}
