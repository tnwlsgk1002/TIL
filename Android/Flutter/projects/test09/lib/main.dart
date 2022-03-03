import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return MyAppState();
  }
}

class MyAppState extends State<MyApp> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        theme: ThemeData(
          primaryColor: Colors.blue,
        ),
        home: Scaffold(
          appBar: AppBar(),
          body: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('You have pushed the button this many times:'),
                Text(
                  '$counter',
                  style: Theme.of(context).textTheme.displayMedium,
                ),
                //Checkbox(value: false, onChanged: (bool? value) {}),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Ink(
                      decoration: const ShapeDecoration(
                          color: Colors.lightBlue, shape: CircleBorder()),
                      child: IconButton(
                          onPressed: () {
                            setState(() {
                              counter++;
                              print('$counter');
                            });
                          },
                          icon: Icon(Icons.add),
                          color: Colors.white),
                    ),
                    SizedBox(
                      width: 20.0,
                    ),
                    Ink(
                      decoration: const ShapeDecoration(
                          color: Colors.lightBlue, shape: CircleBorder()),
                      child: IconButton(
                        onPressed: () {
                          setState(() {
                            counter--;
                            print('$counter');
                          });
                        },
                        padding: EdgeInsets.zero,
                        icon: Icon(Icons.remove),
                        color: Colors.white,
                      ),
                    )
                  ],
                )
              ],
            ),
          ),
          // floatingActionButton: FloatingActionButton(
          //   child: Icon(Icons.add),
          //   onPressed: () {
          //     setState(() {
          //       counter++;
          //       print('$counter');
          //     });
          //   },
          // ),
        ));
  }
}
