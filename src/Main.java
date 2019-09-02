public class Main {

    public static void main(String[] args) {
        System.out.println(666);
        String user1 = new String(new int[]{51, 52, 53, 54}, 0, 2);
        System.out.println(user1.codePointAt(0));
        System.out.println(user1);
    }
}
