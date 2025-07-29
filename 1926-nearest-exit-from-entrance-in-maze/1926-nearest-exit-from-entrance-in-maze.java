class Solution {
    int answer = 0;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                if((node.x != entrance[0] || node.y != entrance[1]) && (node.x == 0 || node.x == maze.length - 1 || node.y == maze[0].length - 1 || node.y == 0)) {
                    return answer;
                }
                for(int j = 0; j < 4; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if(nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == '.') {
                        queue.add(new Node(nx,ny));
                        maze[nx][ny] = '+';
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}