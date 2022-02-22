import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MyApp',
      theme: ThemeData(primaryColor: Colors.green),
      home: FirstPage(),
    );
  }
}

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('First page'),
        ),
        body: Center(
            child: ElevatedButton(
          // style: ElevatedButton.styleFrom(primary: Colors.red,
          // onPrimary: Colors.white, ),
          onPressed: () {
            Navigator.push(
                context, MaterialPageRoute(builder: (context) => SecondPage()));
          },
          child: Text('Go to the Second page'),
        )));
  }
}

class SecondPage extends StatelessWidget {
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext ctx) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Second page'),
        ),
        body: Center(
            child: ElevatedButton(
                // style: ElevatedButton.styleFrom(primary: Colors.red,
                //   onPrimary: Colors.white, ),
                onPressed: () {
                  Navigator.pop(ctx);
                },
                child: Text('Go to the First page'))));
  }
}
