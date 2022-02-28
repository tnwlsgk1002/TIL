# 계산기 만들기
  
## `activity_main.xml`
- `Linear Layout` 사용
- `layout_weight`의 사용
- 여기서 `activity_main.xml` 코드에 `onclick`을 사용하나 큰 프로젝트에서 추천하지 않으니 사용하지 말 것.
(대신 `databinding`이나 `clickListener` 사용을 추천)
  
## `MainActivity.kt`
- `view`의 `text`를 가져올 때는 `view.text`가 아닌 `(view as Button).text`와 같이 사용
  (`view`에는 text 속성이 없기 때문에 `view`를 `Button`으로 바꿔야함)
  