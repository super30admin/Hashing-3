class Solution {

    // // Approach 2, here we are iterating robot for one instruction and we see that where is our robot after one full instruction, if robot itself reaches 0,0 means we completed one cycle, if robot didn't reach the 0,0  then we have to check the robot's direction after one complete instruction, if robot faces north means we never gonna reach 0,0 so we have to return false, if the robot is poiniting towards any direction other than north, means we will reach 0,0 in the future, so we have to return true

    // //Time Complexity: O(n)
    // //Space Complexity: O(1)

    public boolean isRobotBounded(String instructions) {

        //clockwise directions        N       E        S       W
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        //anti-clockwise directions    N       W        S       E
        // int[][] dirs = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

        //starting position
        int x = 0;
        int y = 0;

        //starting direction
        int i = 0;

        //iterating through instruction
        for(int j=0; j<instructions.length(); j++){

            char c = instructions.charAt(j);

            if(c=='L'){             //if the instruction is to move left
                i = (i+3)%4; //clockwise diretion           //then we have to change the direction of robot to left

                // i = (i+1)%4; //anti-clockwise diretion
            }
            else if(c=='R'){        //if the instruction is to move right
                i = (i+1)%4; //clockwise diretion           //then we have to change the direction of robot to right

                // i = (i+3)%4; //anti-clockwise diretion
            }
            else{
                x = x + dirs[i][0];                     //means we got the go instruction, so whichever the direction is robot facing, we have to go one step in that direction
                y = y + dirs[i][1];
            }
        }
        return x == 0 && y == 0 || i!=0;                //check if robot is at 0,0 if not then check if it facing north, if it's facing north then we have to return false, otherwise true
    }








    // Approach 1, here we are giving instructions to robot for 4 times, if robot reaches 0,0 in between or in the end then we are returning true, otherwise false

    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // public boolean isRobotBounded(String instructions) {

    //     //clockwise directions        N       E        S       W
    //     int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    //     //anti-clockwise directions    N       W        S       E
    //     // int[][] dirs = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    //     int x = 0;
    //     int y = 0;
    //     int i = 0;

    //     for(int k=0; k<4; k++){
    //         for(int j=0; j<instructions.length(); j++){

    //             char c = instructions.charAt(j);

    //             if(c=='L'){
    //                 i = (i+3)%4; //clockwise diretion
    //                 // i = (i+1)%4; //anti-clockwise diretion
    //             }
    //             else if(c=='R'){
    //                 i = (i+1)%4; //clockwise diretion
    //                 // i = (i+3)%4; //anti-clockwise diretion
    //             }
    //             else{
    //                 x = x + dirs[i][0];
    //                 y = y + dirs[i][1];
    //             }
    //         }
    //         if(x==0 && y==0) return true;
    //     }
    //     return x == 0 && y == 0;
    // }
}


public class RobotBoundedInCircleLC1041 {
}
