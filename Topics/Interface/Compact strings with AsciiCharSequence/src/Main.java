import java.util.*;

class AsciiCharSequence implements CharSequence {
    byte[] sample = {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
    byte[] arr;
    public AsciiCharSequence(byte[] arr){
        this.arr  = arr;
    }

    @Override
    public int length(){
        return arr.length;
    }

    @Override
    public char charAt(int index){
        return (char) arr[index];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {

     return  new AsciiCharSequence(Arrays.copyOfRange(this.arr, i, i1 ));
    }

    @Override
    public String toString(){
        return new String(arr);
    }
}