import java.util.*;
class LP{
    public static String longestPalindrome(String s) {
        if(s.length()<2) {
            return s;
        }
        int last=s.length();
        int max=1,start=0;
        for(int i=0;i<last;i++) {
            int l=i-1,h=i+1;
            while(h<last && s.charAt(h)==s.charAt(i)){
                h++;
            }
            while(l>=0 && s.charAt(l)==s.charAt(i)) {
                l--;
            }
            while(l>=0 && h<last && s.charAt(l)==s.charAt(h)) {
                l--;
                h++;
            }
            if(max<h-l-1){
                max=h-l-1;
                start=l+1;
            }
        }
        return s.substring(start,start+max);
        
    }
    public static void main(String[] args) {
    	LP p = new LP();
    	Scanner sc=new Scanner(System.in);
        String str = sc.next();
        System.out.println("String: " + str);
        System.out.println("Longest Palindromic Substring:" +longestPalindrome(str));
}
}

