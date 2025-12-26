package generics.exerciseOne;

import java.util.Objects;

public class MultiParameterGenericClass <keyOneElementType, valueTwoElementType> {

    private keyOneElementType typeOne;
    private valueTwoElementType typeTwo;

    /**
     *      The default constructor
     *      creates a two type parameter
     *      of generic type and sets
     *      them to null
     * */

    public MultiParameterGenericClass(){
        this.typeOne = null;
        this.typeTwo = null;
    }

    /**
     *      Parameterized Constructor accepts
     *      two type parameters of any type defined
     *      during instantiation.
     * */

    public MultiParameterGenericClass(keyOneElementType typeOne, valueTwoElementType typeTwo) {
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    /**
     *      Provides a "Type Safe" way
     *      to update a given type parameter.
     * */

    public void setTypeOne(keyOneElementType typeOne) {
        this.typeOne = typeOne;
    }

    public void setTypeTwo(valueTwoElementType typeTwo) {
        this.typeTwo = typeTwo;
    }

    /**
     *      Return type is 'type'.
     *
     *      This eliminates the need for
     *      manual casting (e.g., (String) myObj)
     *      when retrieving the value.
     * */

    public keyOneElementType getTypeOne() {
        return typeOne;
    }

    public valueTwoElementType getTypeTwo() {
        return typeTwo;
    }

    @Override
    public String toString() {
        return "MultiParameterGenericClass {typeOne = %s, typeTwo = %s}".formatted(typeOne, typeTwo);
    }

    @Override
    public boolean equals(Object obj){

        // 0. Same memory address, equal
        if (this == obj) return true;

        // 1. If the other object is null or a different class, not equal.
        if(obj == null || this.getClass() != obj.getClass())
            return false;

        // 2. Cast Object obj to type MultiParameterGenericClass
        MultiParameterGenericClass <keyOneElementType, valueTwoElementType> other = (MultiParameterGenericClass<keyOneElementType, valueTwoElementType>) obj;

        // 3. Compare both parameter fields
        return Objects.equals(this.typeOne, other.typeOne) &&
                Objects.equals(this.typeTwo, other.typeTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOne, typeTwo);
    }

}
