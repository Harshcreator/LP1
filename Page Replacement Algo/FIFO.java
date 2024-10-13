import java.util.*;

public class FIFO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        int pages[] = new int[n];

        System.out.println("Enter the pages:");
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter the frame size: ");
        int capacity = sc.nextInt();
        
        int frames[] = new int[capacity];
        Arrays.fill(frames, -1);
        int hit = 0, fault = 0, index = 0;

        System.out.println("\n----------------------------------------------------------------------");

        for (int page : pages) {
            boolean isHit = false;

            for (int frame : frames) {
                if (frame == page) {
                    isHit = true;
                    hit++;
                    //System.out.print("H ");
                    System.out.println( page + "\tHit\t" + Arrays.toString(frames));
                    break;
                }
            }

            if (!isHit) {
                frames[index] = page;
                fault++;
                //System.out.print("F ");
                index = (index + 1) % capacity;
                System.out.println( page + "\tFault\t" + Arrays.toString(frames));
            }
        }

        System.out.println("\n----------------------------------------------------------------------");
        double faultRatio = ((double) fault / n) * 100;
        double hitRatio = ((double) hit / n) * 100;
        System.out.println("Page Fault: " + fault + "\nPage Hit: " + hit);
        System.out.println("Hit Ratio: " + hitRatio + "\nFault Ratio: " + faultRatio);
        sc.close();
    }
}

/* 
Enter number of pages: 7
Enter the pages:
1
3
0
3
5
6
3
Enter the frame size: 3

----------------------------------------------------------------------
1   Fault   [1, -1, -1]
3   Fault   [1, 3, -1]
0   Fault   [1, 3, 0]
3   Hit     [1, 3, 0]
5   Fault   [5, 3, 0]
6   Fault   [5, 6, 0]
3   Fault   [5, 6, 3]

----------------------------------------------------------------------
Page Fault: 5
Page Hit: 1
Hit Ratio: 14.285714285714285
Fault Ratio: 71.42857142857143
*/