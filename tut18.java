import static utils.InputUtils.print;

import java.util.ArrayList;
import java.util.Collections;

import utils.InputUtils.*;

public class tut18 {
    public static void main(){
        ArrayList<Integer> intList = new ArrayList<>();

        //add
        intList.add(2);
        intList.add(1);
        print("List: " + intList);


        //get
        print("Element at index 0: " + intList.get(0));


        //add in between
        intList.add(1,4);
        print("List: " + intList);

        

        //set
        intList.set(0,0);
        print("List: " + intList);

        

        //remove
        intList.remove(2);
        print("List: " + intList);


        //size
        print("Size: " + intList.size());



        //sort
        intList.add(2);
        Collections.sort(intList);
        print("List: " + intList);

    }
    
}
