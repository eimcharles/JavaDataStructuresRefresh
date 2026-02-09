package dataStructures.sealed;

import java.time.LocalDateTime;

public sealed interface FinancialInstrument permits Stock, Bond, Option {

    /**
     *      Sealed interfaces allows
     *      for the control which classes
     *      are allowed to inherit
     *      from the parent.
     *
     *      The child classes implement the
     *      sealed interface and explicitly
     *      declare one of three modifiers:
     *
     *      - sealed (restricted open inheritance hierarchy, must define its own permits)
     *      - final (end of the inheritance hierarchy)
     *      - non-sealed (unrestricted open inheritance hierarchy)
     *
     *      A record can extend a sealed interface given
     *      that by default it is final.
     *
     *      - record (end of the inheritance hierarchy)
     *
     * */

    LocalDateTime getDate();

}
