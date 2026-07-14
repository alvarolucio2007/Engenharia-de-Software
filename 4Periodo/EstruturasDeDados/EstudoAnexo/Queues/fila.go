package main

import "errors"

func (f *Fila) EstaCheia() bool {
	return (f.ultimo-f.primeiro == maxItens)
}

func (f *Fila) EstaVazia() bool {
	return (f.primeiro == f.ultimo)
}

func (f *Fila) Push(item TipoItem) error {
	if f.EstaCheia() {
		return errors.New("FilaCheiaError")
	}
	f.estrutura[f.ultimo%maxItens] = item
	f.ultimo++
	return nil
}

func (f *Fila) Pop() (TipoItem, error) {
	if f.EstaVazia() {
		return 0, errors.New("FilaVaziaError")
	}
	val := f.estrutura[f.primeiro%maxItens]
	f.estrutura[f.primeiro] = 0
	f.primeiro++
	return val, nil
}

func (f *Fila) View() []TipoItem {
	return f.estrutura
}
