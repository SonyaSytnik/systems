import * as React from 'react';
import {Button, StyleSheet, TextInput, TouchableOpacity} from 'react-native';
import {View, Text} from '../components/Themed';
import {useState} from "react";
import {Ferma} from "./Ferma";

export default function TabOneScreen() {
    const [num, setNum] = useState<string>("");
    const [result, setRes] = useState<string>("");

    return (
        <View style={styles.container}>
            <View style={styles.separator}>
                <Text style={styles.title}>Введіть число, яке хочете розбити на множники</Text>
                <TextInput placeholder={"введіть число"} style={{
                    padding: 2,
                    width: 310,
                    height: 50,
                    borderWidth: 2,
                    borderColor: 'black',
                    fontSize: 20
                }} value={num} onChangeText={setNum} keyboardType={"numeric"}/>
                <Text>{result}</Text>
                <Button title={"Обчислити"} onPress={() => {
                    setRes(Ferma(Number(num)))
                }}/>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
    },
    title: {
        fontSize: 20,
        fontWeight: 'bold',
    },
    separator: {
        marginVertical: 30,
        height: 1,
        width: '80%',
    },
});
