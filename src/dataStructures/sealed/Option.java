package dataStructures.sealed;

import java.time.LocalDateTime;

public non-sealed class Option implements FinancialInstrument {

    /**
     *      The non-sealed class
     *      Option implements the
     *      sealed interface and
     *      any class can extend it:
     *
     *      - non-sealed (unrestricted open inheritance hierarchy)
     * */

    @Override
    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }
}
