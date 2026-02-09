package dataStructures.records;

import java.time.LocalDateTime;
import java.util.Objects;

public record UserData(

        String name,
        String lastName,
        LocalDateTime date

)
{

    public UserData {

        /// Data validation with requireNonNull
        Objects.requireNonNull(date, "Timestamp is required");

        /// Data validation with a if-statement
        if (name == null || lastName == null || name.isBlank() || lastName.isBlank())
            throw new IllegalArgumentException("User name and last name fields cannot be blank or null");
    }

}
