import java.io.IOException;
import java.util.Map;

public class SystemCLassTest {
    public static void main(String[] args) throws IOException {
        /**
         * the difference, measured in milliseconds, between the current time and midnight, January 1, 1970 UTC.
         */
        System.out.println(System.currentTimeMillis());

        byte[] src = {1,2,3,4,5,6};
        byte[] des = new byte[100];

        System.arraycopy(src,1,des,0,3);
        for(int b = 0 ; b < 3; b ++) {
            System.out.print(des[b]);
        }

        /**
         * system environment.
         */
        for(Map.Entry<String,String> entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + " ======> " + entry.getValue());
        }

        System.getProperties().list(System.out);
        System.getProperties().storeToXML(System.out,"c");

        System.out.println(1<<3); // 1 * (2**3)
        byte[] data = {0,1,0,1};
        int result = 0xff & data[3];

        // 2 ** 7,128
        int shift7 = 1 << 7;
        // 128 + 15 = 143
        int re = shift7 | 0x0f;



    }
}
