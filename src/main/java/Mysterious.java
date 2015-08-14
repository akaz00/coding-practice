import org.junit.Test;


public class Mysterious {
    public static void MysteryFunction2( int a, int b, int x, int y )
    {
        while ( a != x && b != y )
        {
            if ( a < x ) // changed from > to < to avoid infinite loop
            {
                a++;
            }
            else
            {
                a--;
            }

            if ( b < y ) // changed from > to < to avoid infinite loop
            {
                b++;
            }
            else
            {
                b--;
            }
        }
    } // close brace
    
    public static void BetterMysteryFunction2( int a, int b, int x, int y )
    {
    	// do nothing since it's void and taking primitive types
    } // close brace
    
    @Test
    public void test() {
    	MysteryFunction2(1, 2, 3, 4);
    }
}
