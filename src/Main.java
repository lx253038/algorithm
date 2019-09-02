public class Main {

    public static void main(String[] args) {
        String user = new String(new char[]{'7', '8', '9', 'G'}, 1, 2);
        String user1 = new String(new int[]{51, 52, 53, 54}, 0, 2);
        System.out.println(user1.codePointAt(0));
        System.out.println(user1);
    }
}
