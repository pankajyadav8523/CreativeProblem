import java.util.*;

public class PermutationPalindrome {
    public static void main(String[] args) {
        PermutationPalindrome pp = new PermutationPalindrome();
        System.out.println(pp.isEditDistance1Or0("pale", "pale"));
        // System.out.println(pp.stringCompression("aaaaabbcddddefgaaa"));
    }

    void urlify(String s1, String s2){
        /*
         * ['P', 'a', 'n', 'k', 'a', 'j', , , ,'Y', 'a', 'd', 'a', 'v']
         */
        char[] arr = s1.toCharArray();
        int l = s1.length();
        int i = l-1;
        int j = l-1;
        while(arr[i] == ' '){
            i--;
        }
        while (true){
            while (arr[i] != ' '){
                swap(arr, i, j);
                i--;
                j--;
            }
            while (i == ' '){
                i--;
            }
            i--;
            for (int index2 = s2.length()-1; index2 >= 0; index2 --){
                arr[j] = s2.charAt(index2);
                j--;
            }
            
            if (arr[i]!= ' ' && arr[j] != ' '){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean isPermutationPalindrome(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int oddCharCount = 0;
        for (int i  = 0; i <s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                int value = map.get(s.charAt(i));
                map.put(s.charAt(i), value+1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }
        for (char key : map.keySet()){
            if (map.get(key) % 2 != 0){
                oddCharCount ++;
            }
            if (oddCharCount > 1){
                return false;
            }
        }
        return true;
    }

    String stringCompression(String s){
        ArrayList<Character> a = new ArrayList<>();
        int charCount = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                charCount ++;
            }
            if (s.charAt(i) != s.charAt(i - 1) || i == s.length()-1){
                a.add(s.charAt(i-1));
                char c = (char) (charCount + '0');
                a.add(c);
                charCount = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : a){
            sb.append(c);
        }
        return sb.toString();
    }

    boolean isEditDistance1Or0(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int editCount = 0;
        if (l1 - l2 > 1 || l2 - l1 > 1){
            return false;
        }
        if (l1 == l2){
            for (int i = 0; i < s2.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    editCount++;
                }
                if (editCount > 1){
                    return false;
                }
            }
            
        }
        else if (l1 - l2 == 1){
            int j = 0; int i = 0;
            while (i < l1 && j < l2){
                if (s1.charAt(i) != s2.charAt(j)){
                    i++;
                    editCount ++;
                }
                else if(editCount > 1){
                    return false;
                }
                else{
                    i++;
                    j++;
                }
            }
            
        }
        else if(l2 - l1 == 1){
            int j = 0; int i = 0;
            while (i < l1 && j < l2){
                if (s1.charAt(i) != s2.charAt(j)){
                    j++;
                    editCount ++;
                }
                else if(editCount > 1){
                    return false;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}
