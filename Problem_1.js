// Problem1  Repeated DNA Sequences (https://leetcode.com/problems/repeated-dna-sequences/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {string[]}
 */
var findRepeatedDnaSequences = function (s) {
    if (s === null || s.length <= 10)
        return [];
    let start = 0;
    let end = 10;
    let map = new Map();
    let result = [];
    while (end <= s.length) {
        let dna = s.substring(start, end);
        if (!map.has(dna)) {
            map.set(dna, 1);
        } else {
            let freq = map.get(dna);
            freq++;
            map.set(dna, freq);
            if (freq === 2) {
                result.push(dna);
            }
        }
        start++; end++;
    }
    return result;
};
