package ramzanzan;

import ramzanzan.problems.CutRod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CutRodTests {

    @Test
    void dwm1Len5(){
        CutRod cr = new CutRod(5);
        Assertions.assertEquals(13,cr.DownwardWithMemo1());
    }

    @Test
    void dwm1Len7(){
        CutRod cr = new CutRod(7);
        Assertions.assertEquals(18,cr.DownwardWithMemo1());
    }

    @Test
    void dwm2Len5(){
        CutRod cr = new CutRod(5);
        Assertions.assertEquals(13,cr.DownwardWithMemo2());
    }

    @Test
    void dwm2Len7(){
        CutRod cr = new CutRod(7);
        Assertions.assertEquals(18,cr.DownwardWithMemo2());
    }

    @Test
    void buLen5(){
        CutRod cr = new CutRod(5);
        Assertions.assertEquals(13,cr.BottomUpWithMemo());
    }

    @Test
    void buLen7(){
        CutRod cr = new CutRod(7);
        Assertions.assertEquals(18,cr.BottomUpWithMemo());
    }
}
