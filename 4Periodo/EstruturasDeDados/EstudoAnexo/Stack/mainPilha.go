package main

import (
	"fmt"
	"log"
)

func main() {
	pilha1 := Pilha{
		maxItens:  10,
		tamanho:   0,
		estrutura: make([]TipoItem, 10),
	}

	fmt.Println("Programa gerador de pilhas...")
	opcao := -1
	for opcao != 0 {
		fmt.Println("Digite 0 para parar o programa!")
		fmt.Println("Digite 1 para inserir um elemento.")
		fmt.Println("Digite 2 para remover um elemento.")
		fmt.Println("Digite 3 para imprimir a pilha.")
		_, err := fmt.Scan(&opcao)
		if err != nil {
			log.Fatal(err)
		}
		switch opcao {
		case 1:
			var input int
			_, err := fmt.Scan(&input)
			if err != nil {
				log.Fatal(err)
			}
			err = pilha1.Push(TipoItem(input))
			if err != nil {
				log.Fatal(err)
			}

		case 2:
			item, err := pilha1.Pop()
			if err != nil {
				log.Fatal(err)
			}
			fmt.Println(item)
		case 3:
			fmt.Println(pilha1.View())
		}
	}
}
