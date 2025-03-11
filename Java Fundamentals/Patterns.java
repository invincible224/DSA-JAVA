class Patterns{
    // public static void SolidRect(int row,int col){
    //     for(int i=0;i<row;i++){
    //         for(int j=0;j<col;j++){
    //             System.out.print("*");
    //         }
    //             System.out.print("\n");
    //     }
    // }

    public static void RightHalfPyramid(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
                System.out.print("\n");
        }
    }

    public static void main(String[] args){
        // SolidRect(4,5);
        RightHalfPyramid(4);
    }
}