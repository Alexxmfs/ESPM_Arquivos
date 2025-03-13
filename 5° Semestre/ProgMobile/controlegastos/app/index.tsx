import { useState } from "react";
import { Text, View, StyleSheet, Button } from "react-native";

export default function Index() {
  var mensagem = "Alex";
  // vat total = 100;

  let [total, setTotal] = useState<number>(100);
  const [destaque, setDestaque] = useState(estilos.linha);

  const getMenssagem = () => "Boa Noite";
  const somar = () => {
    setTotal(total++);
    console.log(total);
  };

  const zerar =() => {
    setTotal(0);
  }

const aplicaDestaque = () => {
  if (destaque.backgroundColor === "white") {
    setDestaque(estilos.linhaDestaque);
  } else {
    setDestaque(estilos.linha);
  }
  console.log(destaque);
};

  return (
    <View style={estilos.painel}>
      <Text style={estilos.linha}>{getMenssagem()}Tudo certo = {mensagem} {mensagem}</Text>
      <Text style={destaque}>Linha 2</Text>
      <Text style={estilos.linha}>Total: {total}</Text>
      <View style={{ flexDirection: "row" }}>
        <Button title="Somar" onPress={somar} />
        <Button title="Zerar" onPress={zerar} />
        <Button title="Destaque" onPress={aplicaDestaque} />
      </View>
    </View>
  );
}

const estilos = StyleSheet.create({
  painel: {
    margin: 50,
    borderWidth: 2,
    flex: 1,
  },
  corpo: {
    flex: 5,
    borderWidth: 2,
  },
  linha: {
    flex: 5,
    borderWidth: 2,
    fontSize: 20,
    backgroundColor: "white"
  },
  linhaDestaque: {
    flex: 1,
    borderWidth: 2,
    fontSize: 20,
    backgroundColor: "red"
  }
});
