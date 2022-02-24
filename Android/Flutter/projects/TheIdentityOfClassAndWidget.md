# [클래스와 위젯의 정체](https://www.youtube.com/watch?v=8k4vaoga2co&t=103s)

- 프로그래밍 상에서의 클래스란?
: 객체가 가져야 하는 속성과 기능을 정의한 내용을 담고 있는 설계도 역할

- 프로그래밍 상에서의 객체란?
: 클래스가 정의된 후 메모리상에 할당되었을 때 이를 객체라고 함

- 프로그래밍 상에서의 인스턴스란?
: 클래스를 기반으로 생성 됨, 클래스의 속성과 기능을 똑같이 가지고 있고 프로그래밍 상에서 사용되는 대상

## Dart 코드에서의 함수 정의

```
addNumber(int num1, int num2) {
  return num1 + num2;
}
```

## 클래스 정의 및 생성

```
class Person {
  var name;
  var age;
  var sex;
  
  Person(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
}

void main() {
  Person p1 = new Person('Tom', 30, 'male');
  Person p2 = new Person('Jane', 27, 'female');
  
  print(p1.age);
  print(p2.age);
}
```

- 이런식으로 생성도 가능

```
class Person {
  var name;
  var age;
  var sex;
  
  Person({String name, int age, String sex}) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }
}

void main() {
  Person p1 = Person(age:30);
  Person p2 = Person(sex:'male');
  
  print(p1.age); // 30
  print(p2.sex); // male
}
```