public class MyFunnyTools {
    @FunctionalInterface
    interface MyInterface {
        String myConcatenation(String a, String b);
    }
    public MyInterface createMyConcatenation() {
        MyInterface myInterface = String::concat;
        return myInterface;
    }
}
