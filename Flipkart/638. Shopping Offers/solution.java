class Solution {
    public int minCost;
    
    public int totalValue(List<Integer> price , List<Integer> needs)
    {
        int cost =0;
        int n = needs.size();
        for(int i=0;i<n;i++)
            cost += price.get(i)*needs.get(i);
        
        return cost;
    }
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        minCost = totalValue(price,needs);
        helper(price,special,needs,0,0);
        return minCost;
        
    }
    
    public boolean canUse(List<Integer> offer , List<Integer> needs)
    {
        int n =  needs.size();
        for(int i=0;i<n;i++)
        {
            if(offer.get(i)>needs.get(i))
                return false;
        }
        
        return true;
    }
    
    
    
    public void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index, int used)
    {
        if(used>minCost)
            return;
        
        if(index == special.size())
        {
            used += totalValue(price,needs);
            
            minCost = Math.min(used,minCost);
            
            return;
        
        }
            
        List<Integer> offer = special.get(index);
        int n = needs.size();
        
        if(canUse(offer,needs))
        {
            List<Integer> updatedNeeds = new ArrayList<>();
            for(int i=0;i<n;i++)
                updatedNeeds.add(needs.get(i) - offer.get(i));
            
            helper(price,special,updatedNeeds,index,used + offer.get(n));
        }
        
        helper(price,special,needs,index+1,used);
    }
    
}