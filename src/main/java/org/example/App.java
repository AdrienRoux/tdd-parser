package org.example;

public class App
{
    public static void main(String[] args) {
        try {
            Args arg = new Args("d,p#,h*", args);
            boolean detach = arg.getBoolean('d');
            int port = arg.getInt('p');
            String hero = arg.getString('h');
            executeApplication(detach, port, hero);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage);
        }
    }

    private static void executeApplication(boolean detach, int port, String hero) {
        System.out.printf("detach is %s, port: %d, hero: %s\n",detach, port, hero);
    }
}
// Schema explanations:
// -> char     - Boolean arg
// -> char#    - Number arg
// -> char*    - String arg
