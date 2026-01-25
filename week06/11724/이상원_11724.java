
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sArr = sc.nextLine().split(" ");
        int N = Integer.parseInt(sArr[0]);
        int M = Integer.parseInt(sArr[1]);

        Node[] Narr = new Node[N];

        //Narr에 0, 1, 2, 3, 4 처럼 순차적으로 번호를 가진 노드가 들어간다.
        for(int i=0; i<Narr.length; i++){
            Narr[i] = new Node(i);
        }
        
        //edge 배열 속에 edge 생성, 시작 노드, 끝 노드 설정
        for(int i=0; i<M; i++){
            String[] sArr2 = sc.nextLine().split(" ");
            int a = Integer.parseInt(sArr2[0]);
            int b = Integer.parseInt(sArr2[1]);

            //노드의 인접리스트에 이웃 노드 등록
            Narr[a-1].neighbor.add(Narr[b-1]);
            Narr[b-1].neighbor.add(Narr[a-1]);
        }

        int count = 0;

        for(int i=0; i<Narr.length; i++){
            if(Narr[i].visited==true) {
                for(int j=0; j<Narr[i].neighbor.size(); j++) {
                    Narr[i].neighbor.get(j).visited=true;
                }
                continue;
            }
            DFS(Narr[i]);
            count++;
        }
        System.out.println(count);



    }
    public static void DFS(Node startNode){
        //1. 현재 노드 방문처리
        startNode.visited=true;
        //2. 이웃 노드 조회
        List<Node> list = startNode.neighbor;
        //3. 이웃 노드 순회
        for(int i=0; i<list.size(); i++){
            if(list.get(i)!=null && list.get(i).visited == false){
                DFS(list.get(i));
            }
        }
        
    }
    static class Node{
        Integer num;
        boolean visited;
        List<Node> neighbor = new ArrayList<>();

        public Node(Integer num) {
            this.num = num;
        }
    }

}
