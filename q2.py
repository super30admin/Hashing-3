# Time Complexity : O(n*m), Where n,m are number of songs, users respectively 
# Space Complexity : O(n), Where n is number of songs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

def find_fav_generes(user, genere):
    #First let us create a hashmap which will <Song:Genere>
    song_genere={}
    for i in genere.keys():
        for song in genere[i]:
            song_genere[song]=i
    #print(song_genere)
    result={}
    for i in user.keys():
        #Find the frequency of each genere
        temp={}
        maxi=0
        for song in user[i]:
            genere=song_genere[song]
            temp[genere]=temp.get(genere,0)+1
            maxi=max(maxi,temp[genere])
        #Finally add the genere with maximum freq
        temp2=[]
        for j in temp.keys():
            if(temp[j]==maxi):
                temp2.append(j)
        
        result[i]=temp2
    
    return result
            
if __name__ == "__main__":
    #First let us create the inputs
    user={"Todd":["song1","song4","song5","song8"],"Michelle":["song2","song3","song9"],"Kylie":["song6","song7","song10"]}#This will have the information of <user:List of songs listened>
    genere={"Pop":["song4","song8","song9"],"Rock":["song7","song5","song1","song10"],"Jazz":["song3","song2","song6"]}#This will have the information of <genere:List of songs in that genere>
    #Second let us start the solution
    print(find_fav_generes(user,genere))
    