import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React, {useState} from 'react';
import {StatusBar} from 'react-native';
import HomeScreen from './src/screens/HomeScreen';
import {Provider as PaperProvider, DefaultTheme} from 'react-native-paper';
import AddScreen from './src/screens/AddScreen';
import {TaskProvider} from './src/screens/provider/TasksProvider';
import DetailScreen from './src/screens/DetailScreen';

const Stack = createNativeStackNavigator();

const App = () => {
  return (
    <PaperProvider
      theme={{
        ...DefaultTheme,
        colors: {
          ...DefaultTheme.colors,

          primary: '#3949ab',
          accent: '#5c6bc0',
        },
      }}>
      <NavigationContainer>
        <StatusBar backgroundColor="#3949ab"></StatusBar>

        <Stack.Navigator>
          <Stack.Screen
            options={{
              title: 'Notes',
              headerStyle: {
                backgroundColor: '#3949ab',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
            name="home"
            component={HomeScreen}
          />
          <Stack.Screen
            options={{
              title: 'Add',
              headerStyle: {
                backgroundColor: '#3949ab',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
            name="add"
            component={AddScreen}
          />

          <Stack.Screen
            options={{
              title: 'Add',
              headerStyle: {
                backgroundColor: '#3949ab',
              },
              headerTintColor: '#fff',
              headerTitleStyle: {
                fontWeight: 'bold',
              },
            }}
            name="detail"
            component={DetailScreen}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </PaperProvider>
  );
};

export default App;
