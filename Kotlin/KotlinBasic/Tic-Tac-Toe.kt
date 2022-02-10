package tictactoe

fun printCell(cellList : MutableList<MutableList<Char>>) {
    println("---------")
    for (cell in cellList)
        println("| ${cell.joinToString(" ")} |")
    println("---------")
}

fun isWin(cellList : MutableList<MutableList<Char>>) : String {
    val winList = mutableListOf<Char> ()
    // 가로 검사
    if (cellList[0][0] != ' ' && cellList[0][0] == cellList[0][1] && cellList[0][0] == cellList[0][2]) winList.add(cellList[0][0])
    if (cellList[1][0] != ' ' && cellList[1][0] == cellList[1][1] && cellList[1][0] == cellList[1][2]) winList.add(cellList[1][0])
    if (cellList[2][0] != ' ' && cellList[2][0] == cellList[2][1] && cellList[2][0] == cellList[2][2]) winList.add(cellList[2][0])
    
    // 세로 검사
    if (cellList[0][0] != ' ' && cellList[0][0] == cellList[1][0] && cellList[0][0] == cellList[2][0]) winList.add(cellList[0][0])
    if (cellList[0][1] != ' ' && cellList[0][1] == cellList[1][1] && cellList[0][1] == cellList[2][1]) winList.add(cellList[0][1])
    if (cellList[0][2] != ' ' && cellList[0][2] == cellList[1][2] && cellList[0][2] == cellList[2][2]) winList.add(cellList[0][2])
    
    // 대각선 검사
    if (cellList[0][0] != ' ' && cellList[0][0] == cellList[1][1] && cellList[0][0] == cellList[2][2]) winList.add(cellList[0][0])
    if (cellList[0][2] != ' ' && cellList[0][2] == cellList[1][1] && cellList[0][2] == cellList[2][0]) winList.add(cellList[0][2])
    
    if (winList.size != 1) return "Game not finished"
    else return "${winList[0]} wins"
}

fun inputUser(cellList : MutableList<MutableList<Char>>) : Pair<Int, Int> {
    while (true) {
        print("Enter the coordinates: ")
        val pos = readLine()!!
        if (pos.length != 3) println("You should enter numbers!")
        else {
            if (pos[0].isDigit() && pos[2].isDigit()) {
                val posX = Character.getNumericValue(pos[0])
                val posY = Character.getNumericValue(pos[2])
                if ((posX < 1 || posX > 3) || (posY < 1 || posY > 3)) println("Coordinates should be from 1 to 3!")
                else if (cellList[posX-1][posY-1]=='_' || cellList[posX-1][posY-1]==' ') return Pair(posX, posY)
                else println("This cell is occupied! Choose another one!")
            }
            else println("You should enter numbers!")
        }
    }
}

fun main() {
    var cells = "         "
    val cellList = mutableListOf(
        mutableListOf(cells[0], cells[1], cells[2]),
        mutableListOf(cells[3], cells[4], cells[5]),
        mutableListOf(cells[6], cells[7], cells[8]))
    printCell(cellList)
    var order = 'X'
    var oCount = 0
    var xCount = 0
    var emptyCount = 9
    
    while (true) {
        val (posX, posY) = inputUser(cellList)
        cellList[posX-1][posY-1] = order
        printCell(cellList)
        // 검사 승패 / Draw 여부
        val resultWin = isWin(cellList)
        if (resultWin.contains("wins")) {
            println(resultWin)
            break
        }
        // 다음 순서 및 변수 결정
        if (order == 'X') order = 'O'
        else order = 'X'
        emptyCount--
        if (emptyCount == 0) {
            println("Draw")
            break
        }
    }
}

