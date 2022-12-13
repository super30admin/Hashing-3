// Problem2 Favourite Genres

// n is the number of songs
// k users, l avg length of songs for each user

// Time Complexity : O(kl) + O(n)
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

var favoritegenre = (userSongs, songGenres) => {
    let songToGenre = new Map();
    // Create a map for songs -> genre
    songGenres.forEach((value, key) => {
        for (let i = 0; i < value.length; i++) {
            songToGenre.set(value[i], key);
        }
    })

    let result = new Map();
    userSongs.forEach((value, key) => {
        let freqMap = new Map();
        let maxFreq = 0;
        // Map the genre frequency of songs listened by each user
        // Maintain maxFreq
        for (let i = 0; i < value.length; i++) {
            let genre = songToGenre.get(value[i]);
            if (!freqMap.has(genre)) {
                freqMap.set(genre, 0);
            }
            freqMap.set(genre, freqMap.get(genre) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(genre));
        }
        let resultArr = [];
        // For all the maxFreq, add the genre to result 
        freqMap.forEach((value, key) => {
            if (value === maxFreq) {
                resultArr.push(key)
            }
        })
        result.set(key, resultArr);
    });
    return result;
}

(function main() {
    let userSongs = new Map();
    userSongs.set("David", ["song1", "song2", "song3", "song4", "song8"]);
    userSongs.set("Emma", ["song5", "song6", "song7"]);

    let songGenres = new Map();
    songGenres.set("Rock", ["song1", "song3"]);
    songGenres.set("Dubstep", ["song7"]);
    songGenres.set("Techno", ["song2", "song4"]);
    songGenres.set("Pop", ["song5", "song6"]);
    songGenres.set("Jazz", ["song8", "song9"]);

    let res = favoritegenre(userSongs, songGenres);
    console.log(res);
}());
