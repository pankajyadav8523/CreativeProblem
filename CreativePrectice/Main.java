import java.util.HashMap;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        Main m = new Main();
        System.out.println(m.stringRotate("waterbottle", "erbottlewat"));
        // m.printPattern(5);
        
        // String s1 = "aabcd";
        // String s2 = "abadc";
        // System.out.println(m.isPermutation(s1, s2));
        //int[] arr =  {1, 2, 3, 4, 5};
        //m.printBackwardArray(arr);

        // Question2

        // int [] [] arr  = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        // m.print2dMatrix(arr);

        // Question 3

        // String s = "Hello World";
        // System.out.println(m.removeVowel(s));
    }


    void printBackwardArray(int[] arr){
        for (int i = arr.length-1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }

    void print2dMatrix(int[][] arr){
        for (int row = 0; row < arr.length; row ++){
            for (int col = 0; col < arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    // String removeVowel(String s){
    //     String vowel = "aeiouAEIOU";
    //     HashMap<Character, Boolean> map = new HashMap<>();
    //     for (int vowIndex = 0; vowIndex < vowel.length(); vowIndex++){
    //         map.put(vowel.charAt(vowIndex), false);
    //     }
    //     String result = "";
    //     for (int charIndex = 0; charIndex < s.length(); charIndex ++){
    //         if (!map.get(s.charAt(charIndex))){
    //             result += s.charAt(charIndex);
    //         }
    //     }
    //     return result;
    // }

    // String removeVowel(String s){
    //     String vowel = "aeiouAEIOU";
    //     String result = "";
    //     for (int charIndex = 0; charIndex < s.length(); charIndex++){
    //         boolean checkVowel = false;
    //         for (int vowIndex = 0; vowIndex < vowel.length(); vowIndex ++){
    //             if (s.charAt(charIndex) == vowel.charAt(vowIndex)){
    //                 checkVowel = true;
    //                 break;
    //             }
    //         }
    //         if (!checkVowel){
    //             result += s.charAt(charIndex);
    //         }    
    //     }
    //     return result;
    // }

    // void printArrayBackwards(int[] arr){
    //     for (int i = arr.length -1; i >=0; i--){
    //         System.out.print(arr[i] + " ");
    //     }
    // }

    // void print2dMatrix(int[][] arr){
    //     for (int row = 0; row < arr.length; row++){
    //         for (int col = 0; col < arr[row].length; col++){
    //             System.out.print(arr[row][col] + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    // String removeVowel(String s){
    //     HashSet<Character> hs = new HashSet<>();
    //     String vowel = "AEIOUaeiou";
    //     String result = "";
    //     for (int vowIndex = 0; vowIndex < s.length(); vowIndex ++){
    //         hs.add(vowel.charAt(vowIndex));
    //     }

    //     for (int charIndex = 0; charIndex < s.length(); charIndex ++){
    //         if (!hs.contains(s.charAt(charIndex))){
    //             result += s.charAt(charIndex);
    //         }
    //     }
    //     return result;
    // }


    /*
     * s1 = "aabcda"
     * s2 = "abacd"
     */

    Boolean isPermutation(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int charIndex1 = 0; charIndex1 < s1.length(); charIndex1++){
            if (map.containsKey(s1.charAt(charIndex1))){
                int value = map.get(s1.charAt(charIndex1));
                map.put(s1.charAt(charIndex1), value+1);
            }
            else{
                map.put(s1.charAt(charIndex1), 1);
            }
        }
        for (int charIndex2 = 0; charIndex2 < s2.length(); charIndex2++){
            if (map.containsKey(s2.charAt(charIndex2))){
                int value = map.get(s2.charAt(charIndex2));
                map.put(s2.charAt(charIndex2), value-1);
            }
            if (map.get(s2.charAt(charIndex2)) == 0){
                map.remove(s2.charAt(charIndex2));
            }
            if (!map.containsKey(s2.charAt(charIndex2))){
                return false;
            }  
        }
        return map.isEmpty();   
    }

    /*
     *  1 for n = 1 
     * 
     *  1 for n = 2
     * 1 1
     * 
     *   1 for n= 3
     *  1 1
     * 1 2 1
     * 
     * 
     */

     void printPattern(int n){
        for (int i = 1; i <= n; i ++){
            for (int j = n; j > i; j--){
                System.out.print(" ");
            }
            System.out.println(i);
            
            if (i != 1){
                for (int j = 0; j < n+i; j++){
                    System.out.print(" ");
                }
                System.out.println(i-1);
            }   
        }
     }

     ArrayList<Integer> isSubstring(String s1, String s2){
        ArrayList<Integer> a = new ArrayList<>();
        int index2 = 0;
        if (s1.length() < s2.length()){
            a.add(-1);
        }
        else{
            for (int index1 = 0; index1 < s1.length(); index1 ++){
                if (s1.charAt(index1) == s2.charAt(index2)){
                    if (index2 == 0){
                        a.add(index1);
                    }
                    else if(index2 == s2.length()-1){
                        a.add(index1);
                        return a;
                    }
                    index2 ++;
                }
                else{
                    a.clear();
                    index2 = 0;
                }
            }
        }
        if (a.size() == 0){
            a.add(-1);
        }
        return a;
     }


     boolean stringRotate(String s1, String s2){
        String result = s1 + s1;
        if (s1.length() == s2.length()){
            if (isSubstring(result, s2).size() > 1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
     }

}