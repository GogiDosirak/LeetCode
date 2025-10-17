class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        // 차수 세팅
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        // 그래프 세팅
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 차수 0인 과목들 애들 큐에 넣기
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 큐를 돌면서 갈 수 있는 애들 차수 -- 해주고.. 0이면 다시 큐에 넣고..
        int count = 0;
        while(!queue.isEmpty()) {
            // 강의를 들은 수
            int course = queue.poll();
            count++;
            for(int next : graph.get(course)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
    }
}