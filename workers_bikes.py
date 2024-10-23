
# TIme/SPace complexity - O(W*B)
class Solution:
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        W = len(workers)
        B = len(bikes)
        hmap = defaultdict(list) 
        max_val = 0
        for i in range(W):
            for j in range(B):
                dist = abs(workers[i][0] - bikes[j][0]) + abs(workers[i][1] - bikes[j][1])
                hmap[dist].append([i,j])
                max_val = max(max_val, dist)

        assigned = set()
        available = {i for i in range(W)}
        result = [0]* len(workers)
        for i in range(max_val+1):
            if i not in hmap:
                continue
            for worker,bike in hmap[i]:
                if worker in available and bike not in assigned:
                    available.remove(worker)
                    assigned.add(bike)
                    result[worker] = bike

            if not available:
                return result

        return result



