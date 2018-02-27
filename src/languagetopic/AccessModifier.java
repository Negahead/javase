package languagetopic;


import apacheHttpClient.HttpClientTest;

public class AccessModifier {
    public static void main(String[] args) {
        HttpClientTest t = new HttpClientTest();
        /**
         *  no t.hello() and t.greeting().
         */
    }
}

class Modifier extends HttpClientTest {
    public void test() {
        Modifier m = new Modifier();
        /**
         * j field and hello() method is protected,
         */
        System.out.println(m.j);
        m.hello();
    }
}
