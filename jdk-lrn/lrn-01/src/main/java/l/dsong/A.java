package l.dsong;

public sealed class A permits A.B, L01.C {

    protected String name;

    public static final class B extends A {
    }

    public String getName(){return name;}

}
