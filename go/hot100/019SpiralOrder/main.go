package _19SpiralOrder

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}
	rows, columns := len(matrix), len(matrix[0])
	visited := make([][]bool, rows)
	for i := range visited {
		visited[i] = make([]bool, columns)
	}

	total := rows * columns
	order := make([]int, total)
	row := 0
	col := 0
	directions := [][]int{
		{0, 1},
		{1, 0},
		{0, -1},
		{-1, 0},
	}
	directionIndex := 0
	for i := 0; i < total; i++ {
		order[i] = matrix[row][col]
		visited[row][col] = true

		nextRow, nextClo := row+directions[directionIndex][0], col+directions[directionIndex][1]
		if nextRow < 0 || nextRow >= rows || nextClo < 0 || nextClo >= columns || visited[nextRow][nextClo] {
			directionIndex = (directionIndex + 1) % 4
		}
		row += directions[directionIndex][0]
		col += directions[directionIndex][1]
	}
	return order
}
