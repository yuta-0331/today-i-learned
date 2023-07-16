package silver_lesson_13;

public class Silver74 {
    public static void main(String[] args) {
        char[][] array1 = {{'a', 'b'}, {'c', 'd'}};
        char[][] array2 = array1.clone();
        char[] array3 = array2[1].clone();

        System.out.println(array1[1].equals(array2[1]));
    }
}

// array1 = {{'a', 'b'}, {'c', 'd'}}
// array2 = {{'a', 'b'}, {'c', 'd'}}
// array3 = {'c', 'd'}

//A, C,
//b