class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Course Schedule과 같은 문제지만, 완강 여부가 아닌 강의를 들은 순서를 반환
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        int[] answer = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }

        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            answer[index] = now;
            index++;

            for(int n : graph.get(now)) {
                indegrees[n]--;
                if(indegrees[n] == 0) queue.add(n);
            }
        }


    // 모든 코스에 도달할 수 없는 경우 빈 리스트 반환 - 체크해야하므로 index 사용
    if(index != numCourses) return new int[0];
    return answer;
    }
}