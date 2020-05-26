package ramzanzan;

import ramzanzan.problems.kormen_15_1_cutRod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CutRodTests {

    @Test
    void dwm1Len5(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(5);
        Assertions.assertEquals(13,cr.DownwardWithMemo1());
    }

    @Test
    void dwm1Len7(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(7);
        Assertions.assertEquals(18,cr.DownwardWithMemo1());
    }

    @Test
    void dwm2Len5(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(5);
        Assertions.assertEquals(13,cr.DownwardWithMemo2());
    }

    @Test
    void dwm2Len7(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(7);
        Assertions.assertEquals(18,cr.DownwardWithMemo2());
    }

    @Test
    void buLen5(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(5);
        Assertions.assertEquals(13,cr.BottomUpWithMemo());
    }

    @Test
    void buLen7(){
        kormen_15_1_cutRod cr = new kormen_15_1_cutRod(7);
        Assertions.assertEquals(18,cr.BottomUpWithMemo());
    }
}
