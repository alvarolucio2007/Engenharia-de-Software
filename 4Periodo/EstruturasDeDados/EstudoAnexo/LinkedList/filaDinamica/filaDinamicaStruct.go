package main

type (
	TipoItem              int
	FilaDinamicaInterface interface {
		EstaCheia() bool
		EstaVazia() bool
		Push(item TipoItem) error
		Pop() (TipoItem, error)
		View() []TipoItem
	}
	Node struct {
		valor   TipoItem
		proximo *Node
	}
	FilaDinamica struct {
		primeiro *Node
		ultimo   *Node
		tamanho  int
	}
)
