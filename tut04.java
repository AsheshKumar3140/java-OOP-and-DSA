import java.util.*;
public class tut04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        int i = 0;
        while(i<3){
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        do{
            System.out.print(i + " ");
        }while(i<3);
        System.out.println();

        int sum = 0;
        for(i=0; i<4; i++){
            sum += i;
        }
        System.out.println(sum);

        while(i<4){
            sum += i;
            System.out.println(sum);
            i++;
        }

        do{
            sum += i;
            System.out.println(sum);
            i++;
        }while(i<4);
        System.out.println(sum);


        int num = sc.nextInt();
        int j=0;
        if(num>0){
            while(j<=10){
                System.out.println(num + " x " + j + " = " + (num*j));
                j++;
            }
        }

    }
}
