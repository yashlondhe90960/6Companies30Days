class Solution{
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    int n = asteroids.length;
    
    Arrays.sort(asteroids);        
    for(int i = 0; i < n; i++)       
        if(asteroids[i] > mass)
            return false;
        else if( Integer.MAX_VALUE- mass < asteroids[i])
            return true;
        else 
            mass += asteroids[i];        
            
    return true;
}
}