package dataStructures.sealed;

public class ExampleOne {

    public static void main(String[] args) {

        FinancialInstrument[] instrument = {

                new Stock("AAPL"),
                new Bond(),
                new Option()
                
        };

        for (FinancialInstrument financialInstrument : instrument) {
            String stockType = switch (financialInstrument){

                case Stock s -> "Stock trade date: " + s.getDate();
                case Bond b -> "Bond trade date: " + b.getDate();
                case Option o -> "Option trade date: " + o.getDate();

            };

            System.out.println(stockType);

        }

    }
}
