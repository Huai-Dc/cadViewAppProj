/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules,
} from 'react-native';

class cadViewAppProj extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.instructions} onPress={() => this.onClick()}>
          点我13
        </Text>
        <Text style={styles.instructions} onPress={() => this._onClick()}>
          点我14
        </Text>
      </View>
    );
  }

  /**
   * 调用原生方法
   */
  onClick() {
    NativeModules.MyNativeModule.callNativeMethod('成功调用原生方法');
    //NativeModules.MyNativeModule.startActivityByString("com.example.SecondActivity")
  }
  _onClick() {
      //NativeModules.MyNativeModule.callNativeMethod('成功调用原生方法');
      NativeModules.MyNativeModule.startActivityByString("");
  }
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('cadViewAppProj', () => cadViewAppProj);
