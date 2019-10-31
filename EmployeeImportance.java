/*
Time O(n)
Space O(n)
Leetcode yes
problem no

The idea is to use bfs to iterate through direct subordinates of an employee and keep adding until we have iterated through all
subordinates who are directly or indirectly related to us
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, List<Integer>> mapSub = new HashMap<>();
        Map<Integer, Integer> value = new HashMap<>();
        
        for(Employee e: employees)
        {
            value.put(e.id,e.importance);
            
                mapSub.put(e.id,e.subordinates);
        }
        
        int result = 0 ;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(id);
        result += value.get(id);
        
        while(!q.isEmpty())
        {
            int var = q.poll();
            for(int j : mapSub.get(var))
            {   
                if(!set.contains(j))
                {
                    q.add(j);
                    set.add(j);
                    result+= value.get(j);
                } 
            
            }
        }
        
        return result;
    }
}
