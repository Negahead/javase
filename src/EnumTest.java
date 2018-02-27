public class EnumTest {
    public static void main(String[] args) {
        System.out.println(MyEnum.BROKER.name()); // "BROKER" as String
        System.out.println(MyEnum.TOPIC.toString()); // "TOPIC" as String
        /**
         * position in the enum declaration,stating from 0
         */
        System.out.println(MyEnum.UNKNOWN.ordinal()); // 2 as int,so index starting from 0
        /**
         * values() method is a static method provided by the compiler.
         */
        for(Enum e : MyEnum.values()) {
            System.out.println(e.toString());
        }
    }

    enum FloridaProject {
        MOONE("Very smart and very cute","girl"),
        JANNECE("The girl from future land","girl"),
        SCOOTY("The boy lives under Bria","boy");
        private String description;
        private String gender;

        /**
         * a private constructor only allows object to be constructed from with the class
         * definition.but it is not a must do.
         * @param description
         * @param gender
         */
        private FloridaProject(String description,String gender) {
            this.description = description;
            this.gender = gender;
        }

        public String getDescription() {
            return description;
        }

        public String getGender() {
            return gender;
        }
    }
}
