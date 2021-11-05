package cabinvoicegenerator;

public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;

    InvoiceSummary(int noOfRides, double totalFare){
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.noOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }
}
