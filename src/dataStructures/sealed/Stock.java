package dataStructures.sealed;

import java.time.LocalDateTime;

public record Stock(String ticker) implements FinancialInstrument {

    /**
     *      The Stock record
     *      is final by definition
     *      implements the
     *      sealed interface.
     *
     *      - record (end of the inheritance hierarchy)
     * */

    @Override
    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }

}
