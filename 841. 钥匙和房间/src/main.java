import java.util.*;

class main {
    public static void main(String args[]){

    }
}

class Solution841 {
    public int[] map;
    public List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.map = new int[rooms.size()];
        this.rooms = rooms;
        unlock(0);
        for (int m : map) if (m != -1) return false;
        return true;
    }

    public void unlock(int room_num){
        if (map[room_num] == -1) return;
        this.map[room_num] = -1;
        List<Integer> key = this.rooms.get(room_num);
        for (int j=0; j<key.size(); j++){
            unlock(key.get(j));
        }
    }
}