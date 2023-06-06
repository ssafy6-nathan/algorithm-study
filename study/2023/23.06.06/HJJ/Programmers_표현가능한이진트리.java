package study.nathan_algo_study.week57;

/**
 * 문제이름 : 표현 가능한 이진트리
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150367
 */

public class Programmers_표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            //십진수를 이진수로 변경후 포화이진트리를 그리기 위해 자릿수를 2^n-1로 맞춰줌
            String fullBinaryTree = getFullBinaryTree(Long.toBinaryString(numbers[i]));

            if (isBinaryTree(fullBinaryTree))
                answer[i] = 1;
            else
                answer[i] = 0;
        }

        return answer;
    }

    public String getFullBinaryTree(String tree) {
        StringBuilder sb = new StringBuilder();
        int nodeCnt = 1;
        int level = 1;

        while (tree.length() > nodeCnt) {
            level *= 2;
            nodeCnt += level;
        }

        int zero = nodeCnt - tree.length();
        sb.append("0".repeat(zero));
        sb.append(tree);
        return sb.toString();
    }

    private boolean isBinaryTree(String tree) {
        if (tree.length() == 0)
            return true;

        int mid = tree.length() / 2;
        String leftTree = tree.substring(0, mid);
        String rightTree = tree.substring(mid + 1);

        if (tree.charAt(mid) == '0')    //루트노드가 0이면 자식노드 탐색해서 모두 0인지 확인
            return hasZeroBySubTree(leftTree) && hasZeroBySubTree(rightTree);
        else
            return isBinaryTree(leftTree) && isBinaryTree(rightTree);
    }

    public boolean hasZeroBySubTree(String tree) {
        if (tree.length() == 0)
            return true;

        int mid = tree.length() / 2;
        String leftTree = tree.substring(0, mid);
        String rightTree = tree.substring(mid + 1);

        if (tree.charAt(mid) == '1')    //노드가 1인 경우가 나오면 이진트리로 수 표현 불가능
            return false;
        else
            return hasZeroBySubTree(leftTree) && hasZeroBySubTree(rightTree);
    }
}

/*
1. 이진트리 만들기
2. 포화이진트리 만들기
3. 해당 트리의 부모노드가 0일 때 리프 노드까지의 모든 자식 노드가 1이면 조건에 안맞음

1234567

2 4 6
1 3 5 7

*/
