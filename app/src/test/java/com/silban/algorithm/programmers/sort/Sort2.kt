package com.silban.algorithm.programmers.sort

import org.junit.Assert
import org.junit.Test

/**
 *
 * 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

Return
[6, 10, 2] - 6210
[3, 30, 34, 5, 9] - 9534330

 */

class Sort2 {
    private fun solution(numbers: IntArray): String {
        val comp = Comparator<String> { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }
        return numbers.map { it.toString() }.sortedWith(comp).takeIf { it.first() != "0" }
            ?.joinToString("") ?: "0"
    }

    @Test
    fun successCheck() {
        Assert.assertEquals("6210", solution(intArrayOf(6, 10, 2)))
    }
}