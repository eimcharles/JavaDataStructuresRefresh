package dataStructures.sealed;

import java.time.LocalDateTime;

public final class Bond implements FinancialInstrument {

    /**
     *      The final class Bond
     *      implements the
     *      sealed interface and
     *      is declared final, therefore
     *      it cannot be extended
     *
     *      - final (end of the inheritance hierarchy)
     * */

    @Override
    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }
}
