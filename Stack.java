import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            System.out.println(balancedinput(input));
		}
    }	
    public static boolean balancedinput(String s){
        Stack<Character> s1=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['||ch=='{'||ch=='('){
                s1.push(ch);
            }
            else if(ch==']'){
                if(s1.isEmpty()||s1.pop()!='['){
                    return false;
                }
            }
            else if(ch=='}'){
                 if(s1.isEmpty()||s1.pop()!='{'){
                    return false;
                }
            }
            else if(ch==')'){
                 if(s1.isEmpty()||s1.pop()!='('){
                    return false;
                }
            }
            }
            return s1.isEmpty();
    }  
        }

        
        




