class Strings{
    public static void main(String args[]){
        String firstName = "Vipul";
        String lastName = " Chavan";
        // String fullName = firstName+lastName;

        // System.out.print(fullName);

        // for(int i=0;i<fullName.length();i++){
        //     System.out.print(fullName.charAt(i));
        // }

        if(firstName.compareTo(lastName) == 0){
            System.out.print("Strings are equal.");
        }else{
            System.out.print("Strings are not equal.");
        }
    }
}