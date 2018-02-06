/**
* https://leetcode.com/problems/heaters/description/
*/
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int radius = 0;
        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            int min = 0; // in the place of a heater
            
            if (pos < 0) { // between heaters
                pos = -(pos + 1);
                
                if (pos == 0)
                    min = heaters[pos] - house;
                else if (pos == heaters.length)
                    min = house - heaters[pos - 1];
                else 
                    min = Math.min(house - heaters[pos - 1], heaters[pos] - house);        
            }
                
            radius = Math.max(radius, min);
        }
        
        return radius;
    }
}
