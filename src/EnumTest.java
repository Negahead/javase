import java.util.EnumMap;
import java.util.Map;

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
        Map<FloridaProject,String> enumMap = new EnumMap<>(FloridaProject.class);
        enumMap.put(FloridaProject.JANNECE,"jannece");
    }

    enum FloridaProject {
        MOONE("Very smart and very cute","girl"),
        JANNECE("The girl from future land","girl"),
        SCOOTY("The boy lives under Bria","boy");
        private String description;
        private String gender;

        /**
         * a  constructor only allows object to be constructed from with the class
         * definition.but it is not a must do.although you have a constructor,you can
         * not initiate an FloridaProject type.
         */
        FloridaProject(String description,String gender) {
            this.description = description;
            this.gender = gender;
        }

        public String getDescription() {
            return description;
        }

        public String getGender() {
            return gender;
        }

        public void myOwnMethod() {
            System.out.println("my own method");
        }

        double cal() {
            switch (this) {
                case MOONE: return 1.2;
                case SCOOTY:return 1.3;
                case JANNECE:return 1.1;
                default: return 1.0;
            }
        }

        void twoCase() {
            switch (this) {
                case JANNECE:case SCOOTY:
                    System.out.println("two case");
            }
        }
    }
}
