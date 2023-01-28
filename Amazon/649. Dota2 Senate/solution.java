class Solution {
    public String predictPartyVictory(String senate) {
    int k=senate.length();
        for(int i=1;i<senate.length();i++)
        {  char c=senate.charAt(0);
               if(c!=senate.charAt(i))
               {
                   
                       if(i+1<senate.length())
                                senate=senate.substring(1,i)+senate.substring(i+1);
                       else
                                senate=senate.substring(1,i);
                       senate+=c;
                       i-=2;
               }
         // System.out.println(s);
        }
   if(senate.charAt(0)=='R')
           return "Radiant";
        else
                return "Dire";
}
}