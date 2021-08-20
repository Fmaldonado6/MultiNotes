import 'package:multi_notes/models/models.dart';

class NotesService {
  List<Note> notes = [];

  addNote(Note note) {
    notes.add(note);
  }

  deleteNote(int index) {
    notes.removeAt(index);
  }
}

final notesService = NotesService();
