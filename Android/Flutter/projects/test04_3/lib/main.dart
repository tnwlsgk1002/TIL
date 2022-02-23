import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Snack Bar',
      theme: ThemeData(primarySwatch: Colors.blue),
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
          title: Text('Scaffold Messenger & Toast message'),
          centerTitle: true,
        ),
        body: Center(
          child: TextButton(
              onPressed: () {
                flutterToast();
              },
              child: Text('Toast'),
              style: TextButton.styleFrom(
                primary: Colors.white,
                backgroundColor: Colors.blue,
              )),
        ));
  }
}

void flutterToast() {
  Fluttertoast.showToast(
      msg: 'Flutter',
      gravity: ToastGravity.BOTTOM,
      backgroundColor: Colors.redAccent,
      fontSize: 20.0,
      textColor: Colors.white,
      toastLength: Toast.LENGTH_SHORT);
}
// class MySnackBar extends StatelessWidget {
//   const MySnackBar({Key? key}) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     return Center(
//       child: ElevatedButton(
//           child: Text('Go to the second page'),
//           onPressed: () {
//             ScaffoldMessenger.of(context)
//                 .showSnackBar(SnackBar(content: Text('Hellow',
//             textAlign: TextAlign.center,
//             style: TextStyle(color: Colors.white)),
//               backgroundColor: Colors.teal,
//               duration: Duration(milliseconds: 1000),
//             ));
//           }),
//     );
//   }
// }
