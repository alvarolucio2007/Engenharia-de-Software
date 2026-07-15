package main

type (
	TipoItem               int
	PilhaDinamicaInterface interface {
		EstaCheia() bool
		EstaVazia() bool
		Push(item TipoItem) error // Inserir
		Pop() (TipoItem, error)   // Remover
		View() []TipoItem         // Visualizar
		QualTamanho() int         // Verificar tamanho
	}
	Node struct {
		valor   TipoItem
		proximo *Node
	}
)

type PilhaDinamica struct {
	nodeTopo *Node
}
