// Amazon has Fulfillment Centers in multiple cities within a large geographic region. The cities are arranged on a group that has been divided up like an ordinary Cartesian plane. Each city is located at an integral(x,y) coordinate intersection. City names and locations are given in the form of three arrays: c,x, and y, which are aligned by the index to provide the city name (c[i]), and its coordinates, (x[i],y[i]).

// Write an algorithm to determine the name of the nearest city that shares an x or a y coordinate with the queried city. If no cities share an x or y coordinate, return none. If two cities have the same distance to the queried city, q[i], consider the one with an alphabetically smaller name (e.e 'ab' < 'aba' < 'abb') as the closest choice.

// The distance is denoted on a Euclidean plan: the difference in x plus the difference in y.

//time - O(number of cities + number of queries * number of cities) = O(number of queries * number of cities)
//space - O(number of cities)
public class Main {
    public static void main(String[] args) {
        System.out.println(nearestCities(new String[]{"green", "yellow", "red", "blue", "grey", "pink"}, new int[]{10,20,15,30,10,15}, new int[]{30,25,30,40,25,25}, new String[]{"grey", "blue", "red", "pink"}));
        System.out.println(nearestCities(new String[]{"c1", "c2", "c3"}, new int[]{3, 2, 1}, new int[]{3, 2, 3}, new String[]{"c1", "c2", "c3"}));
    }
    
    private static List<String> nearestCities(String[] cities, int[] xCoOrdinates, int[] yCoOrdinates, String[] queries) {
        
        HashMap<String, City> cityObjects = new HashMap<>(); //map tracks name of city to equivalent object
        //the 2 maps tracks the list of cities for each unique x and y co ordinates
        HashMap<Integer, List<String>> xCoOrdinateCities = new HashMap<>();
        HashMap<Integer, List<String>> yCoOrdinateCities = new HashMap<>();
        for(int i = 0; i < cities.length; i++)
        {
            String cityName = cities[i];
            int x = xCoOrdinates[i];
            int y = yCoOrdinates[i];
            cityObjects.put(cityName, new City(cityName, x, y)); //populating the cityObjects map
            //building the other 2 maps
            if(!xCoOrdinateCities.containsKey(x))
            {
                xCoOrdinateCities.put(x, new ArrayList<>());
            }
            if(!yCoOrdinateCities.containsKey(y))
            {
                yCoOrdinateCities.put(y, new ArrayList<>());
            }
            xCoOrdinateCities.get(x).add(cityName);
            yCoOrdinateCities.get(y).add(cityName);
        }
        
        List<String> result = new ArrayList<>(); //return list
        for(String query : queries)
        {
            City current = cityObjects.get(query); //get the current object
            HashSet<String> candidateNeighbors = new HashSet<>(); //cities sharing same x or y as current
            //get the candidates from the co ordinates map
            for(String neighbor : xCoOrdinateCities.get(current.x))
            {
                candidateNeighbors.add(neighbor);
            }
            for(String neighbor : yCoOrdinateCities.get(current.y))
            {
                candidateNeighbors.add(neighbor);
            }
            
            String currentNeighbor = ""; //neighbor for current query
            int currentDistance = Integer.MAX_VALUE; //corresponding distance
            for(String neighbor : candidateNeighbors)
            {
                if(!neighbor.equals(query)) //if neighbor same as i/p continue
                {
                    City neighborObject = cityObjects.get(neighbor); //get the neighbor
                    int neighborDistance = findDistance(neighborObject, current); //find distance
                    if(neighborDistance <= currentDistance) 
                    {
                        //if smaller is found update both
                        if(neighborDistance < currentDistance)
                        {
                            currentDistance = neighborDistance;
                            currentNeighbor = neighbor;
                        }
                        //else update alphabtically
                        else
                        {
                            if(neighbor.compareTo(currentNeighbor) < 0)
                            {
                                currentNeighbor = neighbor;
                            }
                        }
                    }
                }
            }
            
            //add to result list
            result.add((currentNeighbor.length() == 0) ? "None" : currentNeighbor);
        }
        return result;
    }
    
    private static int findDistance(City a, City b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}

class City {
    String name; //name
    int x; //co ordinates of city on the cartesan plane
    int y;
    
    //constructor
    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}
