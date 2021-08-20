import React from 'react';
import {View, StyleSheet} from 'react-native';
import {notesService} from '../shared/NotesService';
import {Button, TextInput} from 'react-native-paper';
import {Note} from '../models/models';

const AddScreen = ({route, navigation}) => {
  const [title, setTitle] = React.useState('');
  const [description, setDescription] = React.useState('');

  return (
    <View style={styles.container}>
      <TextInput
        style={styles.textInput}
        label="Note title"
        value={title}
        outlineColor="#bababa"
        mode="outlined"
        onChangeText={text => setTitle(text)}
      />

      <TextInput
        style={styles.textInput}
        label="Note description"
        value={description}
        outlineColor="#bababa"
        mode="outlined"
        onChangeText={text => setDescription(text)}
      />

      <Button
        mode="outlined"
        disabled={title == '' || description == ''}
        onPress={() => {
          const note = new Note();
          note.title = title;
          note.description = description;
          notesService.addNote(note);
          navigation.goBack();
        }}>
        Add Note
      </Button>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 16,
  },
  textInput: {
    marginBottom: 16,
  },
});

export default AddScreen;
