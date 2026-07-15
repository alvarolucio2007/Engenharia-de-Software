package main

type TipoItem int

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
	maxItens  int
}
