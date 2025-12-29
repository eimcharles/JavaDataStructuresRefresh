package generics.typeErasure;


public class BeforeErasure <T> {

    /**
     *          Type erasure is a process where the
     *          compiler removes all information
     *          related to type parameters and
     *          type arguments after performing type checks.
     *
     *          The compiler then replaces all type parameters
     *          with their bounds or Object if unbounded.
     * */

    // Removes T
    private T data;

    // Removes T
    public void setData(T data) {
        this.data = data;
    }

    // Removes T
    public T getData() {
        return data;
    }

}
