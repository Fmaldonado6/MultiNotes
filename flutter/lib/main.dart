import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:multi_notes/screens/home_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    SystemChrome.setSystemUIOverlayStyle(
      SystemUiOverlayStyle(
        statusBarColor: Colors.indigo,
      ),
    );
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        appBarTheme: AppBarTheme(
          brightness: Brightness.dark
        ),
        primarySwatch: Colors.indigo,
        primaryColor: Colors.indigo.shade500,
        accentColor: Colors.indigo.shade400,
      ),
      home: HomeScreen(),
    );
  }
}
