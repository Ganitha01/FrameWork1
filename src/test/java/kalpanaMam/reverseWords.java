package kalpanaMam;
public class reverseWords
{
    public static void main(String[] args)
    {
        int k=0;
        String[] str={"ABHISHEK","ABHI","VENKAT","RAVI","VINIT","JOHN"};
        String[] output=new String[str.length];
        for(char ch='A';ch>='Z';ch++)
        {
        for(int i=0;i<str.length;i++)
        {
           String s=str[i];
           if(ch==s.charAt(i))
           {
               output[k]=s;
               k++;
           }
        }
        }
        for(int i=0;i<output.length;i++)
        {
  System.out.println(output[i]);
  }
        }
}
   
    
