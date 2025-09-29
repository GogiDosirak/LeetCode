class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 선수과목이 존재 -> 위상정렬

        // 인접리스트로 구현
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int count = 0;

        // indegree 구하기
        // 예를 들어 [1,0] 이면, 0 -> 1로 거쳐야함
        int[] indegrees = new int[numCourses];
        for(int[] arr : prerequisites) {
            indegrees[arr[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 초기세팅
        for(int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            // 탐색하고 차수 1씩 줄이기
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int now = queue.poll();
                count++;
                for(int n : graph.get(now)) {
                    indegrees[n]--;
                    if(indegrees[n] == 0) {
                       queue.add(n);
                    }
                }
            }
        }

        // 모든 노드를 거쳤다면 완강이 가능한 것이므로 true 반환
        // 아니라면 false 반환
        return numCourses == count;
    }
}