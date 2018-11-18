package kotlin.math

fun part1(v:Int) {
    var start = 1
    var step = 0
    var m = start
    var length = 0
    
    while (v > m) {
        length = length + 8
        m = m + length
        step++
    }
    
    var diff = m - v
    var side = length / 4
    var d = if (side>0) (diff % side) - side/2 else 0
    
    var distance = step + abs(d)
    
    println("step:$step m:$m length:$length")
    println("diff:$diff side:$side d:$d")
    
    println("distance:$distance")
}

class Spiral {
    val firstDigit = 1
    val neighboorsDiff = listOf(Pair(1,1),Pair(1,0),Pair(1,-1),Pair(0,1),Pair(0,-1),Pair(-1,-1),Pair(-1,0),Pair(-1,1))

    var mem = linkedMapOf(Pair(0,0) to firstDigit)
    
    fun findNeighboors(p:Pair<Int,Int>):List<Pair<Int,Int>> {
       	return neighboorsDiff.map{n -> Pair(n.first + p.first, n.second + p.second) }
    }
    
    fun fillValue(pair:Pair<Int,Int>):Int {
        val vv = findNeighboors(pair)
                    .mapNotNull{p->mem.get(p)}
        			.sum()
                
        mem.put(pair,vv)        
        return vv
    }
    
    fun fillUpTo(limit: Int) {
        var radious = 0
        var currentValue = 0

        while (currentValue <= limit) {
            radious++
            var x = radious
            var y = 1 - radious
            while (y < radious && currentValue <= limit) {
                currentValue = fillValue(Pair(x,y))                
                y++
            }
            while (x > -radious && currentValue <= limit) {
                currentValue = fillValue(Pair(x,y))                
                x--
            }
            while (y > -radious && currentValue <= limit) {
                currentValue = fillValue(Pair(x,y))                
                y--
            }
            while (x < radious && currentValue <= limit) {
                currentValue = fillValue(Pair(x,y))                
                x++
            }
            if(currentValue > limit) break
            currentValue = fillValue(Pair(x,y))
        }        
    }
}

fun main(args: Array<String>) {
    var v = 347991
    part1(v)
    var s = Spiral() 
    s.fillUpTo(v) //349975
    println(s.mem)

}
