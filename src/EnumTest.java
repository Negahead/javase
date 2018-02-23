public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Enum.BROKER.name()); // "BROKER" as String
        System.out.println(Enum.TOPIC.toString()); // "TOPIC" as String
        System.out.println(Enum.UNKNOWN.ordinal()); // 2 as int,so index starting from 0
    }
}
