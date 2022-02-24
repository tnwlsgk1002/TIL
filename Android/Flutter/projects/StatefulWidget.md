# StatefulWidget

- [유튜버 코딩 셰프님의 조금 매운맛 강좌 1번](https://www.youtube.com/watch?v=StvbitxUKSo&list=PLQt_pzi-LLfoOpp3b-pnnLXgYpiFEftLB) 참고하여 작성

## State : UI가 변경되도록 영향을 미치는 데이터
- App 수준과 Widget 수준의 데이터가 있다.
- Stateless Widget : State가 변하지 않는 위젯
    Text('Korea') => Text('France')
    왜? rebuild
    - Widget tree <- Element tree -> Render tree
    - Widget tree : 설계도, 이런 순서와 모양으로 위젯을 그려줘.
    - ★Element tree : 중간에서 Widget tree와 Render tree를 연결
        MyApp <- MyApp element
        Scaffold <- Scaffold element
        AppBar <- AppBar element
        Text <- Text element

        ex. Container <- Containter element
        element는 point의 역할을 수행 + Container 위젯의 정보(위치, 타입, 가로 세로 크기, 배경색 등)
- Reload vs. Rebuild 
 변경된 부분만 다시 그리기 vs 화면에 다시 그리기
 위치나 타입 속성 등이 일치할 때 한해서 링크만 업데이트 하기(Reload)
- Are the element tree and render tree rebuilt? 
- Rebuild 구조
    Container Widget(white => blue) -> Hot reload ->
    build method -> Widget tree rebuild ->
    Element tree link update -> Element tree' info
    -> Render tree -> Render object re-rendering
- Stateless 위젯은 rebuild만을 통해서 새로운 State 적용 가능
- Flutter는 초당 60프레임 속도

## Extend(상속)

```
class DialPhone {
    int? year;
  
    DialPhone () {
        print('이 전화기는 다이얼을 돌려서 전화를 겁니다.');
    }
    void whenCame() {
        print("1989년 발명");
    }
}

class ButtonPhone extends DialPhone {
    ButtonPhone() {
        print('이 전화기는 버튼을 눌러서 전화를 겁니다.');
    }

    @override
    void whenCame() {
        print("1963년 발명");   
    }
}

class SmartPhone extends ButtonPhone{
    String? manufacturer;
    String? model;

    SmartPhone(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;

        print('이 전화기는 터치를 해서 전화를 겁니다.');
    }

    @override
    void whenCame() {
        print("1993년 처음 등장");
    }
}

void main() {
    SmartPhone s1 = SmartPhone('제조사: 삼성,', '모델명 : 갤럭시 s20', 2020);

    print(s1.manufacturer.toString() + " " + s1.model.toString()
    + " " + s1.year.toString());

    s1.whenCame();
}
```
