import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Button',
      theme: ThemeData(primaryColor: Colors.blue),
      home: MyButton(),
    );
  }
}

class MyButton extends StatelessWidget {
  const MyButton({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('button'),
        centerTitle: true,
      ),
      body: Center(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          TextButton(
              onPressed: () {
                print('Text Button 짧게 눌렀다');
              },
              // 버튼을 길게 눌렀을 때 반응
              onLongPress: () {
                print('Text Button 길게 눌렀다');
              },
              child: Text(
                'Text Button',
                style: TextStyle(fontSize: 20.0),
              ),
              style: TextButton.styleFrom(
                primary: Colors.red,
                backgroundColor: Colors.yellow,
              )),
          ElevatedButton(
              onPressed: () {
                print('ElevatedButton');
              },
              child: Text('Elevated Button'),
              style: ElevatedButton.styleFrom(
                  primary: Colors.orangeAccent,
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10.0)))),
          OutlinedButton(
              onPressed: () {
                print('Outlined Button');
              },
              child: Text('Outlined button'),
              style: OutlinedButton.styleFrom(
                  primary: Colors.green,
                  side: BorderSide(color: Colors.black87, width: 2.0))),
          TextButton.icon(
              onPressed: () {
                print('Icon Button');
              },
              icon: Icon(Icons.home, size: 30.0),
              label: Text('Go to home'),
              style: TextButton.styleFrom(
                primary: Colors.purple,
              )),
          ElevatedButton.icon(
              onPressed: null, // 버튼 비활성화 시키기
              icon: Icon(Icons.home, size: 20),
              label: Text('Go to home'),
              style: ElevatedButton.styleFrom(
                  primary: Colors.black, onSurface: Colors.pink // 비활성화된 버튼 색상
                  )),
          OutlinedButton.icon(
              onPressed: () {
                print('Icon Button');
              },
              icon: Icon(
                Icons.home,
              ),
              label: Text('Go to home'),
              style: OutlinedButton.styleFrom(
                primary: Colors.black,
                minimumSize: Size(200, 50),
              )),
          ButtonBar(
            alignment: MainAxisAlignment.center,
            buttonPadding: EdgeInsets.all(20),
            children: [
              TextButton(
                onPressed: () {},
                child: Text('TextButton'),
              ),
              ElevatedButton(onPressed: () {}, child: Text('ElevatedButton'))
            ],
          )
        ],
      )),
    );
  }
}
