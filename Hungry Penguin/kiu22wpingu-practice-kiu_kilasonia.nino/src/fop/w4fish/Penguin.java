package fop.w4fish;

public class Penguin extends MiniJava {

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
       for (int row = 0; row < world.length; row++){
           for (int col = 0; col < world[0].length; col++){

               switch (world[row][col]) {
                   case 0 -> System.out.print("L");
                   case 1 -> System.out.print("I");
                   case 2 -> System.out.print("W");
                   case 3 -> System.out.print("S");
                   case 4 -> System.out.print("F");
               }
               if (row == pinguRow && col == pinguColumn) {
                   System.out.print("(P)");
               }
               if (col != world[0].length-1) {
                   System.out.print("\t");
               }
               if(col == world[0].length-1){
                   System.out.print("\n");
               }

           }
       }
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn){
        if(pinguRow < 0 || pinguColumn < 0 || pinguRow > world.length-1 || pinguColumn > world[0].length-1){
            return false;
        }
        int currentPos = world[pinguRow][pinguColumn];
        world[pinguRow][pinguColumn] = 3;
        return switch (currentPos) {
            case 0 -> isFishReachable(world, pinguRow-1, pinguColumn) ||
                    isFishReachable(world, pinguRow, pinguColumn + 1) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn) ||
                    isFishReachable(world, pinguRow, pinguColumn-1);
            case 1 -> isFishReachable(world, pinguRow - 1, pinguColumn - 1) ||
                    isFishReachable(world, pinguRow - 1, pinguColumn + 1) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn + 1) ||
                    isFishReachable(world, pinguRow + 1, pinguColumn - 1);
            case 2 -> isFishReachable(world, pinguRow - 3, pinguColumn - 3) ||
                    isFishReachable(world, pinguRow - 3, pinguColumn + 3) ||
                    isFishReachable(world, pinguRow + 3, pinguColumn - 3) ||
                    isFishReachable(world, pinguRow + 3, pinguColumn + 3);
            case 4 -> true;
            default -> false;
        };
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    /**
     * returns the example world 1.
     * Do not modify this method.
     * @return An example world
     */
    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    /**
     *  You may use the main method for testing your program.
     */
    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);
        write(""+isFishReachable(world, pinguRow, pinguColumn));

        int[][] woorld = generateExampleWorldTwo();
        printWorld(woorld, 0, 1);
        write(""+isFishReachable(world, pinguRow, pinguColumn));
    }

}
