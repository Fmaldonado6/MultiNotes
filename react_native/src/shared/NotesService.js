class NotesService {
  notes = [];

  addNote(note) {
    this.notes.push(note);
  }

  removeNote(index) {
    this.note = this.notes.splice(index, 1);
  }
}

export const notesService = new NotesService();
