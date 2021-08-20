import 'package:flutter/material.dart';
import 'package:multi_notes/models/models.dart';
import 'package:multi_notes/services/notes_service.dart';

class DetailScreen extends StatelessWidget {
  final Note note;
  final int index;
  const DetailScreen({Key? key, required this.note, required this.index})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(note.title),
      ),
      body: Container(
        padding: EdgeInsets.all(16),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Description",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(
              height: 10,
            ),
            Text(
              note.description,
              style: TextStyle(fontSize: 16),
            ),
            SizedBox(
              height: 10,
            ),
            Container(
              width: double.maxFinite,
              child: OutlinedButton(
                style: OutlinedButton.styleFrom(primary: Colors.red),
                onPressed: () {
                  openDeleteDialog(context);
                },
                child: Text("REMOVE NOTE"),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void openDeleteDialog(BuildContext context) {
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text("Delete note"),
        content: Text("Are you sure you would like to delete this note?"),
        actions: [
          TextButton(
            onPressed: () {
              notesService.deleteNote(index);
              Navigator.popUntil(context, (route) => route.isFirst);
            },
            child: Text("DELETE"),
          ),
          TextButton(
            onPressed: () {},
            child: Text("CANCEL"),
          ),
        ],
      ),
    );
  }
}
