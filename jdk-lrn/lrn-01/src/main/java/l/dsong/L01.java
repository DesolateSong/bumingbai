package l.dsong;

public class L01 {

    public static void main(String[] args) {
        String a = """
                hello
                 world !
                 >>
                """;
        System.out.println(a);


        Object s = "333333";
        if(s instanceof String b){
            System.out.println(b);
        }

        A.B a1 = new A.B();
        a1.name = "Jack";

        System.out.println(a1.getName());

        Animal dog = new Animal("dog");
        System.out.println(dog + dog.name());

        System.out.println(switchTe("1"));

    }

    public static String switchTe(String arg){
        switch (arg){
            case "1" -> {
                return "red";
            }
            case "2" -> {
                return "blue";
            }
            default -> {
                return "yellow";
            }
        }
    }


    public static final class C extends A{

    }



}
