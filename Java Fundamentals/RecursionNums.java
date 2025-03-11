class RecursionNums{
    public static void main(String[] args){
        printNum(1);
    }

    static void printNum(int n){
        System.out.println(n);
        if(n<6){
            printNum(n+1);
        }
    }
}