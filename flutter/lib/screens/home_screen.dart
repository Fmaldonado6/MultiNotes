import 'package:flutter/material.dart';
import 'package:multi_notes/models/models.dart';
import 'package:multi_notes/screens/add_screen.dart';
import 'package:multi_notes/screens/detail_screen.dart';
import 'package:multi_notes/services/notes_service.dart';

class HomeScreen extends StatefulWidget {
  HomeScreen({Key? key}) : super(key: key);

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Note> notes = [];

  @override
  void initState() {
    getNotes();
    super.initState();
  }

  void getNotes() {
    setState(() {
      notes = notesService.notes;
    });
  }

  void navigateToDetail(Note note, int index) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => DetailScreen(
          note: note,
          index: index,
          noteDeleted: getNotes,
        ),
      ),
    );
  }

  void navigateToAdd() {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => AddScreen(
          noteAdded: getNotes,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Notes"),
      ),
      body: notes.isNotEmpty
          ? ListView.builder(
              padding: EdgeInsets.all(16),
              itemCount: notes.length,
              itemBuilder: (context, index) {
                final note = notes[index];
                return InkWell(
                  onTap: () {
                    navigateToDetail(note, index);
                  },
                  child: Container(
                    padding: EdgeInsets.only(
                      left: 10,
                      bottom: 15,
                      top: 15,
                    ),
                    decoration: BoxDecoration(
                      border: Border(
                        bottom: BorderSide(
                          color: Colors.grey.shade200,
                        ),
                      ),
                    ),
                    child: Text(
                      note.title,
                      style: TextStyle(fontSize: 15),
                    ),
                  ),
                );
              })
          : Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.help,
                    size: 35,
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Text(
                    "No notes added",
                    style: TextStyle(fontSize: 17),
                  ),
                ],
              ),
            ),
      floatingActionButton: FloatingActionButton(
        onPressed: navigateToAdd,
        child: Icon(
          Icons.add,
        ),
      ),
    );
  }
}
