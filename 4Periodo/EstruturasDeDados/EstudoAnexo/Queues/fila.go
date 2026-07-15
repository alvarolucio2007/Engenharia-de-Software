package main

import "errors"

func (f *Fila) EstaCheia() bool {
	return (f.ultimo-f.primeiro == f.maxItens)
}

func (f *Fila) EstaVazia() bool {
	return (f.primeiro == f.ultimo)
}

func (f *Fila) Push(item TipoItem) error {
	if f.EstaCheia() {
		return errors.New("FilaCheiaError")
	}
	f.estrutura[f.ultimo%f.maxItens] = item
	f.ultimo++
	return nil
}

func (f *Fila) Pop() (TipoItem, error) {
	if f.EstaVazia() {
		return 0, errors.New("FilaVaziaError")
	}
	val := f.estrutura[f.primeiro%f.maxItens]
	f.estrutura[f.primeiro] = 0
	f.primeiro++
	return val, nil
}

func (f *Fila) View() []TipoItem {
	if f.EstaVazia() {
		return []TipoItem{}
	}
	inicio := f.primeiro % f.maxItens
	fim := f.ultimo % f.maxItens
	if inicio < fim {
		return f.estrutura[inicio:fim]
	}
	result := make([]TipoItem, 0, f.ultimo-f.primeiro)
	result = append(result, f.estrutura[inicio:]...)
	result = append(result, f.estrutura[:fim]...)
	return result
}
