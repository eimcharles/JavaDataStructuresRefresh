package generics.typeErasure;

public class AfterErasure {

    ///  After erasure example class

    // T replaced by Object
    private Object data;

    // T replaced by Object
    public void setData(Object data) {
        this.data = data;
    }

    // T replaced by Object
    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return " AfterErasure { data = %s }".formatted(data);
    }

}
