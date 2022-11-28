package flik;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//当i变成200的时候，程序就无法跑下去了。 是Flikfunction的问题？还是test写的有问题。 到128的时候有问题
//The obvious conclusion: never rely on two references being identical, always compare them with .equals() method.
public class flikTest {
    @Test
    public void testFlik() {
        int a;
        int b;
        for (int i = 0; i <= 200; i++){
            a = i;
            b = i;
            assertTrue(Flik.isSameNumber(a, b));
        }
    }
    @Test
    public void testFlik2() {
        int a;
        int b;
        a = 128;
        b = 128;
            assertTrue(Flik.isSameNumber(a, b));
    }
}

