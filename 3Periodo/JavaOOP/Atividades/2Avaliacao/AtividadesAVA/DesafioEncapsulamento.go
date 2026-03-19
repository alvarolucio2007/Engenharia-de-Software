package main

import "fmt"

type Concreto struct {
	altura      float64
	base        float64
	comprimento float64
}

var Erros = map[string]string{
	"Altura":      "Erro ao conseguir a altura!",
	"Base":        "Erro ao conseguir a base!",
	"Comprimento": "Erro ao conseguir o comprimento!",
}

func ErrorAuxiliar(detalhe string, err error) {
	fmt.Printf("%s Detalhe: %v\n", Erros[detalhe], err)
}

func (c *Concreto) calcularVolume() float64 {
	return c.altura * c.base * c.comprimento
}

func main() {
	var concreto Concreto
	fmt.Print("Digite a altura: ")
	_, err := fmt.Scan(&concreto.altura)
	if err != nil {
		ErrorAuxiliar("Altura", err)
		return
	}
	fmt.Print("Digite a base: ")
	_, err = fmt.Scan(&concreto.base)
	if err != nil {
		ErrorAuxiliar("Base", err)
		return
	}
	fmt.Print("Digite o comprimento: ")
	_, err = fmt.Scan(&concreto.comprimento)
	if err != nil {
		ErrorAuxiliar("Comprimento", err)
		return
	}
	fmt.Println("O volume é ", concreto.calcularVolume())
}
