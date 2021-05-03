import * as React from 'react';
import {Button, StyleSheet, TextInput} from 'react-native';
import {Text, View} from '../components/Themed';
import {Ferma} from "../lab3.1/Ferma";
import {useState} from "react";
import {Perceptron} from "./Perceptron";

export default function TabTwoScreen() {
    const [study, setStudy] = useState<string>("");
    const [time, setTime] = useState<string>("");
    const [iterations, setIterations] = useState<string>("");
    const [result, setRes] = useState<string>("");

    return (
        <View style={styles.container}>
            <View style={styles.separator}>
                <Text style={styles.title}>Швидкість навчання парцептрона</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={study} onChangeText={setStudy}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Час виділений пацептрону у секундах</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={time} onChangeText={setTime}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Кількість ітерацій виділених пацептрону</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={iterations} onChangeText={setIterations}
                           keyboardType={"numeric"}/>
                <Text>{result}</Text>
                <Button title={"Обчислити"} onPress={() => {
                    setRes(Perceptron(Number(study), Number(time), Number(iterations)))
                }}/>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    input: {
        padding: 2,
        width: 310,
        height: 50,
        borderWidth: 2,
        borderColor: 'black',
        fontSize: 20
    },
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
