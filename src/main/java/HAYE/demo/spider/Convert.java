package HAYE.demo.spider;

public class Convert {

    public static String intToShort(Long id) {
        String shor = String.valueOf(id);
        while (shor.length() != 5) {
            shor = "0" + shor;
        }
        return shor;
    }

}
