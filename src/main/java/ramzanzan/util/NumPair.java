package ramzanzan.util;

public class NumPair<F extends Number,S extends Number>{
    public F First;
    public S Second;
    public NumPair(F f,S s){
        First=f;
        Second=s;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof NumPair)) return false;
        if(this==obj) return true;
        NumPair np = (NumPair)obj;
        return First.equals(np.First) && Second.equals(np.Second);
    }

    @Override
    public int hashCode() {
        return First.hashCode()+Second.hashCode();
    }
}
