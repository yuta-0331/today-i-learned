package sample;
interface ParentIF {
    void parentMethod();
}

@FunctionalInterface
interface FuncIF extends ParentIF {
    public default void method() {}
}