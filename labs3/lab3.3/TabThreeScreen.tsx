import * as React from 'react';
import {Button, StyleSheet, TextInput} from 'react-native';
import {Text, View} from '../components/Themed';
import {useState} from "react";
import {Perceptron} from "../lab3.2/Perceptron";
import {GenAlgorithm} from "./GenAlgorithm";

export default function TabThreeScreen() {
    const [a, setA] = useState<string>("")
    const [b, setB] = useState<string>("")
    const [c, setC] = useState<string>("")
    const [d, setD] = useState<string>("")
    const [y, setY] = useState<string>("")
    const [res, setRes] = useState<string>("")
    const [generationBad, setGenerationBad] = useState<string>("")
    const [generationGood, setGenerationGood] = useState<string>("")

    return (
        <View style={styles.container}>
            <View style={styles.separator}>
                <Text style={styles.title}>Введіть число a</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={a} onChangeText={setA}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Введіть число b</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={b} onChangeText={setB}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Введіть число c</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={c} onChangeText={setC}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Введіть число d</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={d} onChangeText={setD}
                           keyboardType={"numeric"}/>
                <Text style={styles.title}>Введіть число y</Text>
                <TextInput placeholder={"введіть число"} style={styles.input} value={y} onChangeText={setY}
                           keyboardType={"numeric"}/>
                <Text>{res}</Text>
                <Text>{generationBad}</Text>
                <Text>{generationGood}</Text>
                <Button title={"Обчислити"} onPress={() => {
                    setRes(GenAlgorithm(Number(a), Number(b), Number(c), Number(d), Number(y), setGenerationBad, true))
                    setRes(GenAlgorithm(Number(a), Number(b), Number(c), Number(d), Number(y), setGenerationGood, false))
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
