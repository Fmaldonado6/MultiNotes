import {useFocusEffect} from '@react-navigation/native';
import React from 'react';
import {View, Text, StyleSheet, Alert} from 'react-native';
import {Button} from 'react-native-paper';
import {notesService} from '../shared/NotesService';

const DetailScreen = ({navigation, route}) => {
  useFocusEffect(
    React.useCallback(() => {
      navigation.setOptions({
        title: route.params.title,
      });
    }, []),
  );

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Description:</Text>
      <Text style={styles.description}>{route.params.description}</Text>
      <Button
        color="red"
        mode="outlined"
        onPress={() => {
          Alert.alert(
            'Delete note',
            'Are you sure you would like to delete this note?',
            [
              {
                text: 'Delete',
                style: 'default',
                onPress: () => {
                  notesService.removeNote(route.params.index);
                  navigation.goBack();
                },
              },
              {
                text: 'Cancel',
                style: 'cancel',
                onPress: () => {},
              },
            ],
          );
        }}>
        Remove Note
      </Button>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    padding: 16,
  },
  title: {
    fontSize: 19,
    fontWeight: '500',
    marginBottom: 5,
  },
  description: {
    fontSize: 16,
    marginBottom: 15,
  },
});

export default DetailScreen;
