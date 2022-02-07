package cinema
import kotlin.Exception

fun initCinema() : Pair<Int, Int> {
    println("Enter the number of rows:")
    val row = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val column = readLine()!!.toInt()
    return Pair(row, column)
}

fun printCinema(cinema : MutableList<MutableList<Char>>) {
    println("Cinema:")
    println("  ${(1..cinema[0].size).joinToString(" ")}")
    for (i in 1..cinema.size) {
        println("$i ${cinema[i-1].joinToString(" ")}")
    }
}

fun buyTicket(cinema : MutableList<MutableList<Char>>, rowMax: Int, columnMax : Int): Triple<Int, Int, Int> {
    do {
        println("Enter a row number:")
        val row = readLine()!!.toInt()
        println("Enter a seat number in that row:")
        val column = readLine()!!.toInt()
        if (rowMax < row || columnMax < column) {
            println("Wrong input!")
            continue
        }
        else {
            if (cinema[row-1][column-1] == 'B') {
                println("That ticket has already been purchased!")
                continue
            }
        }
        var price = 0
        price = (if (rowMax * columnMax <= 60) 10
                else {if (row <= rowMax / 2) 10 else 8})
        println("\nTicket price: \$$price")
        return Triple(row, column, price)
    } while (true)
}

fun Statistics(nTicket : Int, percent : Double, income : Int, total : Int) {
    println("""
    Number of purchased tickets: $nTicket
    Percentage: ${String.format("%.2f", percent)}%
	Current income: ${"$"}$income
	Total income: ${"$"}$total
    """.trimIndent())
}

fun main() {
    val (rowMax, columnMax) = initCinema()
    val cinema = MutableList(rowMax, {MutableList(columnMax, {'S'})})
    var nTicket = 0
    var persent = 0.00
    var income = 0

    var total = (
        if (rowMax * columnMax <= 60) rowMax * columnMax * 10
        else {
            if (rowMax % 2 == 0) (rowMax / 2) * columnMax * 10 + (rowMax / 2) * columnMax * 8
            else (rowMax / 2) * columnMax * 10 + (rowMax / 2 + 1) * columnMax * 8   
        })
    while (true) {
        println("")
        println("""
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
        """.trimIndent())
        val input = readLine()!!.toInt()
        println("")
        when(input) {
            1 -> printCinema(cinema)
            2 -> {
                 val (posY, posX, price) = buyTicket(cinema, rowMax, columnMax)
                 cinema[posY-1][posX-1] = 'B'
                 nTicket++
                 persent = nTicket.toDouble() / (rowMax * columnMax) * 100
                 income += price
            }
            3 -> Statistics(nTicket, persent, income, total)
            0 -> break
        }
     }
}
