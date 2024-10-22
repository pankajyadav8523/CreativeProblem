
# inp = [[1, 2, 3], [4,5,6], [7,8,9]]

# def printArray(inp):

#     for i in range(len(inp[0])):
#         for j in range(len(inp)):
#             print(inp[i][j], end=" ")
#         print()

        
# printArray(inp)

def removeVowel(string):
    vowel = "aeiou"
    
    result=""
    for char in string:
        if char not in vowel:
            result += char

    return result
print(removeVowel("hello world"))