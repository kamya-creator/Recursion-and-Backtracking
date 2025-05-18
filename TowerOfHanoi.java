package org.example;

public class TowerOfHanoi {
    public static void main(String[] args) {

        int n = 3;
        char tower1 = 'A';
        char tower2 = 'B';
        char tower3 = 'C';

                                //src    des     aux
        printTowerOfHanoiMoves(n, tower1, tower2, tower3);
    }

    public static void printTowerOfHanoiMoves(int disks, int sourceTower, int destinationTower, int helperTower) {

        if(disks == 0)
        {
            return;
        }
        // Expectation = Print statements to move n disks from source tower to destination tower using auxiliary tower
        // Faith = n-1 disks knows how to print moves to move from source to auxiliary tower using destination tower

        // Link
        // Let faith do move n-1 disks from A to C using B
        // Move nth tower from A to B
        // Let faith do move n-1 disks from C to B using A


        printTowerOfHanoiMoves(disks - 1, sourceTower, helperTower, destinationTower);
        System.out.println("Move " + disks +" from " + (char)sourceTower + " To " + (char)destinationTower);
        printTowerOfHanoiMoves(disks-1, helperTower, destinationTower, sourceTower);

    }
}
