package net.benshouse.techdevguide;

/**
 * Challenge from https://techdevguide.withgoogle.com/paths/advanced/volume-of-water/#!
 * @author Ben Noble
 * @since 2018-09-11
 */
public class WaterVolume {
    private int[] heights;
    public WaterVolume(int[] heights){
        this.heights = heights;
    }

    public int totalLakeVolume(){
        int volume = 0;
        if (this.heights.length < 3) return 0; //need at least 3 squares to form a lake.

        for (int i = 1; i < this.heights.length -1; i++){
            //Only enters this loop if the height has decreased
            for (int diff = this.heights[i-1] - this.heights[i]; diff > 0; diff--) {
                //For every single decrement in height, look ahead for an equal height 'hill' (or taller)
                int top = this.heights[i-1] - (diff -1); // height of the hill we need
                for (int x = i + 1; x < this.heights.length; x++) {
                    if (this.heights[x] >= top) {
                        //Found a 'hill', add a single 'row' of volume
                        volume += (x - i);
                        break;
                    }
                }
            }
        }

        return volume;
    }
}
