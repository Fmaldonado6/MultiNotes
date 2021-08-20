import React, {componentDidMount, useEffect, useState} from 'react';
import {FlatList, Text, View, StyleSheet, TouchableOpacity} from 'react-native';
import {notesService} from '../shared/NotesService';
import {FAB, TouchableRipple} from 'react-native-paper';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import {useFocusEffect} from '@react-navigation/native';

const HomeScreen = ({navigation}) => {
  const [list, setList] = useState(() => notesService.notes);

  useFocusEffect(
    React.useCallback(() => {
      setList([...notesService.notes]);
    }, []),
  );

  return (
    <View style={styles.mainView}>
      {list.length != 0 ? (
        <FlatList
          data={list}
          renderItem={item => (
            <TouchableRipple
              onPress={() => {
                navigation.navigate('detail', {
                  title: item.item.title,
                  index: item.index,
                  description: item.item.description,
                });
              }}>
              <Text style={styles.listItem}>{item.item.title}</Text>
            </TouchableRipple>
          )}
        />
      ) : (
        <View style={styles.center}>
          <MaterialCommunityIcons
            name="help"
            style={styles.icon}
            size={30}></MaterialCommunityIcons>
          <Text style={styles.text}>No notes added</Text>
        </View>
      )}
      <FAB
        style={styles.fab}
        icon="plus"
        onPress={() => {
          navigation.navigate('add');
        }}></FAB>
    </View>
  );
};

const styles = StyleSheet.create({
  center: {alignItems: 'center', justifyContent: 'center', flex: 1},
  fab: {
    position: 'absolute',
    right: 20,
    margin: 16,
    bottom: 10,
  },
  listItem: {
    fontSize: 15,
    borderBottomWidth: 1,
    paddingLeft: 10,
    paddingTop: 15,
    paddingBottom: 15,
    borderBottomColor: '#e8e8e8',
  },
  icon: {
    marginBottom: 20,
  },
  text: {
    fontSize: 17,
  },
  mainView: {
    flex: 1,
    padding: 16,
  },
});

export default HomeScreen;
