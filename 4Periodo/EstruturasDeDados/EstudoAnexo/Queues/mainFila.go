package main

import (
	"fmt"
	"log"
)

func main() {
	fila1 := Fila{
		estrutura: make([]TipoItem, 10),
	}
	fmt.Println("Programa gerador de filas...")
	opcao := -1
	for opcao != 0 {
		fmt.Println("Digite 0 para parar o programa!")
		fmt.Println("Digite 1 para inserir um elemento.")
		fmt.Println("Digite 2 para remover um elemento.")
		fmt.Println("Digite 3 para imprimir a fila.")
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
			err = fila1.Push(TipoItem(input))
			if err != nil {
				log.Fatal(err)
			}

		case 2:
			item, err := fila1.Pop()
			if err != nil {
				log.Fatal(err)
			}
			fmt.Println(item)
		case 3:
			fmt.Println(fila1.View())
		}
	}
}
