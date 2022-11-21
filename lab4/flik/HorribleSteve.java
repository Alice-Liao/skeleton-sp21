package flik;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        /**
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
         **/
        int a = 0;
        int b = 0;
        for (int i = 0; i < 500; i++) {
            a = i;
            b = i;
            if (!Flik.isSameNumber(a, b)) {
                throw new Exception(
                        String.format("a:%d not same as b:%d ??", a, b));

            }

        }System.out.println("a is " + a );


    }

}
