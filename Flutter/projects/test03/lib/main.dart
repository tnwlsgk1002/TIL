import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Appbar',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home : MyPage(),
    );
  }
}

class MyPage extends StatelessWidget {
  const MyPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar : AppBar(
        title: Text('Appbar icon menu'),
        centerTitle: true,
        elevation: 0.0,
        actions: [
          IconButton(
            icon: Icon(Icons.shopping_cart),
            onPressed: () {
              print('Shopping cart button is clicked');
            },
          ),
          IconButton(
            icon: Icon(Icons.search),
            onPressed: () {
              print('Search button is clicked');
            },
          ),
        ],
    ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: [
            UserAccountsDrawerHeader(
              currentAccountPicture: CircleAvatar(
                backgroundImage: AssetImage('assets/cat.jpg'),
                backgroundColor: Colors.white,
              ),
              otherAccountsPictures: [
                CircleAvatar(
                  backgroundImage: AssetImage('assets/rion.png'),
                  backgroundColor: Colors.white,
                ),
                // CircleAvatar(
                //   backgroundImage: AssetImage('assets/rion.png'),
                //   backgroundColor: Colors.white,
                // ),
              ],
              accountName: Text('춘식이'),
              accountEmail: Text('choonsik@kakao.com'),
              onDetailsPressed: (){
                print('arrow is clicked');
              },
              decoration: BoxDecoration(
                color: Colors.red[200],
                borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(40.0),
                  bottomRight: Radius.circular(40.0)
                ),
              ),
            ),
            ListTile(
              leading: Icon(Icons.home, color: Colors.grey[850],),
              title: Text('Home'),
              onTap: () {
                print('Home is clicked');
              },
              trailing: Icon(Icons.add),
            ),
            ListTile(
              leading: Icon(Icons.settings, color: Colors.grey[850],),
              title: Text('Setting'),
              onTap: () {
                print('Setting is clicked');
              },
              trailing: Icon(Icons.add),
            ),
            ListTile(
              leading: Icon(Icons.question_answer, color: Colors.grey[850],),
              title: Text('Q&A'),
              onTap: () {
                print('Q&A is clicked');
              },
              trailing: Icon(Icons.add),
            )
          ],
        ),
      ),
    );
  }
}

