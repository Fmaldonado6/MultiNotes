import 'package:flutter/material.dart';
import 'package:multi_notes/models/models.dart';
import 'package:multi_notes/services/notes_service.dart';

class AddScreen extends StatefulWidget {
  const AddScreen({Key? key}) : super(key: key);

  @override
  _AddScreenState createState() => _AddScreenState();
}

class _AddScreenState extends State<AddScreen> {
  String title = "";
  String description = "";

  void addNote() {
    notesService.addNote(
      Note(
        title: title,
        description: description,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Add Note"),
      ),
      body: Container(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              onChanged: (text) {
                setState(() {
                  title = text;
                });
              },
              decoration: InputDecoration(
                labelText: "Note title",
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(
              height: 15,
            ),
            TextField(
              onChanged: (text) {
                setState(() {
                  description = text;
                });
              },
              decoration: InputDecoration(
                labelText: "Note description",
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(
              height: 15,
            ),
            Container(
              width: double.maxFinite,
              child: OutlinedButton(
                onPressed:
                    title.isNotEmpty && description.isNotEmpty ? addNote : null,
                child: Text("ADD NOTE"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
