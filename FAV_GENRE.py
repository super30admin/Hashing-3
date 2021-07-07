def favGenre(userSongs, songGenres):

  ans = collections.defaultdict(list)
  song_to_Genres = collections.defaultdict()

  for genre in songGenres:
      for song in songGenres[genre]:
          song_to_Genres[song] = genre

  for user in userSongs:
      lst = []
      for i, song in enumerate(userSongs[user]):
          if song_to_Genres.get(song) != None:
              lst.append(song_to_Genres[song])

      counts = collections.Counter(lst)
      local_max = 0
      ans[user] = []

      for g in counts:
          local_max = max(counts[g], local_max)
      for g in counts:
          if counts[g] == local_max:
              ans[user].append(g)
  return ans
  
  # space o(nL) + o(n) + o(n) L will be length of list added to hashmap. 
  # time complexity o(nL)
