package groovy

import java.math.RoundingMode

class Book {
    def name
    def age
}
//def b = new Book([name:'zhangsan',age: 12])
def b1 = new Book('zhangsan1', 12)
//println b.name + ": " + b.age
//b.name = "az1"
//println b.name + ": " + b.age

assert b1.name == "zhangsan1"
assert b1.getProperty('name') == "zhangsan1"
assert b1.getName() == "zhangsan1"


// 正则

assert "aa" == "aa123".replaceAll(/\d/, '')

// 对象

println(1.div(3))
println(1.plus(3))
println(1.multiply(3))

// List

def roman = ['','I','II','III','IV','V','VI','VII']
println roman[5]

// Map

def HTTPSTATUS = [
        100: 'CONTINUE',
        200: 'OK',
        500: 'INTERNAL ERROR',
        400: 'BAD REQUEST',
]

assert HTTPSTATUS[100] == 'CONTINUE'
assert HTTPSTATUS.get(100) == 'CONTINUE'

// range

for ( i in 1..100 ) {
    //println "haha"
}

// closure & GString
Closure eat = {
    println "${it} 吃了 ${1==1}"
}
[1,2,4].each eat

// everything is object

//int a = 5
//println a.plus(6)

// default BigDecimal

def g = 5.55
def f = 5.55f

println(g.divide(3, 2, RoundingMode.HALF_UP))
println(g / 3)
println f / 3

// 操作符重载

println new Book("aa", 1) + new Book("bb", 2)
println new Book("aa", 1) > new Book("bb", 2) ? "aa > bb" : "aa < bb"
println "aa" == "aa"