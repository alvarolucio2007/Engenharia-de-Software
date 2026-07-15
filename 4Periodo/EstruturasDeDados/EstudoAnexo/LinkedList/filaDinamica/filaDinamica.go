package main

import "errors"

func NewFilaDinamica() FilaDinamica {
	return FilaDinamica{primeiro: nil, ultimo: nil}
}

func (f *FilaDinamica) EstaVazia() bool {
	return f.tamanho == 0
}

func (f *FilaDinamica) Push(item TipoItem) {
	newNode := &Node{
		valor: item,
	}
	if f.ultimo == nil {
		f.primeiro = newNode
		f.ultimo = newNode
	} else {
		f.ultimo.proximo = newNode
		f.ultimo = newNode
	}
	f.tamanho++
}

func (f *FilaDinamica) Pop() (TipoItem, error) {
	if f.EstaVazia() {
		return 0, errors.New("PilhaVaziaError")
	}
	item := f.primeiro.valor
	f.primeiro = f.primeiro.proximo
	if f.primeiro == nil {
		f.ultimo = nil
	}
	f.tamanho--
	return item, nil
}

func (f *FilaDinamica) View() []TipoItem {
	tempNode := f.primeiro
	tamanho := f.QualTamanho()
	res := make([]TipoItem, 0, tamanho)
	for tempNode != nil {
		res = append(res, tempNode.valor)
		tempNode = tempNode.proximo
	}
	return res
}

func (f *FilaDinamica) QualTamanho() int {
	return f.tamanho
}
