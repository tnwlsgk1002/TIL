# Git

## 버전 관리시스템(VCS, Version Control System)
- 파일 변화를 시간에 따라 기록했다가 나중에 특정 시점의 버전을 다시 꺼내올 수 있는 시스템
- ex. Git

## Git
- 빠르고 단순하다
- branch를 따서 비선형적으로 할 수 있다

### git config
```
git config user.name "yourname"
git config user.email "yourname@example.com"
```
- commit을 할 때 이 때 작성한 이름과 이메일이 남는다.
- --global 옵션을 붙여주면 프로젝트마다 설정할 필요 없이 컴퓨터에 있는 모든 프로젝트에 이러한 설정이 적용된다.
- `git config --list` : 지금 설정 확인
- `git config --global color.ui true` : 터미널에서 나오는 것이 색이 입혀져서 나오게 됨

### git 저장소
- `git init` : 이 디렉토리를 git에서 관리하도록 설정
- `./git` : git이 관리하는 스켈레톤 파일이 존재

### 파일 상태 확인
- `git status` : 상태 확인
- `git status -s` : --short 요약된 것
- `.gitingnore` : 올리고 싶지 않은 파일
 
#### Untracked
- 파일을 저장소에 저장할 필요가 없어 git이 신경쓰지 않아도 되는 상태
- 아직 add가 되지 않은 파일
- add 되고 나면 `git rm --cached <fileName>` 명령어를 이용하지 않는 이상 Untracked 상태 되지 않음

#### Tracked
- git이 파일의 변경을 감지하여 사용자에게 알려주는 것과 같이 파일을 추적하는 형태
- Unmodified, Modified, Staged
- staging area에 있는 파일(Staged)을 커밋 -> 하나의 커밋으로 저장 -> 파일 상태 Unmodified
- Unmodified 파일 수정 -> Modified 상태
- git add 명령어 사용해 Staged 상태로 올려준 후 커밋하는 과정 반복

##### Staged
- git status 명령 실행 시 Changes to be committed 명단에 있는 파일
- Untracked 파일을 Add 했을 때

##### Unmodified
- 성공적 커밋을 진행한 후에 git status 명령 실행 시 화면에 출력되지 않는 파일

##### Modified
- git status 명령 실행 시 Changes not staged for commit 명단에 있는 파일

##### Modified 파일 되돌리기(git checkout --)
- `git checkout -- sample.txt` : 워킹 디렉토리에서의 수정 사항 제거(가장 최근 커밋 버전으로 되돌림)
- 주의사항 : 되돌릴 수 없으니 주의

### branch 관리
- merge : 병합 branch를 합치기
- pull request : 요청
-> 내 branch에 있는 코드를 내가 작업하고 master에게 pull request해서 업데이트 해달라고 하기
-> 1. github 저장소를 master가 만듦. 2. magnage access를 master에게 보냄.
- manage access를 가진 사람이 세부적으로 권한을 나눌 수가 없다.
- 협업을 같은 레포지토리에서 할 수 있었음
- 상대방이 맡긴 레포지토리를 clone
- branch를 따로 생성하여 clone한 것에서 기능을 추가하고 동작하는지 확인
- 내 원격 저장소에서 사용됨(master 아님)
- 그 후에 pull request에 요청을 보냄
- 프로젝트 매니저가 보고 확인을 누르면 이상이 없다는 것을 확인하고 병합해주는 것
- 내 브랜치가 공용 브랜치와 합쳐지면서 적용이 되는 것
- fork 하여 repos에서 수정한 내용을 pull request하여 최종 master가 확인

### 기타 명령어
- `git diff` : 워킹 디렉토리에 Unstaged 된 파일을 비교
  - `git diff --staged` : Staging area에 있는 것 비교
  - `git diff <branch명> <다른 branch명>` : branch 간 비교
  - `git diff <branch명> origin/<branch명>` : 로컬 브랜치와 리모트 브랜치 비교
  - `git diff <commit> <commit>` : commit간 비교, <commit> 에는 커밋 해시값 넣기
    `git diff <commit>.. <commit>` : commit 사이를 비교

