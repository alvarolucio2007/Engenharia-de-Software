package main

type TipoItem int

const maxItens int = 100

type PilhaInterface interface {
	EstaCheia() bool
	EstaVazia() bool
	Push(item TipoItem) error // Inserir
	Pop() (TipoItem, error)   // Remover
	View() []TipoItem         // Visualizar
	QualTamanho() int         // Verificar tamanho
}

type Pilha struct {
	tamanho   int
	estrutura []TipoItem
}
