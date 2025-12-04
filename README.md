# SH Algorithm

Notion Link : https://www.notion.so/SW-2b7319fec6fe807b989df98e8ee13815?pvs=12 

Code Conventioin : https://naver.github.io/hackday-conventions-java/?utm_source=chatgpt.com




🧷 스터디 GitHub 참여 가이드
<처음 한 번만 저장소 클론>
1. 스터디 공유 GitHub 저장소 주소 확인 : https://github.com/SHSWAcademy/SHAL
2. 로컬 컴퓨터로 저장소 클론

   
   git clone https://github.com/SHSWAcademy/SHAL.git
   
   cd SHAL
   
<이후 매 번 업로드할 때> 


1️⃣ 작업 전 항상 최신 상태로 업데이트 git pull origin main

2️⃣ 문제 폴더 확인 및 파일 작성
1. 해당 주차 폴더와 문제 번호 확인 week1/1001/ week1/1002/
2. 문제 폴더 내에 자신의 풀이 파일 업로드

   파일명 규칙: 이름_문제번호.java 예시: 이상원_1000
   


3️⃣ 로컬에서 커밋 (commit) 
  git add . git commit -m "이상원_1000" 
  커밋 메시지 예시: 백준 문제 번호 + 이름 
  
  백준 문제가 아닌 프로그래머스라면 "평균값 구하기_이상원" 처럼 문제 이름 + 이름 으로 업로드하기
  
4️⃣ 원격 저장소에 반영 (push)
1. 다시 한번 최신 상태로 업데이트
   (충돌 방지) git pull origin main
2. main 브랜치에 직접 push git push origin main
   
💡 혹시 push가 거부된다면 다른 사람이 먼저 push한 것이니 git pull origin main을 다시 실행한 후 push하기



📌 요약
1. 작업 전 항상 최신 상태로 업데이트 (git pull origin main)
2. 문제 폴더에 새 파일 추가 
3. 로컬에서 커밋 작성
4. 다시 한번 pull 후 push
