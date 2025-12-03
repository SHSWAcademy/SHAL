package main;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int y = Integer.parseInt(firstLine[0]);
        int x = Integer.parseInt(firstLine[1]);
        int cntSquare = Integer.parseInt(firstLine[2]);

        List<int[]> dotList = new ArrayList<>();

        //입력
        for(int i=0; i<cntSquare; i++){
            int[] dots = new int[4];
            String[] input = br.readLine().split(" ");
            int dot1x = Integer.parseInt(input[0]);
            int dot1y = Integer.parseInt(input[1]);
            int dot2x = Integer.parseInt(input[2]);
            int dot2y = Integer.parseInt(input[3]);
            dots[0] = dot1x;
            dots[1] = dot1y;
            dots[2] = dot2x;
            dots[3] = dot2y;

            dotList.add(dots);
        }

        boolean[][] isSquare = new boolean[y][x];
        boolean[][] isNonSquare = new boolean[y][x];

        setArr(dotList, isSquare);
        isNonSquare = setNonSquare(isSquare, isNonSquare);


        //출력
        List<Integer> outputs = countNonSquare(isNonSquare);
        System.out.println(outputs.size());
        Collections.sort(outputs);
        for(int i : outputs)
            System.out.print(i + " ");

    }

    private static boolean[][] setNonSquare(boolean[][] isSquare, boolean[][] isNonSquare) {
        for(int i=0; i<isSquare.length; i++){
            for(int j=0; j<isSquare[0].length; j++){
                if(!isSquare[i][j]) isNonSquare[i][j] = true;
            }
        }
        return isNonSquare;
    }

    static void setArr(List<int[]> dotList, boolean[][] isSquare){
        int row = isSquare.length;
        int col = isSquare[0].length;

        for(int[] dot : dotList){
            //2차원 배열 관점
            int firstX = dot[0];
            int firstY = row - dot[1];
            int secondX = dot[2];
            int secondY = row - dot[3];

            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++)
                    if(i>=secondY && i<firstY && j<secondX && j>=firstX) isSquare[i][j] = true;
            }
        }
    }

    static List<Integer> countNonSquare(boolean[][] isNonSquare){
        List<Integer> cntNonSquare = new ArrayList<>();

        int row = isNonSquare.length;
        int col = isNonSquare[0].length;

        boolean[][] visited = new boolean[row][col];

        Queue<Pair> q = new ArrayDeque<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        //시작점 찾기
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(isNonSquare[i][j] && !visited[i][j]){
                    int size = 0;
                    Pair newP = new Pair(j, i);
                    q.offer(newP);
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        Pair pollP = q.poll();
                        size++;

                        for(int k=0; k<4; k++){
                            int nx = pollP.x + dx[k];
                            int ny = pollP.y + dy[k];

                            if(nx<0 || ny<0 || nx >=col || ny>=row || visited[ny][nx] || !isNonSquare[ny][nx]) continue;

                            Pair p = new Pair(nx, ny);
                            visited[ny][nx] = true;
                            q.offer(p);
                        }
                    }
                    cntNonSquare.add(size);
                }
            }
        }


        return cntNonSquare;
    }

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}