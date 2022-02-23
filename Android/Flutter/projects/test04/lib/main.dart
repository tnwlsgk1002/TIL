import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Snack Bar',
      theme: ThemeData(primarySwatch: Colors.red),
      home: MyPage(),
    );
  }
}

class MyPage extends StatelessWidget {
  const MyPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Snack Bar'),
          centerTitle: true,
        ),
        body: Builder(builder: (BuildContext ctx) {
          return Center(
            child: TextButton(
              child: Text(
                'Show me',
              ),
              style: TextButton.styleFrom(
                  primary: Colors.white, backgroundColor: Colors.red),
              onPressed: () {
                ScaffoldMessenger.of(ctx).showSnackBar(SnackBar(
                  content: Text('Hellow'),
                ));
              },
            ),
          );
        }));
  }
}
