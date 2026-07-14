package main

type TipoItem int

var maxItens = 100

type FilaInterface interface {
	EstaCheia() bool
	EstaVazia() bool
	Push(item TipoItem) error
	Pop() (TipoItem, error)
	View() []TipoItem
}
type Fila struct {
	primeiro  int
	ultimo    int
	estrutura []TipoItem
}
