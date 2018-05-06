object Levenshtein extends java.io.Serializable{

    def minimum(i1: Int, i2: Int, i3: Int)=math.min(math.min(i1, i2), i3)
    def distance(s1:String, s2:String)={
        val dist=Array.tabulate(s2.length+1, s1.length+1){(j,i)=>if(j==0) i else if (i==0) j else 0}

        for(j<-1 to s2.length; i<-1 to s1.length)
            dist(j)(i)=if(s2(j-1)==s1(i-1)) dist(j-1)(i-1)
                    else minimum(dist(j-1)(i)+1, dist(j)(i-1)+1, dist(j-1)(i-1)+1)

        dist(s2.length)(s1.length)
    }

    def closestWord(s1:String, l1:Array[String]):String={
        var a = 0;
        var minValue = distance(s1,l1(0))
        var minLoc = 0
        for( a <- 0 to l1.length-1){
            if(distance(s1.toLowerCase(),l1(a).toLowerCase()) < minValue){
                minValue = distance(s1.toLowerCase(),l1(a).toLowerCase())
                minLoc = a
            }
        }
        return l1(minLoc)
    }

    def printDistance(s1:String, s2:String)=println("%s -> %s : %d".format(s1, s2, distance(s1, s2)))
    }
