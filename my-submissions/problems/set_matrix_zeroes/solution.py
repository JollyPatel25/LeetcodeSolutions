class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        row = False
        col = False
        for i in range(len(matrix)):
            if(matrix[i][0] == 0):
                row = True
        for j in range(len(matrix[0])):
            if(matrix[0][j] == 0):
                col = True
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[i])):
                if(matrix[i][j] == 0):
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[i])):
                if(matrix[i][0] == 0 or matrix[0][j] == 0):
                    matrix[i][j] = 0
        if row: 
            for i in range(len(matrix)):
                matrix[i][0] = 0
        if col:
            for i in range(len(matrix[0])):
                matrix[0][i] = 0


        