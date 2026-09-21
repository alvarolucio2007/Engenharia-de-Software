package encontro

import "errors"

type Node struct {
	dado    int
	proximo *Node
}
type ListaEncadeada struct {
	inicio *Node
	fim    *Node
}

func (l *ListaEncadeada) inserir_inicio(dado int) {
	var primeiro *Node
	primeiro.dado = dado
	primeiro.proximo = l.inicio
	l.inicio = primeiro
}

func (l *ListaEncadeada) inserir_fim(dado int) {
	if l == nil {
		return
	}
	novo := &Node{dado: dado, proximo: nil}
	if l.fim == nil {
		l.inicio = novo
		l.fim = novo
		return
	}

	l.fim.proximo = novo
	l.fim = novo
}

var (
	ErrListNotFound    = errors.New("linked list is nil or empty")
	ErrElementNotFound = errors.New("element was not found")
)

func (l *ListaEncadeada) remover(valor int) error {
	if l == nil || l.inicio == nil {
		return ErrListNotFound
	}
	atual := l.inicio
	var anterior *Node
	for atual != nil && atual.dado != valor {
		anterior = atual
		atual = atual.proximo
	}
	if atual == nil {
		return ErrElementNotFound
	}
	if anterior == nil {
		l.inicio = atual.proximo
	} else {
		anterior.proximo = atual.proximo
	}
	if atual == l.fim {
		l.fim = anterior
	}
	return nil
}
