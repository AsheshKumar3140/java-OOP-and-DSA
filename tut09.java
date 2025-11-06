import static utils.InputUtils.*;

public class tut09 {
    public static void main(String[] args) {
        int n = 5; //0101
        int pos = 2;
        if(getBit(n, pos)){
            print("Bit is 1");
        }
        else{
            print("Bit is 0");
        }

        int pos2 = 1;
        n = setBit(n, pos2);
        print("Bit is set to 1: " + n);

        n = clearBit(n, pos2);
        print("Bit is cleared: " + n);

        n = updateBit(n, pos2, 1);
        print("Bit is updated to 1: " + n);

        n = updateBit(n, pos2, 0);
        print("Bit is updated to 0: " + n);
        
    }


}