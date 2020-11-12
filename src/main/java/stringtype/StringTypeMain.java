package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        System.out.println(message);

        message = message + "444";
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        System.out.println(b);

        boolean c = message.equals("Hello John Doe444");
        System.out.println(c);

        String s = "";
        String s2 = "";
        String concate = s + s2;
        System.out.println(concate.length());                    // 0 hosszú

        String abc = "Abcde";
        System.out.println("String hossza: " + abc.length());

        String subString1 = abc.substring(0, 1);
        String subString2 = abc.substring(2, 3);
        System.out.println(subString1 + ", " + subString2);

        String subString3 = abc.substring(0, 3);
        System.out.println(subString3);

    }
}
