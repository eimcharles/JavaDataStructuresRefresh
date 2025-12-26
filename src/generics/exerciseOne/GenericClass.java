package generics.exerciseOne;

import java.util.Objects;

public class GenericClass <elementType> {

    /**
     *      The elementType keyword
     *      indicates a generic
     *      type parameter of any type
     * */

    private elementType typeOne;

    /**
     *      The default constructor
     *      creates a type parameter
     *      of generic type and sets
     *      it to null
     * */

    public GenericClass(){
        this.typeOne = null;
    }

    /**
     *      Parameterized Constructor accepts
     *      a type parameter of any type defined
     *      during instantiation (e.g., GenericClass<String>).
     * */

    public GenericClass(elementType typeOne) {
        this.typeOne = typeOne;
    }

    /**
     *      Provides a "Type Safe" way
     *      to update the type parameter.
     * */

    public void setAnyObjectType(elementType typeOne) {
        this.typeOne = typeOne;
    }

    /**
     *      Return type is 'type'.
     *
     *      This eliminates the need for
     *      manual casting (e.g., (String) myObj)
     *      when retrieving the parameter.
     * */

    public elementType getAnyObjectType() {
        return typeOne;
    }

    @Override
    public boolean equals(Object o) {

        // Same memory address, equal
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GenericClass<?> that = (GenericClass<?>) o;

        return Objects.equals(typeOne, that.typeOne);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(typeOne);
    }

    @Override
    public String toString() {
        return "GenericClass { elementType = %s }".formatted(typeOne);
    }

}
