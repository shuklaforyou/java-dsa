public class subset1 {
    public static void main(String[] args) {
        int[] input_string ={1,2,3} ;
        int string_length = input_string.length;
        int temp = 0;
        System.out.println("The int is defined as: " + input_string);
        String string_array[] = new String[string_length * (string_length + 1) / 2];
        for (int i = 0; i < string_length; i++) {
            for (int j = i; j < string_length; j++) {
                string_array[temp] = input_string.substring(i, j + 1);
                temp++;
            }
        }
        System.out.println("The subsets of the string are: ");
        for (int i = 0; i < string_array.length; i++) {
            System.out.println(string_array[i]);
        }
    }
}
